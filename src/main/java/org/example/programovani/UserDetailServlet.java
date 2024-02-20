package org.example.programovani;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

@WebServlet(value = "/user")
public class UserDetailServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String idString = request.getParameter("id");

        if(idString == null || idString.isEmpty()){
            out.println("Ĺ patnĂˇ URL");
            return;
        }

        try{
            Integer.parseInt(idString);
        }catch (Exception e){
            out.println("Ĺ patnĂˇ URL");
            return;
        }

        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM user WHERE id=?")) {

            preparedStatement.setString(1, idString);
            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()){
                out.println(resultSet.getString("name"));
            }else{
                out.println("UĹľivatel nenalezen");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}