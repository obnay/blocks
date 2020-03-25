package com.obnay.common.base;

import lombok.Data;

import java.io.Serializable;

/**
 * @author taoyanbo
 * @date 2020-03-24 16:54
 */
@Data
public class Result<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 成功标志
     */
    private boolean success = true;

    /**
     * 返回消息
     */
    private String message = "ok";

    /**
     * 返回代码
     */
    private Integer code = 0;

    /**
     * 返回数据对象 data
     */
    private T result;

    public Result() {

    }

    public Result<T> success(String message) {
        this.message = message;
        return this;
    }

    public Result<T> error(String message) {
        this.message = message;
        this.code = -1;
        this.success = false;
        return this;
    }
}
