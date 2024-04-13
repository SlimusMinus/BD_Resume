package com.aston.krylov.repository;

import com.aston.krylov.entity.Resume;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FindAllResumes {
    private final Resume resume = new Resume();

    public List<Resume> findAll() {
        List<Resume> resumes = new ArrayList<>();
        String sql = "SELECT * FROM resume";
        try (Connection connection = DbConnection.getConnection(); PreparedStatement statement = connection.prepareStatement(sql); ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                resume.setName(resultSet.getString("name"));
                resume.setSurname(resultSet.getString("surname"));
                resume.setAge(resultSet.getInt("age"));
                resume.setEmail(resultSet.getString("email"));
                resume.setName_Work(resultSet.getString("name_Work"));
                resumes.add(resume);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return resumes;
    }
}
