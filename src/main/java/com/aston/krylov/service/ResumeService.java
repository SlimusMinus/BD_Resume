package com.aston.krylov.service;

import com.aston.krylov.dto.ResumeDTO;
import com.aston.krylov.entity.Resume;
import com.aston.krylov.mapper.ResumeMapper;
import com.aston.krylov.repository.DbConnection;
import com.aston.krylov.repository.ResumeRepository;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class ResumeService {
    private ResumeRepository resumeRepository = new ResumeRepository();
    private Connection connection = DbConnection.getConnection();

    public ResumeDTO createResume(ResumeDTO resumeDTO) {
        // Преобразование ResumeDTO в Resume
        Resume resume = ResumeMapper.fromDTO(resumeDTO);

        // Сохранение резюме в базе данных
        if (resume != null) {
            resume = resumeRepository.save(resume);
        }
        // Преобразование сохраненного Resume обратно в ResumeDTO
        return ResumeMapper.toDTO(resume);
    }

    public ResumeDTO getResume(Long id) {
        // Получение резюме из репозитория по идентификатору
        Resume resume = resumeRepository.findById(id);

        // Проверка, найдено ли резюме
        if (resume != null) {
            // Преобразование резюме в ResumeDTO
            return ResumeMapper.toDTO(resume);
        }
        return null; // Резюме не найдено или возникли ошибки
    }

    public List<ResumeDTO> getAllResumes() {
        List<ResumeDTO> resumes = new ArrayList<>();
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            statement = connection.prepareStatement("SELECT * FROM resume");
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                ResumeDTO resume = new ResumeDTO();
                resume.setName(resultSet.getString("name"));
                resume.setEmail(resultSet.getString("email"));
                resume.setAge(resultSet.getInt("age"));
                resume.setSurname(resultSet.getString("surname"));
                resume.setName_Work(resultSet.getString("name_work"));

                resumes.add(resume);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return resumes;
    }

    public void deleteResume(Long id) {
        resumeRepository.delete(id);
    }


    public void update(Resume resume) {
        resumeRepository.updateResume(resume);
    }
}
