package com.aston.krylov.repository;

import com.aston.krylov.entity.Resume;
import com.aston.krylov.entity.Work;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FindAllResumes {
    private final AddWorkForResume addWorkForResume = new AddWorkForResume();
    private List<Work> works;
    private final List<Resume> resumes = new ArrayList<>();

    public List<Resume> findAll() {

        String sqlAllResume = "SELECT * FROM resume";

        try (Connection connection = DbConnection.getConnection(); PreparedStatement statement = connection.prepareStatement(sqlAllResume); ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Resume resume = new Resume();
                long id = resultSet.getLong("resume_id");
                resume.setName(resultSet.getString("name"));
                resume.setSurname(resultSet.getString("surname"));
                resume.setAge(resultSet.getInt("age"));
                resume.setEmail(resultSet.getString("email"));

                works = new ArrayList<>();
                works = addWorkForResume.setWork(connection, id);
                resume.setWork(works);

                resumes.add(resume);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return resumes;
    }
}
