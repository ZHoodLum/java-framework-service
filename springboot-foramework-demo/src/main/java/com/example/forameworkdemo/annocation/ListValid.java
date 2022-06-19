package com.example.forameworkdemo.annocation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author：Psyduckzzzz
 * @Date：Created on 2022/6/3 0:03
 * @Description:
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {ListValidator.class})
public @interface ListValid {
    int min() default 0;

    int max() default Integer.MAX_VALUE;

    String message() default "";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
