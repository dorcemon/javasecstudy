package com.other.coll;

import org.junit.Test;

public class GenericClass<T,E> {
    private T a;
    private E b;

    public T getA() {
        return a;
    }

    public void setA(T a) {
        this.a = a;
    }

    public E getB() {
        return b;
    }

    public void setB(E b) {
        this.b = b;
    }

    @Test
    public void test1(){
        GenericClass<String,Integer> genericClass = new GenericClass<>();
        genericClass.setA("123");
        genericClass.setB(123);
    }
}
