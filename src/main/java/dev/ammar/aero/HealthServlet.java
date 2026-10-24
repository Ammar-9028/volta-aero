package dev.ammar.aero;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.Instant;

@WebServlet("/api/health")
public class HealthServlet extends HttpServlet {
    @Override protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        resp.setHeader("Cache-Control", "no-store");
        resp.getWriter().printf("{\"status\":\"UP\",\"app\":\"Volta Aero Showcase\",\"version\":\"1.0.0\",\"runtime\":\"Java 21 compatible\",\"timestamp\":\"%s\"}", Instant.now());
    }
}