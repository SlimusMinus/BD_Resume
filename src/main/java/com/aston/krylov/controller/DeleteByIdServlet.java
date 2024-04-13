package com.aston.krylov.controller;

import com.aston.krylov.service.DeleteMethodForServlet;
import com.aston.krylov.service.DeleteResumeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteById")
public class DeleteByIdServlet extends HttpServlet {

    private DeleteResumeService resumeService;
    private DeleteMethodForServlet deleteMethodForServlet;

    @Override
    public void init() {
        try {
            Class.forName("org.postgresql.Driver");
            super.init();
        } catch (ClassNotFoundException | ServletException e) {
            throw new RuntimeException(e);
        }
        this.resumeService = new DeleteResumeService();
        this.deleteMethodForServlet = new DeleteMethodForServlet();
    }
    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        String idParam = req.getParameter("id");
        deleteMethodForServlet.deleteResume(idParam, resp, resumeService);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
