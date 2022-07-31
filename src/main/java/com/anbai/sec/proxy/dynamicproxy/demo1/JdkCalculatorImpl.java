package com.anbai.sec.proxy.dynamicproxy.demo1;

public class JdkCalculatorImpl implements JdkCalculator {

    @Override
    public Integer add(Integer num1, Integer num2) {
        Integer result = num1 + num2;
        return result;
    }
}