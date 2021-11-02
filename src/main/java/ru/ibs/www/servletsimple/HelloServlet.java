package ru.ibs.www.servletsimple;

import com.google.gson.Gson;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ru.ibs.www.manager.Manager;

import java.io.*;


@WebServlet("/hello-servlet")
public class HelloServlet extends HttpServlet {
    private final Gson gson = new Gson();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        Manager managers = new Manager(
                22,
                "Vasya",
                50000
        );
        String managersJson = this.gson.toJson(managers);
        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out.print(managersJson);
        out.flush();
    }
}