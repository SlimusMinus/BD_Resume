package com.aston.krylov.controller;

import com.aston.krylov.dto.ResumeDTO;
import com.aston.krylov.dto.WorkDTO;
import com.aston.krylov.entity.Resume;
import com.aston.krylov.entity.Work;
import com.aston.krylov.service.ResumeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet("/add")
public class AddNewResumeServlet extends HttpServlet {

    //http://localhost:28087/add?name=Tim&surname=Cook&age=54&email=123@gmail.com&nameWork=Apple&startDate=1998-10-10&endDate=2022-10-10&responsibilities=Manager

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
        // Получаем данные о новом резюме из параметров запроса
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        int age = Integer.parseInt(req.getParameter("age"));
        String email = req.getParameter("email");
        String nameWork = req.getParameter("name_work");


        // Создаем объект Resume на основе полученных данных
        ResumeDTO resume = new ResumeDTO();
        resume.setName(name);
        resume.setSurname(surname);
        resume.setAge(age);
        resume.setEmail(email);
        resume.setName_Work(nameWork);


        resumeService.createResume(resume);


        // Возвращаем клиенту сообщение об успешном добавлении резюме
        resp.getWriter().println("Резюме успешно добавлено");
    }

}
