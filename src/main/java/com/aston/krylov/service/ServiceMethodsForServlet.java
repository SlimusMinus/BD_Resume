package com.aston.krylov.service;

import com.aston.krylov.dto.ResumeDTO;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ServiceMethodsForServlet implements ServiceMethodsForServletInterface{

    private static final Logger log = LoggerFactory.getLogger(ServiceMethodsForServlet.class);

    @Override
    public void deleteResume(String idParam, HttpServletResponse resp, GetAndDeleteService resumeService) throws IOException {
        if (idParam == null || idParam.isEmpty()) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            resp.getWriter().println("Resume ID not specified");
            log.warn("Resume with {} id not specified", idParam);
        }
        try {
            long id = Long.parseLong(idParam);
            resumeService.deleteResume(id);

            resp.setStatus(HttpServletResponse.SC_OK);
            resp.getWriter().println("Resume with " + id + " successfully delete");
            log.warn("Resume with {} id successfully delete", idParam);
        }
        catch (NumberFormatException e) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            resp.getWriter().println("Uncorrected format id resume");
            log.warn("Uncorrected format {} id resume", idParam);
        } catch (Exception e) {
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            resp.getWriter().println("Exception for delete resume: " + e.getMessage());
            log.error("{} exception for delete resume, idParam", e.getMessage());
        }
    }

    @Override
    public void handlerId(String idParam, HttpServletResponse resp, GetAndDeleteService resumeService) {
        try {
            if (idParam == null || idParam.isEmpty()) {
                resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                resp.getWriter().println("Resume ID not specified");
                log.warn("Resume {} id not specified", idParam);

            } else {
                ResumeDTO resumeDTO = resumeService.getResume(Long.valueOf(idParam));
                sendResponse(resp, resumeDTO);
                log.debug("Send response with {} resume", resumeDTO);
            }
        }
        catch (IOException exception){
            System.out.println(exception.getMessage());
            log.error("{} exception when send response", exception.getMessage());

        }
    }

    @Override
    public void sendResponse(HttpServletResponse resp, ResumeDTO resumeDTO) throws IOException {
        resp.setContentType("application/json");
        PrintWriter out = resp.getWriter();
        Gson gson = new Gson();
        String json = gson.toJson(resumeDTO);
        out.print(json);
        out.flush();
    }
    @Override
    public String extractIdFromPath(String pathInfo) {
        if (pathInfo == null || pathInfo.isEmpty()) {
            return null;
        }
        String[] parts = pathInfo.split("/");
        return parts[parts.length - 1];
    }
}
