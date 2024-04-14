package com.aston.krylov.repository;

import com.aston.krylov.entity.Resume;
import com.aston.krylov.entity.Work;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface GetAndDeleteRepositoryInterface {
    public List<Work> setWork(Connection connection, Long id) throws SQLException;
    public Resume findById(Long id);
    public List<Resume> findAll();
    public void delete(Long id);
}
