package by.sc.coffeeshop.order;

import javax.persistence.*;

/**
 * Created by User on 25.07.2016.
 */

@Entity
@Table(name = "orders")
public class CoffeeOrder {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "coffee_type")
    private String coffeeType;
    
    @Column(name = "amount")
    private double amount;
    
    @Column(name = "delivery")
    private boolean delivery;
    
    @Column(name = "from_time")
    private int fromTime;
    
    @Column(name = "to_time")
    private int toTime;
    
    @Column(name = "cost")
    private int cost;

    private final String type1 = "Kenyan Coffee";
    private final String type2 = "Tanzania Peaberry Coffee";
    private final static String type3 = "Ethiopian Coffee";
    private final static String type4 = "Sumatra Mandheling Coffee";
    private final static String type5 = "Italian Roast";

    public CoffeeOrder(String coffeeType, double amount, boolean delivery, int fromTime, int toTime, int cost) {
        this.coffeeType = coffeeType;
        this.amount = amount;
        this.delivery = delivery;
        this.fromTime = fromTime;
        this.toTime = toTime;
        this.cost = cost;
    }

    public CoffeeOrder(String coffeeType, double amount, boolean delivery, int fromTime, int toTime) {
        this.coffeeType = coffeeType;
        this.amount = amount;
        this.delivery = delivery;
        this.fromTime = fromTime;
        this.toTime = toTime;
        this.cost = calcCost();
    }

    public CoffeeOrder() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCoffeeType(String coffeeType) {
        this.coffeeType = coffeeType;
    }

    public void setAmount(double amount) {
        if (amount > 100) {
            this.amount = amount;
        }
    }

    public void setDelivery(boolean delivery) {
        this.delivery = delivery;
    }


    public void setFromTime(int fromTime) {
        this.fromTime = fromTime;
    }

    public void setToTime(int toTime) {
        this.toTime = toTime > fromTime ? toTime : (fromTime + 1);
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getId() {

        return id;
    }

    public String getCoffeeType() {
        return coffeeType;
    }

    public double getAmount() {
        return amount;
    }

    public boolean isDelivery() {
        return delivery;
    }

    public int getFromTime() {
        return fromTime;
    }

    public int getToTime() {
        return toTime;
    }

    public int getCost() {
        return cost;
    }

    public int calcCost() {
        int resultCost = 0;
        switch (coffeeType) {
            case type1: resultCost += 800;
                break;
            case type2: resultCost += 1000;
                break;
            case type3: resultCost += 600;
                break;
            case type4: resultCost += 700;
                break;
            case type5: resultCost += 900;
        }
        resultCost *= amount;
        if(delivery) {
            resultCost += 40000;
        }
        return resultCost;
    }

}
