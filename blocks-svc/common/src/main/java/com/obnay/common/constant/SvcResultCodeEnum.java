package com.obnay.common.constant;

/**
 * 系统状态码
 *
 * @author taoyanbo
 * @date 2020-03-28 16:09
 */
public enum SvcResultCodeEnum {

    ERR_NO_USER(-1001, "用户不存在"),
    ERR_INVALID_USER(-1002, "用户无效"),
    ERR_PASSWORD(-1003, "用户密码错误"),
    ERR_ENCRYPT(-1101, "加解密失败");

    private int code;
    private String message;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    SvcResultCodeEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
