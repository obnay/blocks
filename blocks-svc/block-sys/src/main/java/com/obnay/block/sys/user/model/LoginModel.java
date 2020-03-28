package com.obnay.block.sys.user.model;

import lombok.Data;

/**
 * @author taoyanbo
 * @date 2020-03-28 15:15
 */
@Data
public class LoginModel {

    /**
     * 用户名
     */
    private String userName;

    /**
     * 密码
     */
    private String password;

    /**
     * 验证码
     */
    private String captcha;

    /**
     * 验证码key
     */
    private String verifyKey;

    /**
     * 短信验证码
     */
    private String smsVerifyCode;

    /**
     * 手机号码
     */
    private String mobile;
}
