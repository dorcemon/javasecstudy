package com.anbai.sec.serializes;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

//implements Serializable
class User implements Serializable {
    private int id;
    private String name;
    private String password;
    //......其他成员变量

    public User(int id,String name,String password){
        this.id=id;
        this.name=name;
        this.password=password;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    //自定义序列化
    private void writeObject(ObjectOutputStream out) throws IOException {
        //只序列化以下3个成员变量
        out.writeInt(id);
        out.writeObject(name);
        //写入反序后的密码，当然我们也可以使用其他加密方式。这样别人打开文件，看到的就不是真正的密码，更安全。
        out.writeObject(new StringBuffer(password).reverse());
    }

    //自定义反序列化。注意：read()的顺序要和write()的顺序一致。比如说序列化时写的顺序是id、name、password，反序列化时读的顺序也要是id、name、password。
    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        this.id=in.readInt();
        //readObject()返回的是Object，要强制类型转换
        this.name=(String)in.readObject();
        //反序才得到真正的密码
        StringBuffer pwd=(StringBuffer)in.readObject();
        this.password=pwd.reverse().toString();
    }

}
