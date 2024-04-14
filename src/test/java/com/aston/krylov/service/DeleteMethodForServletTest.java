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
        // ������� ��� HttpServletResponse
        HttpServletResponse respMock = Mockito.mock(HttpServletResponse.class);

        // ������� ��� DeleteResumeService
        DeleteResumeService resumeServiceMock = Mockito.mock(DeleteResumeService.class);

        // ������� ��������� DeleteMethodForServlet
        DeleteMethodForServlet deleteMethodForServlet = new DeleteMethodForServlet();

        // ������������� idParam, ��������������� ����������� ID
        String idParam = "123";

        // ������� ��� PrintWriter
        PrintWriter writerMock = Mockito.mock(PrintWriter.class);

        // ������������� ��������� ���� writerMock
        Mockito.when(respMock.getWriter()).thenReturn(writerMock);

        // �������� ����� deleteResume
        deleteMethodForServlet.deleteResume(idParam, respMock, resumeServiceMock);

        // ���������, ��� ������ ����� deleteResume � resumeServiceMock � ���������� id
        Mockito.verify(resumeServiceMock).deleteResume(123L);

        // ���������, ��� setStatus � getWriter ���� ������� � respMock
        Mockito.verify(respMock).setStatus(HttpServletResponse.SC_OK);
        Mockito.verify(respMock).getWriter();
    }

}