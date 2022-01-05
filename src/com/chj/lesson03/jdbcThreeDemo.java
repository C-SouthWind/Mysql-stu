package com.chj.lesson03;

import com.chj.lesson03.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class jdbcThreeDemo {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtils.getConnection();
            String sql = "select * from user where id = ?";
            st = conn.prepareStatement(sql);
            st.setInt(1,1);
            rs = st.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString("name"));
                System.out.println(rs.getString("pwd"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JdbcUtils.release(conn,st,rs);
        }

    }
    public static void main1(String[] args) {
        Connection conn = null;
        PreparedStatement st = null;
        try {
            conn = JdbcUtils.getConnection();
            String sql = "insert into user (`name`,`pwd`)values(?,?)";
            st = conn.prepareStatement(sql);
            st.setString(1,"123");
            st.setString(2,"456");
            //st.setDate(3,new java.sql.Date(new java.util.Date().getTime()));
            int i = st.executeUpdate();
            if (i>0) {
                System.out.println("插入成功");
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JdbcUtils.release(conn,st,null);
        }

    }
}
