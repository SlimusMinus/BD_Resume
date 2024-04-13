package com.aston.krylov.controller;

import com.aston.krylov.dto.ResumeDTO;
import com.aston.krylov.service.GetResumeByIdService;
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
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String idParam = req.getParameter("id");


        if (idParam == null || idParam.isEmpty()) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            resp.getWriter().println("Resume ID not specified");
        } else {
            ResumeDTO resumeDTO = resumeService.getResume(Long.valueOf(idParam));
            sendResponse.sendResponse(resp, resumeDTO);
        }

    }

}
