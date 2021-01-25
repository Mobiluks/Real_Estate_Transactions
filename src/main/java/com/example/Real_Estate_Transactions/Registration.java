package com.example.Real_Estate_Transactions;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Registration")
public class Registration extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DBWork dbw = new DBWork();
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String fullName = request.getParameter("fullName");
        String commission = request.getParameter("commission");
        String workTimeMonth = request.getParameter("workTimeMonth");
        if(request.getParameter("userLevel").equals("seller")){
            dbw.insertQuery("INSERT INTO client(email, password, fullname) VALUES ('" +
                    email + "', '" +
                    password + "', '" +
                    fullName + "');");
        } else if(request.getParameter("userLevel").equals("realtor")){
            dbw.insertQuery("INSERT INTO realtor(email, password, fullname, commission, work_time_month) VALUES ('" +
                    email + "', '" +
                    password + "', '" +
                    fullName + "', '" +
                    commission + "', '" +
                    workTimeMonth + "');");
        }
        getServletContext().getRequestDispatcher("/RegCongrats.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
