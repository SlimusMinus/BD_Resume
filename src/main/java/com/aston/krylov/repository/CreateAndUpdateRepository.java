package com.aston.krylov.repository;

import com.aston.krylov.entity.Resume;
import com.aston.krylov.entity.Work;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CreateAndUpdateRepository implements CreateAndUpdateRepositoryInterface{

    private static final Logger log = LoggerFactory.getLogger(CreateAndUpdateRepository.class);

    @Override
    public void saveResume(Resume resume) {
        String sqlSave = "INSERT into resume (name, surname, age, email) values (?, ?, ?, ?)";

        try (Connection connection = DbConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sqlSave)
        ) {
            statement.setString(1, resume.getName());
            statement.setString(2, resume.getSurname());
            statement.setInt(3, resume.getAge());
            statement.setString(4, resume.getEmail());

            int affectRows = statement.executeUpdate();
            if (affectRows == 0) {
                log.error("Saving {} resume failed", resume);
                throw new SQLException("Saving resume failed");
            }
            log.debug("{} resume was add in DB", resume);
        } catch (SQLException e) {
            log.error("{} runtime exception", e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Override
    public void saveWork(Work work) {
        String sqlSave = "INSERT into work (name, start_date, end_date, responsibilities, resume_id) values (?, ?, ?, ?, ?)";

        try (Connection connection = DbConnection.getConnection(); PreparedStatement statement = connection.prepareStatement(sqlSave)) {
            statement.setString(1, work.getName());
            statement.setDate(2, Date.valueOf(work.getStartDate()));
            statement.setDate(3,Date.valueOf(work.getEndDate()));
            statement.setString(4, work.getResponsibilities());
            statement.setLong(5, work.getResume_id());

            int affectRows = statement.executeUpdate();
            if (affectRows == 0) {
                log.error("Saving resume failed");
                throw new SQLException("Saving resume failed");
            }
            log.debug("{} work was add in DB", work);

        } catch (SQLException e) {
            log.error("{} exception", e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateResume(Resume resume) {
        String sql = "UPDATE resume SET name = ?, surname = ?, age = ?, email = ? WHERE resume_id = ?";

        try (Connection connection = DbConnection.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, resume.getName());
            statement.setString(2, resume.getSurname());
            statement.setInt(3, resume.getAge());
            statement.setString(4, resume.getEmail());
            statement.setLong(5, resume.getResumeId());

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated == 0) {
                log.debug("{} resume failed to update", resume);
                throw new SQLException("Failed to update the resume with id " + resume.getResumeId());
            }
        } catch (SQLException e) {
            log.error("{} exception", e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
