package com.example.forameworkdemo.controller;

import com.example.forameworkdemo.bean.Dog;
import com.example.forameworkdemo.utils.R;
import com.example.forameworkdemo.utils.ResultVo;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author：Psyduckzzzz
 * @Date：Created on 2022/6/2 19:10
 * @Description:返回空数组或空值
 */

@RestController
public class GeneratorNullObjectController {

    @PostMapping("/getDogInfo")
    public R<Dog> getDogInfo(@RequestBody @Valid Dog dog) {
        return R.newSuccess(dog);
    }

    @GetMapping("/getDogInfo2")
    public R<Dog> getDogInfo2() {
        Dog dog = new Dog();
        dog.setAge(88);
        return R.newSuccess(dog);
    }

    @GetMapping("/getDogInfo3")
    public R<Map> getDogInfo3() {
        Map map = new HashMap();
        return R.newSuccess(map);
    }

    @GetMapping("/getDogInfo4")
    public R<List<Dog>> getDogInfo4() {
        List<Dog> list = new ArrayList<>();
//        Dog dog = new Dog();
//        list.add(dog);
        return R.newSuccess(list);
    }
}
