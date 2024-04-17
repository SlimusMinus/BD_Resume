package com.aston.krylov.controller;

import com.aston.krylov.entity.Resume;
import com.aston.krylov.entity.Work;
import com.aston.krylov.service.CreateAndUpdateService;
import com.aston.krylov.service.CreateAndUpdateServiceInterface;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.w3c.dom.ls.LSOutput;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AddNewResumeServletTest {
    private HttpServletRequest req;
    private HttpServletResponse resp;
    private AddNewResumeServlet servlet;
    private CreateAndUpdateService resumeService;
    private Resume resume;
    private List<Work> list = new ArrayList<>();

    @BeforeEach
    void init(){
        req = Mockito.mock(HttpServletRequest.class);
        resp = Mockito.mock(HttpServletResponse.class);
        servlet = Mockito.mock(AddNewResumeServlet.class);
        resumeService = Mockito.mock(CreateAndUpdateService.class);
        resume = new Resume(1, "name", "surname", 20, "email", list);
    }

    @Test
    void doPost() throws IOException {
      /*  servlet.doPost(req, resp);
        resumeService.createResume(resume);
        Mockito.verify(resp).getWriter();*/
    }
}