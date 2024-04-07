package com.aston.krylov.controller;

import com.aston.krylov.service.ResumeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteById")
public class DeleteByIdServlet extends HttpServlet {

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
        // Получаем идентификатор резюме из параметра запроса id
        String idParam = req.getParameter("id");

        // Проверяем, что параметр id передан в запросе
        if (idParam == null || idParam.isEmpty()) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            resp.getWriter().println("Не указан идентификатор резюме");
            return;
        }

        try {
            long id = Long.parseLong(idParam);

            // Здесь вызываем ваш сервис или DAO для удаления резюме по идентификатору
            resumeService.deleteResume(id);

            resp.setStatus(HttpServletResponse.SC_OK);
            resp.getWriter().println("Резюме с идентификатором " + id + " успешно удалено");
        } catch (NumberFormatException e) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            resp.getWriter().println("Некорректный формат идентификатора резюме");
        } catch (Exception e) {
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            resp.getWriter().println("Ошибка при удалении резюме: " + e.getMessage());
        }
    }
}
