package com.sc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLUtil {

    /**
     * Statement 和 PreparedStatement之间的关系和区别.
     关系：PreparedStatement继承自Statement,都是接口
     区别：PreparedStatement可以使用占位符，是预编译的，批处理比Statement效率高
     */
    public static void conn() {
//        String URL = "jdbc:mysql://47.92.202.164:3306/simple_carbon" +
//                "?useUnicode=true&useJDBCCompliantTimezoneShift=true&serverTimezone=UTC&characterEncoding=utf8";
        String URL ="jdbc:mysql://localhost:3306/simple_carbon?useUnicode=true&useJDBCCompliantTimezoneShift=true&serverTimezone=UTC&characterEncoding=utf8";

        String USER = "root";
        String PASSWORD = "Qwj1605260500";
        // 1.加载驱动程序
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 2.获得数据库链接
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            // 3.通过数据库的连接操作数据库，实现增删改查（使用Statement类）

            System.out.println(conn.isClosed());

            // 关闭资源
            conn.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        conn();
    }

}
