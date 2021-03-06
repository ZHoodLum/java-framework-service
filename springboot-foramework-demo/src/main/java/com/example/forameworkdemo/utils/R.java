package com.example.forameworkdemo.utils;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 响应信息主体
 *
 * @param <T> 数据类型
 * @author lengleng
 * @author wangxiaoquan
 */
public class R<T> {

    private static final long serialVersionUID = 1L;

    public static final int NO_LOGIN = -1;

    public static final String SUCCESS = "Success";

    public static final String FAIL = "Error";

    public static final int NO_PERMISSION = 2;

    private String msg = SUCCESS;

    private String code;

    private T data;

    public R() {
        super();
    }

    public R(T data) {
        super();
        this.data = data;
    }


    public R(T data, String msg) {
        super();
        this.data = data;
        this.msg = msg;
    }

    public R(String code, T data, String msg) {
        super();
        this.data = data;
        this.msg = msg;
        this.code = code;
    }

    public static <D> R<D> newSuccess() {
        return new R<>(SUCCESS, null, "操作成功！");
    }

    public static <D> R<D> newSuccess(D data) {
        return new R<>(SUCCESS, data, "操作成功！");
    }

    public static <D> R<D> newSuccess(String message,D data) {
        if (message == null) {
            message = "操作成功！";
        }
        R<D> r = newSuccess(data);
        r.setMsg(message);
        return r;
    }

    public static <D> R<D> newFailure() {
        return new R<>(FAIL, null, "操作失败！");
    }

    public static <D> R<D> newFailure(String message) {
        if (message == null) {
            message = "操作失败！";
        }
        R<D> r = newFailure();
        r.setMsg(message);
        return r;
    }


    public R<T> toSuccess() {
        this.code = SUCCESS;
        this.msg = "操作成功！";
        return this;
    }

    public R<T> toFailure() {
        this.code = FAIL;
        this.msg = "操作失败！";
        return this;
    }

    @JsonIgnore
    public boolean isSuccess() {
        return SUCCESS == code;
    }

    public String getMsg() {
        return msg;
    }

    public R<T> setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public String getCode() {
        return code;
    }

    public R<T> setCode(String code) {
        this.code = code;
        return this;
    }

    public T getData() {
        return data;
    }

    public R<T> setData(T data) {
        this.data = data;
        return this;
    }

}
