package com.anbai.sec.proxy.dynamicproxy.demo2;

public class Car implements IVehical {
    public void run() {
        System.out.println("Car会跑");
    }

    public void eat(){
        System.out.println("加油");
    }
}