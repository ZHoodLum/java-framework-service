package com.example.forameworkdemo.bean;

import com.example.forameworkdemo.annocation.ListValid;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.List;

/**
 * @ Author     ：Psyduckzzzz
 * @ Date       ：Created in 2019/8/23
 */

@Data
public class Dog {
    private String name;
    private Integer age;
        @NotEmpty(message = "不能为空--NotEmpty")
//    @ListValid(min = 1, message = "不能为空--ListValid")
    List<ValidationInfo> personList;
}
