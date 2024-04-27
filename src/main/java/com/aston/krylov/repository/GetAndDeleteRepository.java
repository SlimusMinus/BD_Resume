package com.aston.krylov.repository;

import com.aston.krylov.entity.Resume;
import com.aston.krylov.entity.Work;
import com.aston.krylov.service.CreateAndUpdateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GetAndDeleteRepository implements GetAndDeleteRepositoryInterface{ // репозитории нужно создавать под сущности а не методы
    private static final Logger log = LoggerFactory.getLogger(GetAndDeleteRepository.class);

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
        log.debug("Resume with {} id, was add {} work", id, works);
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
                    log.debug("Resume with {} id was requested");
                    return resume;
                }
            }
        } catch (SQLException e) {
            log.error("Runtime exception when was find by {} id", id);
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
                log.debug("All resumes was requested");
                resumes.add(resume);
            }
        } catch (SQLException e) {
            log.error("{} runtime exception when all resumes was requested", e.getMessage());
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
                log.error("Deleting resume failed, no rows affected");
                throw new SQLException("Deleting resume failed, no rows affected.");
            }
        } catch (SQLException e) {
            log.error("Runtime exception when was deleted by {} id", id);
            throw new RuntimeException(e);
        }
    }
}
