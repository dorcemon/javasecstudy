package com.other.reflect;

import java.io.*;
import java.lang.reflect.Constructor;

public class Teacher implements Cloneable, Serializable {

    private int id;

    public Teacher() {

    }

    public Teacher(Integer id) {
        this.id = id;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        // TODO Auto-generated method stub
        return super.clone();
    }

    @Override
    public String toString() {
        return "Teacher [id=" + id + "]";
    }

    public static void main(String[] args) throws Exception {

        System.out.println("使用new关键字创建对象：");
        Teacher tu1 = new Teacher(123);
        System.out.println(tu1);
        System.out.println("\n---------------------------\n");


        System.out.println("使用Class类的newInstance方法创建对象：");
        Teacher tu2 = Teacher.class.newInstance();    //对应类必须具有无参构造方法，且只有这一种创建方式
        System.out.println(tu2);
        System.out.println("\n---------------------------\n");

        System.out.println("使用Constructor类的newInstance方法创建对象：");
        Constructor<Teacher> constructor = Teacher.class
                .getConstructor(Integer.class);   // 调用有参构造方法
        Teacher tu3 = constructor.newInstance(123);
        System.out.println(tu3);
        System.out.println("\n---------------------------\n");

        System.out.println("使用Clone方法创建对象：");
        Teacher tu4 = (Teacher) tu3.clone();
        System.out.println(tu4);
        System.out.println("\n---------------------------\n");

        System.out.println("使用(反)序列化机制创建对象：");
        // 写对象
        ObjectOutputStream output = new ObjectOutputStream(
                new FileOutputStream("Teacher.bin"));
        output.writeObject(tu4);
        output.close();

        // 读取对象
        ObjectInputStream input = new ObjectInputStream(new FileInputStream(
                "Teacher.bin"));
        Teacher tu5 = (Teacher) input.readObject();
        System.out.println(tu5);

    }
}/* Output:
        使用new关键字创建对象：
        Teacher [id=123]

        ---------------------------

        使用Class类的newInstance方法创建对象：
        Teacher [id=0]

        ---------------------------

        使用Constructor类的newInstance方法创建对象：
        Teacher [id=123]

        ---------------------------

        使用Clone方法创建对象：
        Teacher [id=123]

        ---------------------------

        使用(反)序列化机制创建对象：
        Teacher [id=123]
*///:~