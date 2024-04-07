package com.aston.krylov.controller;

import com.aston.krylov.dto.ResumeDTO;
import com.aston.krylov.service.ResumeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/getAll")
public class GetAllResumeServlet extends HttpServlet {
    private ResumeService resumeService;

    @Override
    public void init() throws ServletException {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        super.init();
        // Инициализация вашего сервиса резюме
        this.resumeService = new ResumeService();

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Получение всех резюме
        List<ResumeDTO> resumes = resumeService.getAllResumes();

        // Отправка данных о резюме в ответе
        sendResponse(resp, resumes);
    }

    private void sendResponse(HttpServletResponse resp, Object data) throws IOException {
        resp.setContentType("application/json");
        PrintWriter out = resp.getWriter();
        out.print(data.toString());
        out.flush();
    }

}
