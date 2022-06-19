package com.springcloud.handler;


/**
 * @Author:Psyduckzzzz
 * @Date:Created in 2021/3/3
 * @Description:
 */

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.springcloud.entity.CommonResult;

public class CustomerBlockHandler {

    public static CommonResult handleException(BlockException exception) {
        return new CommonResult(2020, "自定义限流处理信息....CustomerBlockHandler");

    }
}