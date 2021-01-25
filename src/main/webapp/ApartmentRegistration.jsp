<%--
  Created by IntelliJ IDEA.
  User: amedv
  Date: 22.01.2021
  Time: 16:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Регистрация квартиры</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/ApartmentRegistration" method="post">
        ID клиента:
        <input type="text" disabled="disabled" name="clientIdForCreate" value="<%=session.getAttribute("id_client")%>"><br><br>
        ФИО клиента
        <input type="text" disabled="disabled" name="clientFullNameForCreate" value="<%=session.getAttribute("clientFullName")%>"><br><br>
        Квадратные метры:
        <input type="text" name="squareMetersForCreate"><br><br>
        Мебель:
        <input type="checkbox" id="furniture" name="furnitureForCreate"><br><br>
        Цена:
        <input type="text" name="apartmentPriceForCreate"><br><br>
        <input type="submit" name="submitCreatingApartment" value="Зарегистрировать">
    </form>
</body>
</html>
