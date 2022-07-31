package com.anbai.sec.proxy.dynamicproxy.demo1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JdkProxyFactory {

    /**
     * 维护一个目标对象
     */
    private Object target;

    public JdkProxyFactory(Object target) {
        this.target = target;
    }

    public Object getProxyInstance(){
        Object proxyClassObj = Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new InvocationHandler(){

                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("方法调用前，可以添加其他功能....");

                        // 执行目标对象方法
                        Object returnValue = method.invoke(target, args);
                        System.out.println("方法调用后，可以添加其他功能....");
                        return returnValue;
                    }
                });
        return proxyClassObj;
    }
}