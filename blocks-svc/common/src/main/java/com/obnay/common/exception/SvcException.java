package com.obnay.common.exception;

import lombok.Data;

/**
 * 自定义异常
 *
 * @author taoyanbo
 * @date 2020-03-24 16:26
 */
@Data
public class SvcException extends Exception {

    private int code;
    private String message;

    public SvcException() {
        super();
    }

    public SvcException(String message) {
        super(message);
        this.message = message;
    }

    public SvcException(int code, String message) {
        super(message);
        this.message = message;
        this.code = code;
    }

    public SvcException(String message, Throwable cause, int code) {
        super(message, cause);
        this.code = code;
        this.message = message;
    }

    public SvcException(String message, Throwable cause) {
        super(message, cause);
        this.message = message;
    }
}
