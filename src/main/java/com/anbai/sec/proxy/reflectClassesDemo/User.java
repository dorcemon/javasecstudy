package com.anbai.sec.proxy.reflectClassesDemo;

@MyAnnotationA(eat = "吃饭", sleep = "sleep")
@MyAnnotationB(play = "玩游戏", run = "123")
public class User extends SuperUser implements InterfaceAAA,InterfaceBBB {
    public String username = "张三";
    public int password = 123456;

    @Override
    public Integer math() {
        return 100;
    }

    @Override
    public String english() {
        return "my english is very good";
    }

    @Override
    public Boolean isBaiCai() {
        return null;
    }

    @Override
    public String ant() {
        return "大蚂蚁";
    }
    //setter getter constructor toString ...


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }
}