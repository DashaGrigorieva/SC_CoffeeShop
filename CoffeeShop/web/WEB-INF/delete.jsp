<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 27.07.2016
  Time: 17:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Удалить заказ</title>
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
            </tr>
        </h3>
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
            <td>${order.cost}</td>
        </tr>
        <tr>
            <td colspan="6">
                <br>
                <a href="main"><button type="button"><h3>Удалить</h3></button></a>
            </td>
        </tr>
    </table>
</body>
</html>
