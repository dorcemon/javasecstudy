package com.anbai.sec.serializes;

import java.io.*;

public class Test {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        User zhangsan=new User(1,"张三","1234");

        //序列化
        ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream("./obj.txt"));
        //调用我们自定义的writeObject()方法
        out.writeObject(zhangsan);
        out.close();

        //反序列化
        ObjectInputStream in=new ObjectInputStream(new FileInputStream("./obj.txt"));
        //调用自定义的readObject()方法
        User user=(User)in.readObject();   //写掉了一句
        in.close();

        //测试
        System.out.println(user.getId());   //1
        System.out.println(user.getName());   //张三
        System.out.println(user.getPassword());   //1234
    }
}
