package com.example.forameworkdemo.annocation;

import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

@Component
public class ListValidator implements ConstraintValidator<ListValid, List> {

    private int minLength;
    private int maxLength;

    @Override
    public void initialize(ListValid listValid) {
        minLength = listValid.min();
        maxLength = listValid.max();
    }

    @Override
    public boolean isValid(List target, ConstraintValidatorContext constraintValidatorContext) {
        int size = null == target ? 0 : target.size();
        if (0 != minLength && null == target) {
            return false;//不允许为空，List为空
        }
        if (size < minLength) {
            return false;//长度小于最小值
        }
        if (0 != maxLength && size > maxLength) {
            return false;//指定最大长度，且长度大于最大值
        }
        return true;
    }

}