package com.luv2code.springdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

    public class testConn {
        public static void main(String[] args) {
            String url = "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false&serverTimezone=UTC";
            String username = "hbostudent";
            String password = "hbostudent";
            System.out.println("Connecting...");

            try (Connection connection = DriverManager.getConnection(url, username, password)) {
                System.out.println("Connection successful!");
            } catch (SQLException e) {
                System.out.println("Connection failed!");
                e.printStackTrace();
            }
        }
    }


