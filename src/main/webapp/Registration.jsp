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
    <title>Регистрация</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/Registration" method="post">
        <h1>Регистрация</h1>
        Введите почту:
        <input type="text" name="email"><br><br>
        Кто вы:<br><br>
        <input type="radio" name="userLevel" id="seller" value="seller">
        <label for="seller">Продавец квартиры</label><br><br>
        <input type="radio" name="userLevel" id="realtor" value="realtor">
        <label for="realtor">Риэлтор</label><br><br>
        Введите комиссионное вознаграждение (проценты, целым числом):
        <input type="text" name="commission"><br><br>
        Введите примерное время поиска квартиры (месяцы):
        <input type="text" name="workTimeMonth"><br><br>
        Введите ваше ФИО:
        <input type="text" name="fullName"><br><br>
        Введите пароль:
        <input type="password" name="password"><br><br>
        Повторите пароль:
        <input type="password" name="secondPass"><br><br>
        <input type="submit" name="submitRegistration" value="Подтвердить">
    </form>
</body>
</html>
