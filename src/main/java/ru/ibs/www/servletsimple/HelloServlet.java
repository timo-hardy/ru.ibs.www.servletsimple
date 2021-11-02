package ru.ibs.www.servletsimple;

import com.google.gson.Gson;
import ru.ibs.www.manager.Manager;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private final Gson gson = new Gson();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        Manager managers = new Manager(
                22,
                "Vasya",
                50000
        );
    }
}