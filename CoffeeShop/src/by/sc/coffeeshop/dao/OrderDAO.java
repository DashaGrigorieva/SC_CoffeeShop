package by.sc.coffeeshop.dao;

import by.sc.coffeeshop.order.CoffeeOrder;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 25.07.2016.
 */

public class OrderDAO {

    private Session session;

    public OrderDAO(Session session) {
        this.session = session;
    }


    private static List<CoffeeOrder> orders = new ArrayList<>();

    public void addOrder(CoffeeOrder coffeeOrder) {
        Transaction t = null;
        try {
            t = session.beginTransaction();
            session.save(coffeeOrder);
            t.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            t.rollback();
        }
    }

     
    public void updateOrder(CoffeeOrder coffeeOrder) {
        Transaction t = null;
        try {
            t = session.beginTransaction();
            session.update(coffeeOrder);
            t.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            t.rollback();
        }
    }
     
    public void deleteOrderById(int id) {
        CoffeeOrder coffeeOrder = (CoffeeOrder) session.load(CoffeeOrder.class, new Integer(id));
        if(coffeeOrder != null) {
            session.delete(coffeeOrder);
        }
    }

    public void deleteOrder(CoffeeOrder coffeeOrder) {
        Transaction t = null;
        try{
            t = session.beginTransaction();
            session.delete(coffeeOrder);
            t.commit();
        } catch(HibernateException e) {
            e.printStackTrace();
            t.rollback();
        }
    }

     
    public CoffeeOrder getOrderById(int id) {
        return (CoffeeOrder) session.load(CoffeeOrder.class, new Integer(id));
    }

     
    public List<CoffeeOrder> getOrders() {
        return (List<CoffeeOrder>) session.createQuery("FROM CoffeeOrder").list();
    }

    public int ordersCount() {
        return ((Long)session.createQuery("SELECT COUNT (*) FROM CoffeeOrder ").uniqueResult()).intValue();
    }

}
