package com.aston.krylov.service;

import com.aston.krylov.service.DeleteMethodForServlet;
import com.aston.krylov.service.DeleteResumeService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

class DeleteMethodForServletTest {

    @Test
    void testDeleteResumeWithValidId() throws IOException {
        // Создаем мок HttpServletResponse
        HttpServletResponse respMock = Mockito.mock(HttpServletResponse.class);

        // Создаем мок DeleteResumeService
        DeleteResumeService resumeServiceMock = Mockito.mock(DeleteResumeService.class);

        // Создаем экземпляр DeleteMethodForServlet
        DeleteMethodForServlet deleteMethodForServlet = new DeleteMethodForServlet();

        // Устанавливаем idParam, соответствующий допустимому ID
        String idParam = "123";

        // Создаем мок PrintWriter
        PrintWriter writerMock = Mockito.mock(PrintWriter.class);

        // Устанавливаем поведение мока writerMock
        Mockito.when(respMock.getWriter()).thenReturn(writerMock);

        // Вызываем метод deleteResume
        deleteMethodForServlet.deleteResume(idParam, respMock, resumeServiceMock);

        // Проверяем, что вызван метод deleteResume у resumeServiceMock с переданным id
        Mockito.verify(resumeServiceMock).deleteResume(123L);

        // Проверяем, что setStatus и getWriter были вызваны у respMock
        Mockito.verify(respMock).setStatus(HttpServletResponse.SC_OK);
        Mockito.verify(respMock).getWriter();
    }

}