package com.chj.lesson02;

import com.chj.lesson02.utils.JdbcUtils;

import java.sql.ResultSet;
import java.sql.SQLException;

public class jdbcTwoDemo {
    public static void main(String[] args) throws SQLException {
       JdbcUtils.SqlQuery("select * from user");
       JdbcUtils.SqlUpdate("insert into user (name,pwd)values('111','222')");
    }
}
