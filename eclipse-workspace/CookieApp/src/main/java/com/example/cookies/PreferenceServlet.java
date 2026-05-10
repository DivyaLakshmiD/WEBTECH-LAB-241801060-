package com.example.cookies;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class PreferenceServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String theme = request.getParameter("theme");
        String language = request.getParameter("language");

        Cookie themeCookie = new Cookie("theme", theme);
        Cookie languageCookie = new Cookie("language", language);

        themeCookie.setMaxAge(24 * 60 * 60);
        languageCookie.setMaxAge(24 * 60 * 60);

        response.addCookie(themeCookie);
        response.addCookie(languageCookie);

        response.sendRedirect("preferences");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String theme = "Light";
        String language = "English";

        Cookie[] cookies = request.getCookies();

        if (cookies != null) {
            for (Cookie c : cookies) {
                if ("theme".equals(c.getName())) theme = c.getValue();
                if ("language".equals(c.getName())) language = c.getValue();
            }
        }

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String bg = theme.equals("Dark") ? "black" : "white";
        String color = theme.equals("Dark") ? "white" : "black";

        out.println("<html><body style='background:" + bg + ";color:" + color + ";'>");
        out.println("<h2>Saved Preferences</h2>");
        out.println("Theme: " + theme + "<br>");
        out.println("Language: " + language + "<br><br>");
        out.println("<a href='preferences.html'>Change Preferences</a>");
        out.println("</body></html>");
    }
}