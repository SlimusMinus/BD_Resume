package com.aston.krylov.controller;

import com.aston.krylov.entity.Resume;
import com.aston.krylov.service.ResumeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/update")
public class UpdateResumeServlet extends HttpServlet {

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
        // Получаем данные для обновления резюме из параметров запроса
        long id = Long.parseLong(req.getParameter("id"));
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        int age = Integer.parseInt(req.getParameter("age"));
        String email = req.getParameter("email");
        String name_work = req.getParameter("name_work");


        // Создаем объект Resume на основе полученных данных
        Resume resume = new Resume();
        resume.setId(id); // Устанавливаем идентификатор резюме для обновления
        resume.setName(name);
        resume.setSurname(surname);
        resume.setAge(age);
        resume.setEmail(email);
        resume.setName_Work(name_work);

        // Здесь вызываем ваш сервис или DAO для обновления резюме
        resumeService.update(resume);

        // Возвращаем клиенту сообщение об успешном обновлении резюме
        resp.getWriter().println("Резюме успешно обновлено");
    }
}
