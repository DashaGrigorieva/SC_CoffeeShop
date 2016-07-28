import by.sc.coffeeshop.dao.OrderDAO;
import by.sc.coffeeshop.order.CoffeeOrder;
import by.sc.coffeeshop.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by User on 26.07.2016.
 */
@WebServlet(name = "ChangeOrder", urlPatterns = "/change")
public class ChangeOrder extends HttpServlet {

    private int currentId;
    private int currentCost;

    private void setCurrentId(int id) {
        currentId = id;
    }
    private void setCurrentCost(int currentCost) { this.currentCost = currentCost; }
    private int getCurrentId() { return currentId; }
    private  int getCurrentCost() {return currentCost;}

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        OrderDAO orderDAO = new OrderDAO(session);

        String coffeeType = request.getParameter("coffeeType");
        Double amount = Double.parseDouble(request.getParameter("amount"));
        Boolean delivery;
        String courier = request.getParameter("courier");
        if(courier.equals("courier") && courier != null) {
            delivery = true;
        }
        else {
            delivery = false;
        }
        int fromTime = Integer.parseInt(request.getParameter("fromTime"));
        int toTime = Integer.parseInt(request.getParameter("toTime"));

        if (currentId != 0) {
            CoffeeOrder coffeeOrder = orderDAO.getOrderById(currentId);
            coffeeOrder.setCoffeeType(coffeeType);
            coffeeOrder.setAmount(amount);
            coffeeOrder.setDelivery(delivery);
            coffeeOrder.setFromTime(fromTime);
            coffeeOrder.setToTime(toTime);
            coffeeOrder.setCost(coffeeOrder.calcCost());

            orderDAO.updateOrder(coffeeOrder);
        }
        else {
            CoffeeOrder coffeeOrder = new CoffeeOrder(coffeeType, amount, delivery, fromTime, toTime);
            coffeeOrder.setToTime(toTime);
            orderDAO.addOrder(coffeeOrder);
        }

        response.sendRedirect("/main");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        int id = Integer.parseInt(request.getParameter("id"));
        currentId = Integer.parseInt(request.getParameter("id"));

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        OrderDAO orderDAO = new OrderDAO(session);

        if(currentId != 0) {
            request.setAttribute("order", orderDAO.getOrderById(id));
        }
        request.getRequestDispatcher("WEB-INF/change.jsp").forward(request, response);
    }

}
