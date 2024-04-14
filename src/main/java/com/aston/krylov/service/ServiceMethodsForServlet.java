package com.aston.krylov.service;

import com.aston.krylov.dto.ResumeDTO;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ServiceMethodsForServlet implements ServiceMethodsForServletInterface{
    @Override
    public void deleteResume(String idParam, HttpServletResponse resp, GetAndDeleteService resumeService) throws IOException {
        if (idParam == null || idParam.isEmpty()) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            resp.getWriter().println("Resume ID not specified");
        }
        try {
            long id = Long.parseLong(idParam);
            resumeService.deleteResume(id);

            resp.setStatus(HttpServletResponse.SC_OK);
            resp.getWriter().println("Resume with " + id + " successfully delete");
        } catch (NumberFormatException e) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            resp.getWriter().println("Uncorrect format id resume");
        } catch (Exception e) {
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            resp.getWriter().println("Exception for delete resume: " + e.getMessage());
        }
    }

    @Override
    public void handlerId(String idParam, HttpServletResponse resp, GetAndDeleteService resumeService) {
        try {
            if (idParam == null || idParam.isEmpty()) {
                resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                resp.getWriter().println("Resume ID not specified");
            } else {
                ResumeDTO resumeDTO = resumeService.getResume(Long.valueOf(idParam));
                sendResponse(resp, resumeDTO);
            }
        }
        catch (IOException exception){
            System.out.println(exception.getMessage());
        }
    }

    @Override
    public void sendResponse(HttpServletResponse resp, ResumeDTO resumeDTO) throws IOException {
        resp.setContentType("application/json");
        PrintWriter out = resp.getWriter();
        out.print(resumeDTO.toString());
        out.flush();
    }
}
