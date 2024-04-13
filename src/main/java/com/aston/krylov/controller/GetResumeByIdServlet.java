package com.aston.krylov.controller;

import com.aston.krylov.dto.ResumeDTO;
import com.aston.krylov.service.GetResumeByIdService;
import com.aston.krylov.service.HandlerIdFromServlet;
import com.aston.krylov.service.SendResponse;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/get")
public class GetResumeByIdServlet extends HttpServlet {
    private GetResumeByIdService resumeService;
    private SendResponse sendResponse;
    private HandlerIdFromServlet handlerIdFromServlet;

    @Override
    public void init() {
        try {
            Class.forName("org.postgresql.Driver");
            super.init();
        } catch (ClassNotFoundException | ServletException e) {
            throw new RuntimeException(e);
        }
        this.resumeService = new GetResumeByIdService();
        this.sendResponse = new SendResponse();
        this.handlerIdFromServlet = new HandlerIdFromServlet();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        String idParam = req.getParameter("id");
        handlerIdFromServlet.handlerId(idParam, resp, resumeService, sendResponse);
    }

}
