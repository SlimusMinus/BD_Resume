package com.aston.krylov.service;

import com.aston.krylov.dto.ResumeDTO;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class SendResponse {
    public void sendResponse(HttpServletResponse resp, ResumeDTO resumeDTO) throws IOException {
        resp.setContentType("application/json");
        PrintWriter out = resp.getWriter();
        out.print(resumeDTO.toString());
        out.flush();
    }
}
