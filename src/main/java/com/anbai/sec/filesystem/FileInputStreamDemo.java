package com.anbai.sec.filesystem;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;

public class FileInputStreamDemo {

    public static void main(String[] args) throws Exception {
        File file = new File("C:\\Users\\admin\\Desktop\\testdemo.txt");
        FileInputStream fis = new FileInputStream(file);

        int a = 0;
        byte[] bytes = new byte[1024];
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        while((a=fis.read(bytes)) != -1){
            out.write(bytes,0,a);
        }
        System.out.println(out);
    }
}
