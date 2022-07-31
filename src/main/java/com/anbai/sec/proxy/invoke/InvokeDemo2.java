package com.anbai.sec.proxy.invoke;

import java.lang.reflect.Method;

public class InvokeDemo2 {
    public static void main(String[] args) throws Exception {
        // 获取Person的hello方法:
        Method h = Person2.class.getMethod("hello");
        // 对Student实例调用hello方法:
        h.invoke(new Student2());
    }
}

class Person2 {
    public void hello() {
        System.out.println("Person:hello");
    }
}

class Student2 extends Person2 {
    public void hello() {
        System.out.println("Student:hello");
    }
}
