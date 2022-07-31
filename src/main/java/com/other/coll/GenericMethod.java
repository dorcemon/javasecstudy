package com.other.coll;

import org.junit.Test;

public class GenericMethod {

    public static <T,E> E addUser(T t,E e){
        return e;
    }

    @Test
    public void test1() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Integer ix = GenericMethod.addUser("xxx", 123);
        String ggg = GenericMethod.addUser(123, "ggg");
        Class<?> aClass = Class.forName("com.anbai.sec.classloader.Test");
        Object o = aClass.newInstance();
        System.out.println(o);
        System.out.println(ix);
        System.out.println(ggg);
    }
}
