package com.aston.krylov.controller;

import com.aston.krylov.service.GetAndDeleteService;
import com.aston.krylov.service.GetAndDeleteServiceInterface;
import com.aston.krylov.service.ServiceMethodsForServlet;
import com.aston.krylov.service.ServiceMethodsForServletInterface;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/resumes/*")
public class GetResumeByIdServlet extends HttpServlet {
    private GetAndDeleteService resumeService;
    private ServiceMethodsForServletInterface handlerIdFromServlet;

    @Override
    public void init() {
        try {
            Class.forName("org.postgresql.Driver");
            super.init();
        } catch (ClassNotFoundException | ServletException e) {
            throw new RuntimeException(e);
        }
        this.resumeService = new GetAndDeleteService();
        this.handlerIdFromServlet = new ServiceMethodsForServlet();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        String idParam = handlerIdFromServlet.extractIdFromPath(req.getPathInfo());
        handlerIdFromServlet.handlerId(idParam, resp, resumeService);
    }



}
