package com.obnay.block.sys.user.service;

import com.obnay.block.sys.user.entity.SysUser;
import com.obnay.block.sys.user.model.LoginModel;
import com.obnay.common.base.BaseService;
import com.obnay.common.base.Result;

/**
 * @author taoyanbo
 * @date 2020-03-22 00:53
 */
public interface SysUserService extends BaseService<SysUser> {

    /**
     * 根据账号查找
     *
     * @param loginName
     * @return
     */
    SysUser findByLoginNameOrMobile(String loginName);

    /**
     * 用户登陆
     *
     * @param loginModel
     * @return
     */
    Result login(LoginModel loginModel);

    /**
     * 用户登出
     *
     * @param userId
     */
    Result logout(String userId);
}
