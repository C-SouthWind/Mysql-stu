package com.chj.lesson01;

import java.sql.*;

//第一个jdbc程序
public class JdbcFirstDemo {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //1.加载驱动
        //DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        Class.forName("com.mysql.cj.jdbc.Driver");

        //2.用户信息和url
        String url = "jdbc:mysql://115.159.191.57:3306/zln?useSSL=true&amp&useUnicode=true&amp&characterEncoding=UTF-8&amp&serverTimezone=GMT%2B8";
        String username = "root";
        String password = "chj0526";
        //3.连接成功 数据库对象 Connection代表数据库
        Connection connection = DriverManager.getConnection(url, username, password);

        //4.执行sql的对象
        Statement statement = connection.createStatement();


        //5.执行sql的对象 去执行sql
        String sql = "select * from user";
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()){
            System.out.println("id=" + resultSet.getObject("id"));
            System.out.println("name=" + resultSet.getObject("name"));
            System.out.println("pwd=" + resultSet.getObject("pwd"));
        }
        //6.释放连接
        resultSet.close();
        statement.close();
        connection.close();
    }
}
