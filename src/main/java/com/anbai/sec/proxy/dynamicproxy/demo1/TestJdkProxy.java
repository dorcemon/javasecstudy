package com.anbai.sec.proxy.dynamicproxy.demo1;

public class TestJdkProxy {

    public static void main(String[] args) {
        //目标对象
        JdkCalculator target = new JdkCalculatorImpl();
        System.out.println(target.getClass());
        //代理对象
        JdkCalculator proxyClassObj = (JdkCalculator) new JdkProxyFactory(target).getProxyInstance();
        System.out.println(proxyClassObj.getClass());
        //执行代理方法
        Integer result = proxyClassObj.add(1,2);
        System.out.println("相加结果：" + result);
    }

}
