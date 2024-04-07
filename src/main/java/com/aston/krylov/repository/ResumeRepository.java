package com.aston.krylov.repository;

import com.aston.krylov.entity.Resume;
import lombok.Data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Data
public class ResumeRepository {

    private final Connection connection = DbConnection.getConnection();
    private final Resume resume = new Resume();

    public Resume findById(Long id) {
        String sql = "SELECT * FROM resume WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setLong(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    resume.setId(resultSet.getLong("id"));
                    resume.setName(resultSet.getString("name"));
                    resume.setSurname(resultSet.getString("surname"));
                    resume.setAge(resultSet.getInt("age"));
                    resume.setEmail(resultSet.getString("email"));
                    resume.setName_Work(resultSet.getString("name_Work"));
                    return resume;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    public List<Resume> findAll() {
        List<Resume> resumes = new ArrayList<>();
        String sql = "SELECT * FROM resume";
        try (PreparedStatement statement = connection.prepareStatement(sql); ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                resume.setId(resultSet.getLong("id"));
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

    public void delete(Long id) {
        String sql = "DELETE FROM resume WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setLong(1, id);
            int rowsAffected = statement.executeUpdate();
            if (rowsAffected == 0) {
                throw new SQLException("Deleting resume failed, no rows affected.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Resume save(Resume resume) {
        String sqlSave = "INSERT into resume (name, surname, age, email, name_Work) values (?, ?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(sqlSave, PreparedStatement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, resume.getName());
            statement.setString(2, resume.getSurname());
            statement.setInt(3, resume.getAge());
            statement.setString(4, resume.getEmail());
            statement.setString(5, resume.getName_Work());

            int affectRows = statement.executeUpdate();
            if (affectRows == 0) {
                throw new SQLException("Saving resume failed");
            }
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    resume.setId(generatedKeys.getLong(1));
                } else {
                    throw new SQLException("Saving resume failed, no ID obtained.");
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return resume;
    }


}
