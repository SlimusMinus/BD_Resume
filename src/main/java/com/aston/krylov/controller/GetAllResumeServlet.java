package com.aston.krylov.controller;

import com.aston.krylov.dto.ResumeDTO;
import com.aston.krylov.service.GetAndDeleteService;
import com.aston.krylov.service.GetAndDeleteServiceInterface;
import com.aston.krylov.service.ServiceMethodsForServlet;
import com.aston.krylov.service.ServiceMethodsForServletInterface;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/getAll")
public class GetAllResumeServlet extends HttpServlet {
    private GetAndDeleteServiceInterface resumeService;
    private ServiceMethodsForServletInterface sendResponse;

    @Override
    public void init() {
        try {
            Class.forName("org.postgresql.Driver");
            super.init();
        } catch (ClassNotFoundException | ServletException e) {
            throw new RuntimeException(e);
        }
        this.resumeService = new GetAndDeleteService();
        this.sendResponse = new ServiceMethodsForServlet();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        List<ResumeDTO> resumes = resumeService.getAllResumes();
        for (ResumeDTO item : resumes) {
            try {
                sendResponse.sendResponse(resp, item);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
