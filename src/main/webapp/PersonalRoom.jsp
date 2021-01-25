<%@ page import="com.example.Real_Estate_Transactions.DBWork" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.SQLException" %><%--
  Created by IntelliJ IDEA.
  User: amedv
  Date: 18.01.2021
  Time: 15:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Личный кабинет</title>
</head>
<body>
<h1>Личный кабинет</h1>
<h3>Список заключенных уговоров:</h3>
<div style="overflow: auto; height:300px">
    <%
        DBWork dbw = new DBWork();
        try {
            Statement st = dbw.con().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM contract WHERE id_client = '" + session.getAttribute("id_client") + "';");
            while (rs.next()){
                out.println("<div style=\"border: 2px solid black; padding: 10px\">ID Контракта - " + rs.getString("id_contract") +
                        ";<br>ID клиента - " + rs.getString("id_client") +
                        "; ID квартиры - " + rs.getString("id_apartment") +
                        "; ФИО клиента - " + rs.getString("client_fullname") +
                        "; Квадратные метры - " + rs.getString("square_meters") +
                        "; Мебель - " + rs.getString("furniture") +
                        "; Цена - " + rs.getString("price") +
                        ";<br>ID риэлтора - " + rs.getString("id_realtor") +
                        "; ФИО риэлтора - " + rs.getString("realtor_fullname") +
                        "; Комиссионное вознаграждение - " + rs.getString("commission") +
                        "</div><br>");
            }
            rs.close();
            st.close();
            dbw.con().close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    %>
</div><br>
<form action="${pageContext.request.contextPath}/ApartmentSellContract.jsp" method="post">
    <input type="submit" name="submitSellApartment" value="Продать квартиру">
</form>
</body>
</html>