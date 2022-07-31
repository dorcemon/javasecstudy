package com.anbai.sec.proxy.dynamicproxy.demo2;

import java.lang.reflect.Proxy;

public class App {
    public static void main(String[] args) {
        Car car = new Car();
        car.eat();


        IVehical vehical = (IVehical) Proxy.newProxyInstance(car.getClass().getClassLoader(), new Class[]{IVehical.class}, new VehicalInvacationHandler(car));
        System.out.println(Car.class.getInterfaces());

/*        for (Class aClass : new Class[]{Car.class,IVehical.class
        }) {
            System.out.println(aClass);
        }*/


        for (Class<?> anInterface : Car.class.getInterfaces()) {
            System.out.println(anInterface);
        }


        System.out.println(new Class[]{Car.class, IVehical.class});


        System.out.println(new Class[]{IVehical.class});
        vehical.run();
    }
}
