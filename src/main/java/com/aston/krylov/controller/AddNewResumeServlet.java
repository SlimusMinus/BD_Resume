package com.aston.krylov.controller;

import com.aston.krylov.dto.ResumeDTO;
import com.aston.krylov.dto.WorkDTO;
import com.aston.krylov.entity.Resume;
import com.aston.krylov.entity.Work;
import com.aston.krylov.service.CreateResumeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/add")
public class AddNewResumeServlet extends HttpServlet {
    private CreateResumeService resumeService;

    @Override
    public void init() {
        try {
            Class.forName("org.postgresql.Driver");
            super.init();
        } catch (ClassNotFoundException | ServletException e) {
            throw new RuntimeException(e);
        }
        this.resumeService = new CreateResumeService();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        int age = Integer.parseInt(req.getParameter("age"));
        String email = req.getParameter("email");

        List<WorkDTO> workDTO = new ArrayList<>();
        ResumeDTO resume = new ResumeDTO(name, surname, age, email, workDTO);

        resumeService.createResume(resume);

        resp.getWriter().println("Resume add successfully");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
