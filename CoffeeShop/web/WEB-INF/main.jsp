<%@ page import="by.sc.coffeeshop.order.CoffeeOrder" %>
<%@ page import="javax.persistence.criteria.Order" %>
<%@ page import="by.sc.coffeeshop.dao.OrderDAO" %><%--
  Created by IntelliJ IDEA.
  User: User
  Date: 25.07.2016
  Time: 20:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Coffee Shop</title>
    <style>
        table, th, td {
            border-collapse: collapse;
            vertical-align: middle;
        }
        td {
            text-align: center;
        }
    </style>
</head>
<body>
    <br><br><br>
    <table style="width:100%">
        <tr>
            <td>
                <a href="change?id=0">
                    <button type="button"><h3>Новый  заказ</h3></button>
                </a>
            </td>
            <td>
                <a href="edit">
                    <button type="button"><h3>Редактировать</h3></button>
                </a>
            </td>
        </tr>
        <tr>
            <td colspan="2"; padding="1px";>
                <h2>
                    <span>Количество заказов : ${count}</span>
                </h2>
            </td>
        </tr>
    </table>
</body>
</html>
