package com.aston.krylov.service;

import com.aston.krylov.dto.ResumeDTO;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HandlerIdFromServlet {
    public void handlerId(String idParam, HttpServletResponse resp,  GetResumeByIdService resumeService, SendResponse sendResponse) {
        try {
            if (idParam == null || idParam.isEmpty()) {
                resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                resp.getWriter().println("Resume ID not specified");
            } else {
                ResumeDTO resumeDTO = resumeService.getResume(Long.valueOf(idParam));
                sendResponse.sendResponse(resp, resumeDTO);
            }
        }
        catch (IOException exception){
            System.out.println(exception.getMessage());
        }
    }
}
