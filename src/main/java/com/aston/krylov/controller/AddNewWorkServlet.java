package com.aston.krylov.controller;

import com.aston.krylov.dto.WorkDTO;
import com.aston.krylov.service.CreateWorkService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet("/addWork")
public class AddNewWorkServlet extends HttpServlet {
    private CreateWorkService createWorkService;

    @Override
    public void init() {
        try {
            Class.forName("org.postgresql.Driver");
            super.init();
        } catch (ClassNotFoundException | ServletException e) {
            throw new RuntimeException(e);
        }
        this.createWorkService = new CreateWorkService();
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        String name = req.getParameter("name");
        LocalDate start_date = LocalDate.parse(req.getParameter("start_date"));
        LocalDate end_date = LocalDate.parse(req.getParameter("end_date"));
        String responsibilities = req.getParameter("responsibilities");
        long resume_id = Long.parseLong(req.getParameter("resume_id"));

        WorkDTO workDTO = new WorkDTO(name, start_date, end_date, responsibilities, resume_id);

        createWorkService.createResume(workDTO);

        resp.getWriter().println("Work add successfully");
    }

}
