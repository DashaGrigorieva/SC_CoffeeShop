import by.sc.coffeeshop.dao.OrderDAO;
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
 * Created by User on 27.07.2016.
 */
@WebServlet(name = "DeleteOrder", urlPatterns = "/delete")
public class DeleteOrder extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        int id = Integer.parseInt(request.getParameter("id"));

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        OrderDAO orderDAO = new OrderDAO(session);
        request.setAttribute("order", orderDAO.getOrderById(id));

        orderDAO.deleteOrder(orderDAO.getOrderById(id));

        request.getRequestDispatcher("WEB-INF/delete.jsp").forward(request, response);
    }
}
