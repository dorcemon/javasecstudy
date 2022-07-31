package com.anbai.sec.url;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class URLConnectionDemo {
    public static void main(String[] args) throws IOException {
        URL url = new URL("https://www.baidu.com");

        // 打开和url之间的连接
        URLConnection connection = url.openConnection();

        // 设置请求参数
        connection.setRequestProperty("user-agent", "javasec");
        connection.setConnectTimeout(1000);
        connection.setReadTimeout(1000);


        // 建立实际连接
        connection.connect();

        // 获取响应头字段信息列表
        connection.getHeaderFields();

        // 获取URL响应
        connection.getInputStream();

        StringBuilder response = new StringBuilder();
        BufferedReader in = new BufferedReader(
                new InputStreamReader(connection.getInputStream()));
        String line;

        while ((line = in.readLine()) != null) {
            response.append("/n").append(line);
        }

        System.out.print(response.toString());
    }
}
