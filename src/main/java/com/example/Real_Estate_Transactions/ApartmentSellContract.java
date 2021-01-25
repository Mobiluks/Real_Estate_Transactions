package com.example.Real_Estate_Transactions;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ApartmentSell", value = "/ApartmentSell")
public class ApartmentSellContract extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DBWork dbw = new DBWork();
        String id_apartment = request.getParameter("selectedApartmentId");
        String id_client = dbw.selectOneValFromOneRow("id_client", "apartments", "id_apartment", id_apartment);
        String clientFullName = dbw.selectOneValFromOneRow("client_fullname", "apartments", "id_apartment", id_apartment);
        String square_meters = dbw.selectOneValFromOneRow("square_meters", "apartments", "id_apartment", id_apartment);
        String furniture = dbw.selectOneValFromOneRow("furniture", "apartments", "id_apartment", id_apartment);
        String price = dbw.selectOneValFromOneRow("price", "apartments", "id_apartment", id_apartment);
        String id_realtor = request.getParameter("selectedRealtorId");
        String realtorFullName = dbw.selectOneValFromOneRow("fullname", "realtor", "id_realtor", id_realtor);
        String commission = dbw.selectOneValFromOneRow("commission", "realtor", "id_realtor", id_realtor);

        dbw.insertQuery("INSERT INTO contract(id_client, id_apartment, client_fullname, square_meters, furniture, price, id_realtor, realtor_fullname, commission) VALUES ('" +
                id_client + "', '" +
                id_apartment + "', '" +
                clientFullName + "', '" +
                square_meters + "', '" +
                furniture + "', '" +
                price + "', '" +
                id_realtor + "', '" +
                realtorFullName + "', '" +
                commission + "')");

        getServletContext().getRequestDispatcher("/PersonalRoom.jsp").forward(request, response);
    }
}
