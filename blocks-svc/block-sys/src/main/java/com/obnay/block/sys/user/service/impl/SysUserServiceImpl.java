package com.obnay.block.sys.user.service.impl;

import com.obnay.block.sys.shiro.jwt.JwtUtils;
import com.obnay.block.sys.user.entity.SysUser;
import com.obnay.block.sys.user.model.LoginModel;
import com.obnay.block.sys.user.repository.SysUserRepository;
import com.obnay.block.sys.user.service.SysUserService;
import com.obnay.common.base.BaseServiceImpl;
import com.obnay.common.base.Result;
import com.obnay.common.cache.CaffeineCache;
import com.obnay.common.constant.SvcResultCodeEnum;
import com.obnay.common.event.EntityEvent;
import com.obnay.common.utils.AesEncryptUtils;
import com.obnay.common.utils.PasswordUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author taoyanbo
 * @date 2020-03-22 00:54
 */
@Service
public class SysUserServiceImpl extends BaseServiceImpl<SysUser, SysUserRepository> implements SysUserService {

    private static final String PREFIX_USER_TOKEN = "PREFIX_USER_TOKEN_";

    @Override
    public void onEntityEvent(EntityEvent event) {
        super.onEntityEvent(event);
    }

    @Override
    public SysUser findByLoginNameOrMobile(String loginName) {
        return this.getRepository().findByLoginNameOrMobile(loginName, loginName);
    }

    @Override
    public Result login(LoginModel loginModel) {
        Result result = new Result();
        String userName = loginModel.getUserName();
        String password = loginModel.getPassword();

        if (StringUtils.isEmpty(userName) || StringUtils.isEmpty(password)) {
            result.error("用户名或密码不为空");
            return result;
        }
        SysUser currentUser = findByLoginNameOrMobile(userName);
        if (currentUser == null) {
            result.error("登录失败");
            result.setCode(SvcResultCodeEnum.ERR_NO_USER.getCode());
            return result;
        }
        if (currentUser.getStatus() != 1) {
            result.error("登录失败");
            result.setCode(SvcResultCodeEnum.ERR_INVALID_USER.getCode());
            return result;
        }

        try {
            password = AesEncryptUtils.desEncrypt(password);
        } catch (Exception e) {
            result.error("登录失败");
            result.setCode(SvcResultCodeEnum.ERR_ENCRYPT.getCode());
            return result;
        }

        String sysPassword = currentUser.getPassword();
        String userPassword = PasswordUtils.encrypt(userName, password, currentUser.getSalt());
        if (!sysPassword.equals(userPassword)) {
            result.error("登录失败");
            result.setCode(SvcResultCodeEnum.ERR_PASSWORD.getCode());
            return result;
        }

        String token = JwtUtils.sign(userName, sysPassword);
        String key = PREFIX_USER_TOKEN + userName;
        CaffeineCache.getInstance().getCache().put(key, token);
        Map<String, Object> userInfo = new HashMap<>(2);
        userInfo.put("token", token);
        userInfo.put("userInfo", currentUser);
        result.setResult(userInfo);
        return result;
    }

    @Override
    public Result logout(String userId) {
        return null;
    }
}
