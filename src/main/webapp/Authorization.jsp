<%--
  Created by IntelliJ IDEA.
  User: amedv
  Date: 18.01.2021
  Time: 14:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Авторизация</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/Authorization" method="post">
        <h1>Авторизация</h1>
        Почта:
        <input type="text" name="email"><br><br>
        Пароль:
        <input type="password" name="password"><br><br>
        <input type="submit" name="login" value="Подтвердить">
        <input type="submit" name="register" value="Зарегистрироваться">
        <%
            String errorMsg = (String)request.getAttribute("authorizationError");
            if(errorMsg != null){
                out.println("<h3 style=\"color:red\">" + errorMsg + "</h3>");
            }
        %>
    </form>
</body>
</html>
