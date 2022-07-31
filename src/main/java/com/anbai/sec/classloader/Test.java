package com.anbai.sec.classloader;

import java.lang.reflect.Constructor;

public class Test {
    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> aClass = Class.forName("com.anbai.sec.classloader.ClassLoaderTest");
        //字节码对象.getXXs 复数形式，获取所有该对象的相关对象
        Constructor[] constructors = aClass.getConstructors();
        for (Constructor constructor: constructors) {
            System.out.println(constructor);
        }
    }
}
