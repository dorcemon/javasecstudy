package com.anbai.sec.cmd;

public class Hello {
    public native void helloFromCPP();
    static {
        System.load(System.getProperty("user.dir") + "\\src\\main\\java\\com\\anbai\\sec\\cmd\\hello.dll");
    }
}
