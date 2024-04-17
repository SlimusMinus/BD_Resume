package com.aston.krylov.repository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@DisplayName("Check that")
class DbConnectionTest {
    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String LOGIN = "postgres";
    private static final String PASSWORD = "root";
    @Test
    @DisplayName("connection at DB called with correct parameter")
    public void testGetConnection() throws SQLException {
        Connection connectionMock = mock(Connection.class);

        Mockito.mockStatic(DriverManager.class);
        when(DriverManager.getConnection(URL, LOGIN, PASSWORD)).thenReturn(connectionMock);

        Connection connection = DbConnection.getConnection();
        assertNotNull(connection);

        Mockito.verify(DriverManager.class);
        DriverManager.getConnection(URL, LOGIN, PASSWORD);
    }
}