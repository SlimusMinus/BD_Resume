package com.aston.krylov.mapper;

import com.aston.krylov.dto.ResumeDTO;
import com.aston.krylov.dto.WorkDTO;
import com.aston.krylov.entity.Resume;
import com.aston.krylov.entity.Work;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Checking that")
class ResumeAndWorkMapperTest {
    private final ResumeAndWorkMapper mapper = new ResumeAndWorkMapper();
    private final List<Work> works = new ArrayList<>();
    private final List<WorkDTO> worksDTO = new ArrayList<>();
    private final Resume resume = new Resume(1,"Ivan", "Petrov", 25, "123@rambler.ru", works);
    private final  ResumeDTO resumeDTO = new ResumeDTO("Ivan", "Petrov", 25, "123@rambler.ru", worksDTO);

    @Test
    @DisplayName("resume converted in resumeDTO")
    void resumeToDTO() {
        ResumeDTO newResumeDTO = mapper.resumeToDTO(resume);
        assertThat(newResumeDTO).isEqualTo(resumeDTO);
    }

    @Test
    @DisplayName("if in method resumeToDTO() put null then return null")
    void resumeNull(){
        Resume resumeNull = null;
        assertThat(mapper.resumeToDTO(resumeNull)).isNull();
    }

    @Test
    @DisplayName("work converted in workDTO")
    void workToDTO() {
        List<WorkDTO> newWorksDTO = mapper.workToDTO(works);
        assertThat(newWorksDTO).isEqualTo(worksDTO);
    }

    @Test
    @DisplayName("if in method workToDTO() put null then return null")
    void workNull(){
        List<Work> workNull = null;
        assertThat(mapper.workToDTO(workNull)).isNull();
    }

}