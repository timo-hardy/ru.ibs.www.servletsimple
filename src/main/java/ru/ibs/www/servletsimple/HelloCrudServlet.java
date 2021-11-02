package ru.ibs.www.servletsimple;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ru.ibs.www.manager.Manager;

import java.io.*;

@WebServlet("/hello-crud")
public class CrudServlet extends HttpServlet {
    private final Gson gson = new Gson();
    private final static String filePath = "manager.json";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            JsonReader reader = new JsonReader(new FileReader(filePath));
            Manager managers = gson.fromJson(reader, Manager.class);
            PrintWriter out = resp.getWriter();
            resp.setContentType("application/json");
            resp.setCharacterEncoding("UTF-8");
            reader.close();
            out.print(managers.toString());
            out.flush();
        } catch (FileNotFoundException ex) {
            PrintWriter out = resp.getWriter();
            resp.setContentType("text/html");
            resp.setCharacterEncoding("UTF-8");
            out.print("file not found");
            out.flush();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Manager manager = new Manager(21, "Vasya", 50000);

        try {
            Writer writer = new FileWriter(filePath);
            new Gson().toJson(manager, writer);
            writer.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        Manager manager = new Manager(20, "Petya", 60000);
        try {
            Writer writer = new FileWriter(filePath);
            new Gson().toJson(manager, writer);
            writer.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        File file = new File("C:\\Users\\Admin\\IdeaProjects\\servlet\\manager.json");
        file.delete();
    }
}