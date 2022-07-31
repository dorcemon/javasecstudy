package com.other.coll;

public class User {
    public User() {
    }

    public User(String name,int age) {
        System.out.println("我叫"+name);
        System.out.println("今年我"+age+"岁了");
    }

    String name;
    int age;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
