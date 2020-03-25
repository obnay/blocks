package com.obnay.block.sys.shiro.jwt;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * JWT Token
 *
 * @author taoyanbo
 * @date 2020-03-25 23:14
 */
public class JwtToken implements AuthenticationToken {

    private static final long serialVersionUID = 6250015164030030343L;

    private String token;

    public JwtToken(String token) {
        this.token = token;
    }

    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}
