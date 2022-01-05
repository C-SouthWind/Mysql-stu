package com.chj.lesson04;

import com.chj.lesson03.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class testTransaction {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtils.getConnection();
            //关闭数据库的自动提交，自动会开启事务
            conn.setAutoCommit(false);//开启事务

            String sql1 = "update account set money = money-100  where name = 'A';";
            st = conn.prepareStatement(sql1);
            st.executeUpdate();

            String sql2 = "update account set money = money+100  where name = 'B';";
            st = conn.prepareStatement(sql2);
            st.executeUpdate();
            int i = 1/0;
            //业务完毕，提交事务
            conn.commit();
            System.out.println("成功");

        } catch (SQLException throwables) {
            try {
                conn.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            System.out.println("失败");
            throwables.printStackTrace();
        }finally {
            JdbcUtils.release(conn,st,null);
        }
    }
}
