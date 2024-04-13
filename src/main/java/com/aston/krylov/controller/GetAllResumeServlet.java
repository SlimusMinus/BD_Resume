package com.aston.krylov.controller;

import com.aston.krylov.dto.ResumeDTO;
import com.aston.krylov.service.GetAllResumeService;
import com.aston.krylov.service.SendResponse;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/getAll")
public class GetAllResumeServlet extends HttpServlet {
    private GetAllResumeService resumeService;
    private SendResponse sendResponse;

    @Override
    public void init(){
        try {
            Class.forName("org.postgresql.Driver");
            super.init();
        } catch (ClassNotFoundException | ServletException e) {
            throw new RuntimeException(e);
        }

        this.resumeService = new GetAllResumeService();
        this.sendResponse = new SendResponse();

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        List<ResumeDTO> resumes = resumeService.getAllResumes();

        for (ResumeDTO item : resumes) {
            sendResponse.sendResponse(resp, item);
        }
    }

}
