package com.anbai.sec.cmd;

public class HelloTest {
    public static void main(String[] args) {
        System.out.println(System.getProperty("user.dir"));
        Hello h = new Hello();
        h.helloFromCPP();
    }
}
