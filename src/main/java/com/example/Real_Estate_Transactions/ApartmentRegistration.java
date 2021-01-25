package com.example.Real_Estate_Transactions;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ApartmentCreating", value = "/ApartmentCreating")
public class ApartmentRegistration extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String idClient = (String)session.getAttribute("id_client");
        String clientFullName = (String)session.getAttribute("clientFullName");
        String squareMeters = request.getParameter("squareMetersForCreate");
        String furniture = "";
        try{
            if(request.getParameter("furnitureForCreate") != null){
                if(furniture.equals("on")){
                    furniture = "1";
                } else{
                    furniture = "0";
                }
            } else{
                furniture = "0";
            }
        } catch(NullPointerException e) {
            e.printStackTrace();
        }

        String price = request.getParameter("apartmentPriceForCreate");
        DBWork dbw = new DBWork();
        dbw.insertQuery("INSERT INTO apartments(id_client, client_fullname, square_meters, furniture, price) VALUES ('" +
                idClient + "', '" +
                clientFullName + "', '" +
                squareMeters + "', '" +
                furniture + "', '" +
                price +"');");
        getServletContext().getRequestDispatcher("/ApartmentSellContract.jsp").forward(request, response);
    }
}
