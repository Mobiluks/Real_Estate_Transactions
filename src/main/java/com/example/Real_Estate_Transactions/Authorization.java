package com.example.Real_Estate_Transactions;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "Authorization")
public class Authorization extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getParameter("login") != null){
            DBWork dbw = new DBWork();
            String email = request.getParameter("email");
            String passwordEntered = request.getParameter("password");
            HttpSession session = request.getSession();
            String passwordInDb = dbw.selectOneValFromOneRow("password", "client", "email", email);
            if(passwordInDb == null){
                passwordInDb = dbw.selectOneValFromOneRow("password", "realtor",  "email", email);
            }
            if(passwordEntered.equals(passwordInDb)){
                session.setAttribute("id_client", dbw.selectOneValFromOneRow("id_client",
                        "client", "email", email));
                session.setAttribute("clientFullName", dbw.selectOneValFromOneRow("fullname",
                        "client", "email", email));

                Cookie idClientCookie = new Cookie("id_client", dbw.selectOneValFromOneRow("id_client",
                        "client", "email", email));
                idClientCookie.setMaxAge(60 * 60 * 24);
                response.addCookie(idClientCookie);
                Cookie clientFullNameCookie = new Cookie("fullname", email);
                clientFullNameCookie.setMaxAge(60 * 60 * 24);
                response.addCookie(clientFullNameCookie);

                getServletContext().getRequestDispatcher("/PersonalRoom.jsp").forward(request,response);
            } else{
                request.setAttribute("authorizationError", "Неправильный логин или пароль");
                getServletContext().getRequestDispatcher("/Authorization.jsp").forward(request,response);
            }
        } else if(request.getParameter("register") != null){
                getServletContext().getRequestDispatcher("/Registration.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
