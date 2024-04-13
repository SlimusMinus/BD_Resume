package com.aston.krylov.repository;

import com.aston.krylov.dto.ResumeDTO;
import com.aston.krylov.entity.Resume;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SaveResume {
    public void save(ResumeDTO resume) {
        String sqlSave = "INSERT into resume (name, surname, age, email, name_Work) values (?, ?, ?, ?, ?)";

        try (Connection connection = DbConnection.getConnection(); PreparedStatement statement = connection.prepareStatement(sqlSave)) {
            statement.setString(1, resume.getName());
            statement.setString(2, resume.getSurname());
            statement.setInt(3, resume.getAge());
            statement.setString(4, resume.getEmail());
            statement.setString(5, resume.getName_Work());

            int affectRows = statement.executeUpdate();
            if (affectRows == 0) {
                throw new SQLException("Saving resume failed");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
