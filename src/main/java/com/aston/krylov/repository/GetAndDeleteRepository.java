package com.aston.krylov.repository;

import com.aston.krylov.entity.Resume;
import com.aston.krylov.entity.Work;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GetAndDeleteRepository implements GetAndDeleteRepositoryInterface{

    @Override
    public List<Work> setWork(Connection connection, Long id) throws SQLException {
        List<Work> works = new ArrayList<>();
        String sqlAllWork = "SELECT * FROM work";
        try (PreparedStatement statement2 = connection.prepareStatement(sqlAllWork); ResultSet resultSet2 = statement2.executeQuery()) {
            while (resultSet2.next()) {
                Work work = new Work();
                if (resultSet2.getLong("resume_id") == id) {
                    work.setName(resultSet2.getString("name"));
                    work.setStartDate((resultSet2.getDate("start_date")).toLocalDate());
                    work.setEndDate((resultSet2.getDate("end_date")).toLocalDate());
                    work.setResponsibilities(resultSet2.getString("responsibilities"));
                    works.add(work);
                }
            }
        }
        return works;
    }

    @Override
    public Resume findById(Long id) {
        final Resume resume = new Resume();
        List<Work> works;
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
                    works = setWork(connection, id);
                    resume.setWork(works);

                    return resume;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    @Override
    public List<Resume> findAll() {
        List<Work> works;
        final List<Resume> resumes = new ArrayList<>();

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
                works = setWork(connection, id);
                resume.setWork(works);

                resumes.add(resume);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return resumes;
    }

    @Override
    public void delete(Long id) {
        String sql = "DELETE FROM resume WHERE resume_id = ?";
        try (Connection connection = DbConnection.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setLong(1, id);
            int rowsAffected = statement.executeUpdate();
            if (rowsAffected == 0) {
                throw new SQLException("Deleting resume failed, no rows affected.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
