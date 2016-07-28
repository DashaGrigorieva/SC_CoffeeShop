<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 26.07.2016
  Time: 10:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<html>
<head>
    <title>Редактировать</title>
    <style>
        table, th, td {
            border-collapse: collapse;
            vertical-align: middle;
        }
        td, th {
            text-align: center;
        }
    </style>
</head>
<body>
    <br><br><br>
    <table style="width:100%">
        <h3>
            <tr>
                <th># заказа</th>
                <th>Сорт</th>
                <th>Количество</th>
                <th>Курьер</th>
                <th>Время</th>
                <th>Стоимость</th>
                <th colspan="2"></th>
            </tr>
        </h3>
        <c:forEach items="${requestScope.orders}" var="order">
            <tr>

                <td>${order.id}</td>
                <td>${order.coffeeType}</td>
                <td>${order.amount}г</td>
                <td>
                    <c:choose>
                        <c:when test="${order.delivery eq true}">
                            +
                        </c:when>
                        <c:otherwise>
                            -
                        </c:otherwise>
                    </c:choose>
                </td>
                <td>c${order.fromTime}до${order.toTime}</td>
                <td>${order.cost}р.</td>
                <td>
                    <a href="change?id=${order.id}">Редактировать</a>
                </td>
                <td>
                    <a href="delete?id=${order.id}">Удалить</a>
                </td>
            </tr>
        </c:forEach>
        <tr>
            <td colspan="8">
                <br>
                <a href="main">
                    <button type="button"><h3>Главная</h3></button>
                </a>
            </td>
        </tr>
    </table>
</body>
</html>
