import java.util.*;

class Product {
    double price;
    Product(double price){this.price=price;}
    double getPrice(){return price;}
}

class Mobile extends Product {
    Mobile(double price){super(price);}
}

class Laptop extends Product {
    Laptop(double price){super(price);}
}

public class Q10 {
    public static double calculateTotal(List<? extends Product> items) {
        double sum = 0;
        for(Product p: items) sum += p.getPrice();
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(calculateTotal(Arrays.asList(new Mobile(20000), new Mobile(15000))));
        System.out.println(calculateTotal(Arrays.asList(new Laptop(50000))));
    }
}