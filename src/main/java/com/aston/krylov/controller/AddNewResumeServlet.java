package com.aston.krylov.controller;

import com.aston.krylov.entity.Resume;
import com.aston.krylov.service.CreateAndUpdateService;
import com.aston.krylov.service.CreateAndUpdateServiceInterface;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/insert")
public class AddNewResumeServlet extends HttpServlet {
    private CreateAndUpdateServiceInterface resumeService;

    @Override
    public void init() {
        try {
            Class.forName("org.postgresql.Driver");
            super.init();
        } catch (ClassNotFoundException | ServletException e) {
            throw new RuntimeException(e);
        }
        this.resumeService = new CreateAndUpdateService();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        int age = Integer.parseInt(req.getParameter("age"));
        String email = req.getParameter("email");

        Resume resume = new Resume(name, surname, age, email);
        resumeService.createResume(resume);
        resp.getWriter().println("Resume add successfully");
    }

}
