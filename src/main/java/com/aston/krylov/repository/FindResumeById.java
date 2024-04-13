package com.aston.krylov.repository;

import com.aston.krylov.entity.Resume;
import com.aston.krylov.entity.Work;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FindResumeById {
    private final Resume resume = new Resume();
    private final AddWorkForResume addWorkForResume = new AddWorkForResume();
    private List<Work> works;

    public Resume findById(Long id) {
        String sql = "SELECT * FROM resume WHERE resume_id = ?";
        try (Connection connection = DbConnection.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setLong(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    resume.setResumeId(resultSet.getLong("resume_id"));
                    resume.setName(resultSet.getString("name"));
                    resume.setSurname(resultSet.getString("surname"));
                    resume.setAge(resultSet.getInt("age"));
                    resume.setEmail(resultSet.getString("email"));

                    works = new ArrayList<>();
                    works = addWorkForResume.setWork(connection, id);
                    resume.setWork(works);

                    return resume;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return null;
    }


}
