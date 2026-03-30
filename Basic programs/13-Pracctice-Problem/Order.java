import java.util.Date;

class Order {
    private int orderId;
    private String restaurantName;
    private int deliveryTime;
    private String deliveryType;

    public Order(int orderId, String restaurantName, int deliveryTime, String deliveryType) {
        this.orderId = orderId;
        this.restaurantName = restaurantName;
        this.deliveryTime = deliveryTime;
        this.deliveryType = deliveryType;
    }

    public int getOrderId() { return orderId; }
    public String getRestaurantName() { return restaurantName; }
    public int getDeliveryTime() { return deliveryTime; }
    public String getDeliveryType() { return deliveryType; }
}

class DeliveryAgent implements Runnable {
    private Order order;

    public DeliveryAgent(Order order) {
        this.order = order;
    }

    @Override
    public void run() {
        String agent = Thread.currentThread().getName();
        int priority = Thread.currentThread().getPriority();
        long startTime = System.currentTimeMillis();

        System.out.println("============================================================");
        System.out.println("  ORDER #" + order.getOrderId() + " | " + order.getDeliveryType().toUpperCase() + " DELIVERY");
        System.out.println("  Agent     : " + agent);
        System.out.println("  Restaurant: " + order.getRestaurantName());
        System.out.println("  Priority  : " + priority);
        System.out.println("  Est. Time : " + order.getDeliveryTime() + " seconds");
        System.out.println("  Started   : " + new Date());
        System.out.println("============================================================");

        try {
            System.out.println("[Order #" + order.getOrderId() + "] " + agent + " >> Status: PICKED UP from " + order.getRestaurantName());
            Thread.sleep(order.getDeliveryTime() * 1000L / 3);

            System.out.println("[Order #" + order.getOrderId() + "] " + agent + " >> Status: IN TRANSIT...");
            Thread.sleep(order.getDeliveryTime() * 1000L / 3);

            System.out.println("[Order #" + order.getOrderId() + "] " + agent + " >> Status: DELIVERED successfully!");
            Thread.sleep(order.getDeliveryTime() * 1000L / 3);

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        long endTime = System.currentTimeMillis();
        long totalTime = (endTime - startTime) / 1000;

        System.out.println("------------------------------------------------------------");
        System.out.println("  ORDER #" + order.getOrderId() + " COMPLETED");
        System.out.println("  Agent       : " + agent);
        System.out.println("  Type        : " + order.getDeliveryType());
        System.out.println("  Total Time  : " + totalTime + " seconds");
        System.out.println("  Completed At: " + new Date());
        System.out.println("------------------------------------------------------------\n");
    }
}

public class FoodDeliveryApp {
    public static void main(String[] args) {
        Order order1 = new Order(101, "Pizza Palace",   2, "Express");
        Order order2 = new Order(102, "Burger Barn",    4, "Standard");
        Order order3 = new Order(103, "Sushi Station",  6, "Economy");
        Order order4 = new Order(104, "Taco Town",      3, "Express");
        Order order5 = new Order(105, "Pasta Place",    5, "Standard");

        Thread agent1 = new Thread(new DeliveryAgent(order1), "Agent-Ravi");
        Thread agent2 = new Thread(new DeliveryAgent(order2), "Agent-Priya");
        Thread agent3 = new Thread(new DeliveryAgent(order3), "Agent-Arjun");
        Thread agent4 = new Thread(new DeliveryAgent(order4), "Agent-Meera");
        Thread agent5 = new Thread(new DeliveryAgent(order5), "Agent-Kiran");

        agent1.setPriority(10);
        agent2.setPriority(5);
        agent3.setPriority(3);
        agent4.setPriority(10);
        agent5.setPriority(5);

        System.out.println("############################################################");
        System.out.println("#          FOOD DELIVERY APPLICATION STARTED               #");
        System.out.println("############################################################");
        System.out.println("  Total Orders   : 5");
        System.out.println("  Express Orders : 2  (Priority 10)");
        System.out.println("  Standard Orders: 2  (Priority 5)");
        System.out.println("  Economy Orders : 1  (Priority 3)");
        System.out.println("  System Start   : " + new Date());
        System.out.println("############################################################\n");

        agent1.start();
        agent2.start();
        agent3.start();
        agent4.start();
        agent5.start();

        try {
            agent1.join();
            agent2.join();
            agent3.join();
            agent4.join();
            agent5.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted.");
        }

        System.out.println("############################################################");
        System.out.println("#       ALL ORDERS DELIVERED - SYSTEM SHUTDOWN             #");
        System.out.println("############################################################");
        System.out.println("  Completed At: " + new Date());
        System.out.println("############################################################");
    }
}
```

**Order & Agent Summary**

| Order # | Restaurant | Agent | Type | Priority | Est. Time |
|---|---|---|---|---|---|
| 101 | Pizza Palace | Agent-Ravi | Express | 10 | 2s |
| 102 | Burger Barn | Agent-Priya | Standard | 5 | 4s |
| 103 | Sushi Station | Agent-Arjun | Economy | 3 | 6s |
| 104 | Taco Town | Agent-Meera | Express | 10 | 3s |
| 105 | Pasta Place | Agent-Kiran | Standard | 5 | 5s |

**Delivery Status Flow**
```
PICKED UP  ──(1/3 of time)──►  IN TRANSIT  ──(1/3 of time)──►  DELIVERED