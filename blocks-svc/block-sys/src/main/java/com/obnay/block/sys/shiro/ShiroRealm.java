package com.obnay.block.sys.shiro;

import com.obnay.block.sys.shiro.jwt.JwtToken;
import com.obnay.block.sys.shiro.jwt.JwtUtils;
import com.obnay.block.sys.user.entity.SysUser;
import com.obnay.block.sys.user.service.SysUserService;
import com.obnay.common.cache.CaffeineCache;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.util.StringUtils;

/**
 * ShiroRealm
 *
 * @author taoyanbo
 * @date 2020-03-25 23:26
 */
@Slf4j
public class ShiroRealm extends AuthorizingRealm {

    private static final String PREFIX_USER_TOKEN = "PREFIX_USER_TOKEN_";

    @Autowired
    @Lazy
    private SysUserService userService;

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JwtToken;
    }

    /**
     * 授权方法
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        return info;
    }

    /**
     * 认证方法
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String token = (String) authenticationToken.getCredentials();
        if (StringUtils.isEmpty(token)) {
            throw new AuthenticationException("Token is null.");
        }
        String userName = JwtUtils.getUserName(token);

        if (StringUtils.isEmpty(userName)) {
            throw new AuthenticationException("Token invalid.");
        }
        SysUser user = userService.findByLoginNameOrMobile(userName);
        if (null == user) {
            throw new AuthenticationException("User does not exist.");
        }
        String key = PREFIX_USER_TOKEN + userName;
        String tokenCache = CaffeineCache.getInstance().getCache().getIfPresent(key);
        if (StringUtils.isEmpty(tokenCache)) {
            throw new AuthenticationException("Token invalid.");
        }
        //如果jwt的token失效，需要重新生存并刷新缓存中的token
        if (!JwtUtils.verify(token, userName, user.getPassword())) {
            String newToken = JwtUtils.sign(userName, user.getPassword());
            CaffeineCache.getInstance().getCache().put(key, newToken);
        }

        if (user.getStatus() != 1) {
            throw new AuthenticationException("Abnormal user status.");
        }
        return new SimpleAuthenticationInfo(user, token, getName());
    }
}
