package com.example.helldivers.security;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CustomAccessDeniedHandler implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response,
                       AccessDeniedException ex) throws IOException {
        response.setStatus(403);
        response.setContentType("application/json");

        String body = """
                {
                  "status": 403,
                  "error": "Forbidden",
                  "message": "This endpoint is not permitted. Add it to SecurityConfig to allow access.",
                  "path": "%s"
                }
                """.formatted(request.getRequestURI());

        response.getWriter().write(body);
    }
}
