package com.aston.krylov.repository;

import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Data
public class DbConnection {
    private static final Logger log = LoggerFactory.getLogger(DbConnection.class);

    private static Connection connection;
    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String LOGIN = "postgres";
    private static final String PASSWORD = "root";

    public static Connection getConnection() {
        try {
            connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
            log.debug("Connection is successfully");

        } catch (SQLException exception) {
            System.out.println("SQL got exception " + exception.getMessage());
            log.error("{} exception, bad connection to DB", exception.getMessage());
        }
        return connection;
    }
}
