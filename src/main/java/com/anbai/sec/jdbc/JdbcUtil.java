package com.anbai.sec.jdbc;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;

// SQL连接工具类
public class JdbcUtil {
    public static PreparedStatement pstmt = null ;  //这三个对象调用时，
    public static Connection connection = null ;  // 自己创建
    public static ResultSet rs = null ;
    public static Statement st =null;

    public static final String URL = "jdbc:mysql://localhost:3307/test";
    public static final String USER = "root";
    public static final String PWD = "8080";
    //导入驱动，加载具体的驱动类
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection(URL,USER,PWD);
    }
    //释放
    public static void closeAll(ResultSet rs,Statement stmt,Connection connection) {
        try {
            if (rs != null) rs.close();
            if (pstmt != null) pstmt.close();
            if (connection != null) connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}