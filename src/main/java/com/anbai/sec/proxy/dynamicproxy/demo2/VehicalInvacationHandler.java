package com.anbai.sec.proxy.dynamicproxy.demo2;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class VehicalInvacationHandler implements InvocationHandler {

    private final IVehical vehical;

    public VehicalInvacationHandler(IVehical vehical) {
        this.vehical = vehical;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("---------before-------");
        Object invoke = method.invoke(vehical,args);
        System.out.println("---------after-------");

        return invoke;

    }
}