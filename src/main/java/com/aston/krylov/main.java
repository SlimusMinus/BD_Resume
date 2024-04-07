package com.aston.krylov;

import com.aston.krylov.entity.Resume;
import com.aston.krylov.entity.Work;
import com.aston.krylov.repository.ResumeRepository;
import com.aston.krylov.service.ResumeService;

import java.time.LocalDate;

public class main {
    public static void main(String[] args) {
        /*Work work = new Work("OMON", LocalDate.of(2013, 10, 10), LocalDate.of(2021, 10, 10), "input people");
        Resume resume = new Resume("Pol", "Rad", 22, "pol@gmail.com", "Marvel", work);
        ResumeRepository resumeRepository = new ResumeRepository();
       resumeRepository.save(resume);*/

        ResumeService resumeService = new ResumeService();
        resumeService.deleteResume(2L);
        System.out.println(resumeService.getAllResumes());
    }
}
