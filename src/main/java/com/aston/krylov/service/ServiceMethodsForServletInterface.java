package com.aston.krylov.service;

import com.aston.krylov.dto.ResumeDTO;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface ServiceMethodsForServletInterface {
    public void deleteResume(String idParam, HttpServletResponse resp, GetAndDeleteService resumeService) throws IOException;
    public void handlerId(String idParam, HttpServletResponse resp,  GetAndDeleteService resumeService);
    public void sendResponse(HttpServletResponse resp, ResumeDTO resumeDTO) throws IOException;
    public String extractIdFromPath(String pathInfo);
}
