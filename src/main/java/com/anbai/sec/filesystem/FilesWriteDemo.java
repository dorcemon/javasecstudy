package com.anbai.sec.filesystem;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FilesWriteDemo {
    public static void main(String[] args) {
        Path path = Paths.get("C:\\Users\\admin\\Desktop\\testdemo.txt");

        String content = "dorcemon";

        try {
            Files.write(path,content.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
