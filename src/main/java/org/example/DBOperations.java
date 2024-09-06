package org.example;

import java.net.UnknownServiceException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBOperations {


    //DB connection


    static final String URL = "jdbc:mysql://localhost:3306/BANK";
    static final String USER = "root";
    static final String PASSWORD = "Rspy7210";


    public static Connection connection;

    {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
