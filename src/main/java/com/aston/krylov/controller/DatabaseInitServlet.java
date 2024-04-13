package com.aston.krylov.controller;

import com.aston.krylov.repository.DbConnection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

@WebServlet(name = "DatabaseInitServlet", urlPatterns = "/init", loadOnStartup = 1)
public class DatabaseInitServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        super.init();

        try (Connection connection = DbConnection.getConnection()) {
            Class.forName("org.postgresql.Driver");
            Statement statement = connection.createStatement();

            String createTableSQL = "CREATE TABLE IF NOT EXISTS resume (resume_id SERIAL PRIMARY KEY,\n" +
                    "    name VARCHAR(255) NOT NULL,\n" +
                    "    surname VARCHAR(255) NOT NULL,\n" +
                    "    age INT NOT NULL,\n" +
                    "    email VARCHAR(255) NOT NULL,\n" +
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
                    "    FOREIGN KEY (resume_id) REFERENCES resume(resume_id) ON DELETE CASCADE\n" +
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
    }
}
