package com.anbai.sec.unsafe;

import com.google.gson.internal.UnsafeAllocator;

public class Student  {
    private Student() {
        throw new IllegalArgumentException("can not create.");
    }
    public String name;


    //通过Google中Gson库的UnsafeAllocator来绕过构造器创建类实例
    public static void main(String[] args) throws Exception {
        Student student = UnsafeAllocator.create().newInstance(Student.class);
        System.out.println(student);
        student.name = "落花滿天蔽月光，借一杯附薦鳳臺上";
        System.out.println(student.name);
    }
}


