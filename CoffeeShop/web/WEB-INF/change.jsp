<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 26.07.2016
  Time: 17:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Изменить заказ</title>
</head>
<body>
    <br>
    <form action="/change" method="POST">
        Сорт кофе:
        <select id="coffeeType" name="coffeeType" required>
            <option selected value="${order.coffeeType}">${order.coffeeType}</option>
            <option value="Kenyan Coffee">Kenyan Coffee</option>
            <option value="Tanzania Peaberry Coffee">Tanzania Peaberry Coffee</option>
            <option value="Ethiopian Coffee">Ethiopian Coffee</option>
            <option value="Sumatra Mandheling Coffee">Sumatra Mandheling Coffee</option>
            <option value="Italian Roast">Italian Roast</option>
        </select><br>
        Количество в граммах: <input id="amount" min="100" type="number" name="amount" value="${order.amount}" style="width: 103px"  step="0.1" required><br>
        Доставка:
        <input id="courier" type="radio" name="courier" value="courier" required>курьер</input>
        <input id="self-pick" type="radio" name="courier" value="self-pick" required>самостоятельно</input><br>
        Время с:
        <select id="fromTime" type="number" name="fromTime" required>
            <option selected value="${order.fromTime}">${order.fromTime}</option>
            <option value="9">9</option>
            <option value="10">10</option>
            <option value="11">11</option>
            <option value="12">12</option>
            <option value="13">13</option>
            <option value="14">14</option>
            <option value="15">15</option>
            <option value="16">16</option>
            <option value="17">17</option>
            <option value="18">18</option>
            <option value="19">19</option>
        </select>
        до:
        <select id="toTime" type="number" name="toTime" required>
            <option selected value="${order.toTime}">${order.toTime}</option>
            <option value="10">10</option>
            <option value="11">11</option>
            <option value="12">12</option>
            <option value="13">13</option>
            <option value="14">14</option>
            <option value="15">15</option>
            <option value="16">16</option>
            <option value="17">17</option>
            <option value="18">18</option>
            <option value="19">19</option>
            <option value="20">20</option>
        </select><br><br>
        <input type="submit" name="save" id="submit" value="Сохранить"><br>
    </form>
    <a href="main">
        <button type="button"><h3>Главная</h3></button>
    </a>
</body>
</html>
