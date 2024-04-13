package com.aston.krylov.service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteMethodForServlet {

    public void deleteResume(String idParam, HttpServletResponse resp, DeleteResumeService resumeService) throws IOException {

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
}
