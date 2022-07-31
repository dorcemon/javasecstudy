package com.anbai.sec.filesystem;

import java.io.*;

public class RandomAccessFileDemo {

    public static void main(String[] args) {
        File file = new File("C:\\Users\\admin\\Desktop\\testdemo.txt");
        try {
            RandomAccessFile raf = new RandomAccessFile(file, "r");
            int a = 0;
            byte[] bytes = new byte[1024];

            ByteArrayOutputStream out = new ByteArrayOutputStream();

            while((a = raf.read(bytes)) != -1){
            out.write(bytes,0,a);
            }
            System.out.println(out);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
