package com.anbai.sec.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DefenseSQLInjection {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        //login("admin","123456");
        login("'or '1=1","'or '1=1");
    }

    public static void login(String username,String password) throws SQLException, ClassNotFoundException {
        Connection conn =null;
        PreparedStatement st =null;  // Statement改用PreparedStatement
        ResultSet rs =null;
        try {
            conn = JdbcUtil.getConnection(); // 连接数据库
            // String sql = "select * from user where id = ?"; // 1.编写SQL
            String sql = "select * from user where name =? AND password=?"; // 1.编写SQL
            System.out.println(sql);
            st = conn.prepareStatement(sql);        // 2.预编译(先写sql不执行)
            st.setString(1, username);  // 3.传递参数
            st.setString(2, password);
            rs = st.executeQuery();              // 4.执行
            while (rs.next()) {
                System.out.println(rs.getString("name"));
                System.out.println(rs.getString("password"));
                System.out.println("===========================");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            JdbcUtil.closeAll( rs,st,conn);  // 5.释放
        }
    }
}
