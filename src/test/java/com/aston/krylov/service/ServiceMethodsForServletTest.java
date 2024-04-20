package com.aston.krylov.service;

import com.aston.krylov.dto.ResumeDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static junit.framework.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Checking that")
class ServiceMethodsForServletTest {
    private ServiceMethodsForServlet methodsForServlet;
    private HttpServletResponse resp;
    private ResumeDTO resumeDTO;
    private GetAndDeleteService resumeService;

    @BeforeEach
    public void setUp() {
        resp = mock(HttpServletResponse.class);
        resumeDTO = new ResumeDTO("Ivan", "Petrov", 25, "123@rambler.ru");
        methodsForServlet = Mockito.mock(ServiceMethodsForServlet.class);
        resumeService = mock(GetAndDeleteService.class);
    }

    @Test
    @DisplayName("method deleteResume() called with correct parameters")
    void deleteResume() throws IOException {
        methodsForServlet.deleteResume("7", resp, resumeService);
        verify(methodsForServlet).deleteResume("7", resp, resumeService);
    }

    @Test
    @DisplayName("method handlerId() called with correct parameters")
    void handlerId() {
        methodsForServlet.handlerId("1", resp, resumeService);
        verify(methodsForServlet).handlerId("1", resp, resumeService);
    }

    @Test
    @DisplayName("method sendResponse() called with correct parameters")
    void sendResponse() throws IOException {
        methodsForServlet.sendResponse(resp, resumeDTO);
        Mockito.verify(methodsForServlet).sendResponse(resp, resumeDTO);
    }


}