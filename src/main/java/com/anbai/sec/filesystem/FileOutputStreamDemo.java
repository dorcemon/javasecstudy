package com.anbai.sec.filesystem;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class FileOutputStreamDemo {
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\admin\\Desktop\\testdemo.txt");

        String content = "Good,man!";
        FileOutputStream fos = new FileOutputStream(file);

        fos.write(content.getBytes());
        fos.flush();
        fos.close();
    }
}
