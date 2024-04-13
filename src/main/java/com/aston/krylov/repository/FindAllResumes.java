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

    public List<Resume> findAll() {
        List<Resume> resumes = new ArrayList<>();
        List<Work> works;
        String sqlAllResume = "SELECT * FROM resume";
        String sqlAllWork = "SELECT * FROM work";

        try (Connection connection = DbConnection.getConnection(); PreparedStatement statement = connection.prepareStatement(sqlAllResume); ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Resume resume = new Resume();
                long id = resultSet.getLong("resume_id");
                resume.setName(resultSet.getString("name"));
                resume.setSurname(resultSet.getString("surname"));
                resume.setAge(resultSet.getInt("age"));
                resume.setEmail(resultSet.getString("email"));
                works = new ArrayList<>();
                //Проходим по циклу в таблице work
                try(PreparedStatement statement2 = connection.prepareStatement(sqlAllWork); ResultSet resultSet2 = statement2.executeQuery()){
                    while(resultSet2.next()){
                        Work work = new Work();
                        if(resultSet2.getLong("resume_id") == id){
                            System.out.println(resultSet2.getLong("resume_id"));
                            work.setName(resultSet2.getString("name"));
                            work.setStartDate((resultSet2.getDate("start_date")).toLocalDate());
                            work.setEndDate((resultSet2.getDate("end_date")).toLocalDate());
                            work.setResponsibilities(resultSet2.getString("responsibilities"));
                            works.add(work);
                        }
                    }
                }
                resume.setWork(works);
                resumes.add(resume);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return resumes;
    }
}
