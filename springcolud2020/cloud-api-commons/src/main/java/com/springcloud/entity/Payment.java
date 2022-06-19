package com.springcloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @ Author     ：Psyduckzzzz
 * @ Date       ：Created in 2021/1/27
 */


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment implements Serializable {

    private Integer id;
    private String serial;
}
