package com.aston.krylov.repository;

import com.aston.krylov.entity.Resume;
import lombok.Data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Data
public class UpdateResume {

    private final Resume resume = new Resume();

    public void updateResume(Resume resume) {
        String sql = "UPDATE resume SET name = ?, surname = ?, age = ?, email = ?, name_work = ? WHERE resume_id = ?";

        try (Connection connection = DbConnection.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, resume.getName());
            statement.setString(2, resume.getSurname());
            statement.setInt(3, resume.getAge());
            statement.setString(4, resume.getEmail());
            statement.setString(5, resume.getName_Work());
            statement.setLong(6, resume.getResumeId());

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated == 0) {
                throw new SQLException("Failed to update the resume with id " + resume.getResumeId());
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
