package org.example.programovani;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(value = "/insert")
public class InsertServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        String name = request.getParameter("val");

        PrintWriter out = response.getWriter();

        if(name == null){
            out.println("Chyba Povinne˝ GET parameter \"val\".");
            return;
        }

        String sql = "INSERT INTO user (name) VALUES (?)";

        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, name);
            preparedStatement.executeUpdate();

            out.println("Vloženo.");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}