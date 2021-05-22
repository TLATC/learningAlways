package com.shawn.learningalways.mybatisgenerator.service.impl;

import java.sql.*;

/**
 * JdbcTest
 * 测试jdbc
 *
 * @author Shawn Wu
 * @date 2021/5/22 14:31
 * @since
 */
public class JdbcTest {

    public static void main(String[] args) {
        String url = "jdbc:mysql://192.168.204.29:3306/boot_1003_zh?characterEncoding=utf8&useSSL=false&allowMultiQueries=true";
        String userName = "root";
        String passWord = "123456";
        String sql = "select * from t_im_dictionary";

        // 加载驱动
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            // 创建连接
            connection = DriverManager.getConnection(url, userName, passWord);
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                System.out.println("code=" + resultSet.getString("dictionaryCode") + "，"
                        + "value=" + resultSet.getString("dictionaryValue") + "，"
                        + "group=" + resultSet.getString("groupName") + "，"
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}