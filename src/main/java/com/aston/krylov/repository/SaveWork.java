package com.aston.krylov.repository;

import com.aston.krylov.dto.WorkDTO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SaveWork {
    public void save(WorkDTO work) {
        String sqlSave = "INSERT into work (name, start_date, end_date, responsibilities, resume_id) values (?, ?, ?, ?, ?)";

        try (Connection connection = DbConnection.getConnection(); PreparedStatement statement = connection.prepareStatement(sqlSave)) {
            statement.setString(1, work.getName());
            statement.setDate(2, Date.valueOf(work.getStartDate()));
            statement.setDate(3,Date.valueOf(work.getEndDate()));
            statement.setString(4, work.getResponsibilities());
            statement.setLong(5, work.getResume_id());

            int affectRows = statement.executeUpdate();
            if (affectRows == 0) {
                throw new SQLException("Saving resume failed");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
