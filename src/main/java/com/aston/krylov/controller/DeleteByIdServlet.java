package com.aston.krylov.controller;

import com.aston.krylov.service.GetAndDeleteService;
import com.aston.krylov.service.ServiceMethodsForServlet;
import com.aston.krylov.service.ServiceMethodsForServletInterface;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/resumes/clean/*")
public class DeleteByIdServlet extends HttpServlet {
    private GetAndDeleteService resumeService;
    private ServiceMethodsForServletInterface deleteMethodForServlet;

    @Override
    public void init() {
        try {
            Class.forName("org.postgresql.Driver");
            super.init();
        } catch (ClassNotFoundException | ServletException e) {
            throw new RuntimeException(e);
        }
        this.resumeService = new GetAndDeleteService();
        this.deleteMethodForServlet = new ServiceMethodsForServlet();
    }
    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String idParam = deleteMethodForServlet.extractIdFromPath(req.getPathInfo());
        deleteMethodForServlet.deleteResume(idParam, resp, resumeService);
    }

}
