package com.example.Real_Estate_Transactions;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.*;

@WebServlet(name = "StartPage")
public class StartPage extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] clientCookies = request.getCookies();
        HttpSession session = request.getSession();
        DBWork dbw = new DBWork();
        for(Cookie cookie: clientCookies){
            if(cookie.getName().equals("id_client")){
                String id_client = cookie.getValue();
                session.setAttribute("id_client", id_client);
                session.setAttribute("clientFullName", dbw.selectOneValFromOneRow("fullname",
                        "client", "id_client", id_client));
                getServletContext().getRequestDispatcher("/PersonalRoom.jsp").forward(request, response);
                return;
            }
        }
        getServletContext().getRequestDispatcher("/Authorization.jsp").forward(request, response);
    }
}
