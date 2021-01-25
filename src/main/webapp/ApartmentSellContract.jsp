<%@ page import="com.example.Real_Estate_Transactions.DBWork" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="java.sql.ResultSet" %><%--
  Created by IntelliJ IDEA.
  User: amedv
  Date: 22.01.2021
  Time: 16:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Заключение договора</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/ApartmentSellContract" method="post">
        Выберите квартиру:<br><br>
        <select multiple name="selectedApartmentId">
            <%
                DBWork dbw = new DBWork();
                try {
                    Statement st = dbw.con().createStatement();
                    ResultSet rs = st.executeQuery("SELECT * FROM apartments WHERE id_client = '" + session.getAttribute("id_client") + "';");
                    while (rs.next()){
                        out.println("<option value=\"" + rs.getString("id_apartment") + "\">ID квартири - " + rs.getString("id_apartment") +
                                "; ID клиента - " + rs.getString("id_client") +
                                "; ФИО клиента - " + rs.getString("client_fullname") +
                                "; Квадратные метры - " + rs.getString("square_meters") +
                                "; Мебель - " + rs.getString("furniture") +
                                "; Цена - " + rs.getString("price") +
                                "</option>");
                    }
                    rs.close();
                    st.close();
                    dbw.con().close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            %>
        </select><br><br>
        Выберите риэлтора:<br><br>
        <select multiple name="selectedRealtorId">
            <%
                try {
                    Statement st = dbw.con().createStatement();
                    ResultSet rs = st.executeQuery("SELECT * FROM realtor;");
                    while (rs.next()){
                        out.println("<option value=\"" + rs.getString("id_realtor") + "\">ID риэлтора - " + rs.getString("id_realtor") +
                                "; ФИО риэлтора - " + rs.getString("fullname") +
                                "; Комиссионное вознаграждение - " + rs.getString("commission") + "%" +
                                "; Примерное время поиска покупателя - " + rs.getString("work_time_month") +
                                "</option>");
                    }
                    rs.close();
                    st.close();
                    dbw.con().close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            %>
        </select><br><br>
        <input type="submit" name="submitContract" value="Подтвердить контракт">
    </form>
    <form action="${pageContext.request.contextPath}/ApartmentRegistration.jsp" method="post">
        <input type="submit" name="submitCreatingApartment" value="Зарегистрировать квартиру">
    </form>
</body>
</html>
