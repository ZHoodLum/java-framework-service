package com.example.forameworkdemo.bean;

import com.sun.istack.internal.NotNull;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author：Psyduckzzzz
 * @Date：Created on 2022/6/2 20:22
 * @Description:
 */
@Data
public class ValidationInfo {
    @NotNull
    @NotBlank
    private String tdCode;
}
