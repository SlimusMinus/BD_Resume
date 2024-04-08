package com.aston.krylov.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

@WebServlet(name = "DatabaseInitServlet", urlPatterns = "/init", loadOnStartup = 1)
public class DatabaseInitServlet extends HttpServlet {
    private static Connection connection;
    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String LOGIN = "postgres";
    private static final String PASSWORD = "root";

    @Override
    public void init() throws ServletException {
        super.init();

        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
            Statement statement = connection.createStatement();

            // SQL-запрос для создания таблицы
            String createTableSQL = "CREATE TABLE IF NOT EXISTS resume (resume_id SERIAL PRIMARY KEY,\n" +
                    "    name VARCHAR(255) NOT NULL,\n" +
                    "    surname VARCHAR(255) NOT NULL,\n" +
                    "    age INT NOT NULL,\n" +
                    "    email VARCHAR(255) NOT NULL,\n" +
                    "    name_work VARCHAR(255),\n" +
                    "    CONSTRAINT unique_name_surname_age UNIQUE (name, surname, age)\n" +
                    ");";
            statement.execute(createTableSQL);

            String createTableSQL2 = "CREATE TABLE IF NOT EXISTS work (\n" +
                    "    work_id SERIAL PRIMARY KEY,\n" +
                    "    name VARCHAR(255) NOT NULL,\n" +
                    "    start_date DATE NOT NULL,\n" +
                    "    end_date DATE NOT NULL,\n" +
                    "    responsibilities TEXT,\n" +
                    "    resume_id BIGINT,\n" +
                    "    FOREIGN KEY (resume_id) REFERENCES resume(resume_id)\n" +
                    ");";
            statement.execute(createTableSQL2);

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Пустой метод doGet
    }
}
