package com.aston.krylov.repository;

import com.aston.krylov.entity.Work;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AddWorkForResume {
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
}
