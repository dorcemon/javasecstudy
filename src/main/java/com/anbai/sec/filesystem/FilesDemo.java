package com.anbai.sec.filesystem;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FilesDemo {
    public static void main(String[] args) {
        Path path = Paths.get("C:\\Users\\admin\\Desktop\\testdemo.txt");

        try {
            byte[] bytes = Files.readAllBytes(path);
            System.out.println(new String(bytes));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
