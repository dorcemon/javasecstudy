package com.anbai.sec.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MysqlInjection {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        // 1.正常登录方式
        //login("admin","123456");
        // 2.注入：'or '1=1
        login("'or '1=1","'or '1=1");
    }

    // 模拟登录业务
    public static void login(String username,String password) throws SQLException, ClassNotFoundException {

        Connection conn =null;
        Statement st =null;  // st对象！！！
        ResultSet rs =null;
        try {
            conn = JdbcUtil.getConnection(); // 连接数据库
            st = conn.createStatement();
            // select * from user where name ='admin' AND password= 123456
            String sql = "select * from user where name ='"+username+"' AND password = '"+ password+"'"; // 1.编写SQL
            System.out.println(sql);
            rs = st.executeQuery(sql); // 执行
            while (rs.next()) {
                System.out.println(rs.getString("name"));
                System.out.println(rs.getString("password"));
                System.out.println("===========================");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            JdbcUtil.closeAll( rs,st,conn);
        }
    }
}