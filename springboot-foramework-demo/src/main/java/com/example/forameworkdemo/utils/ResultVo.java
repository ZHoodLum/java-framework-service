package com.example.forameworkdemo.utils;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class ResultVo<T> {

    private int code;

    // 是否成功标识.true表示成功,false表示失败
    private boolean success;

    // 操作成功时需要响应给客户端的响应数据
    private String msg;

    private T data;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date time;
    // 省略get/set
}