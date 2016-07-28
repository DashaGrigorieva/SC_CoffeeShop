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
 * Created by User on 25.07.2016.
 */
@WebServlet(name = "Main", urlPatterns = "/main")
public class Main extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        OrderDAO orderDAO = new OrderDAO(session);
        request.setAttribute("count", orderDAO.ordersCount());

        request.getRequestDispatcher("WEB-INF/main.jsp").forward(request, response);
    }
}
