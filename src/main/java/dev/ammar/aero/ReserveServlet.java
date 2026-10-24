package dev.ammar.aero;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet("/api/reserve")
public class ReserveServlet extends HttpServlet {
    @Override protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding(StandardCharsets.UTF_8.name());
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        String name = clean(req.getParameter("name"));
        String email = clean(req.getParameter("email"));
        if (name.isBlank() || email.isBlank() || !email.contains("@")) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            resp.getWriter().write("{\"ok\":false,\"message\":\"Please enter a name and valid email.\"}");
            return;
        }
        // Demo endpoint: deliberately does not store personal data.
        resp.getWriter().write("{\"ok\":true,\"message\":\"Thanks, " + json(name) + "! Your concept-drive request is noted for this demo.\"}");
    }
    private String clean(String value) { return value == null ? "" : value.trim(); }
    private String json(String value) {
        return value.replace("\\", "\\\\").replace("\"", "\\\"").replace("\n", " ").replace("\r", " ");
    }
}