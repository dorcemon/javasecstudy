package com.anbai.sec.filesystem;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessWriteFileDemo {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\admin\\Desktop\\testdemo.txt");
        String content = "I'm Coming!";

        try {
            RandomAccessFile raf = new RandomAccessFile(file, "rw");
            raf.write(content.getBytes());
            raf.close();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
