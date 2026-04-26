import java.util.*;
class Product {
    String name;
    double price;
    double rating;
    double discount;
    public Product(String name, double price, double rating, double discount) {
        this.name = name;
        this.price = price;
        this.rating = rating;
        this.discount = discount;
    }
    public String toString() {
        return name + " | Price: " + price +
                " | Rating: " + rating +
                " | Discount: " + discount + "%";
    }
}
public class EcommerceSorting {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Product("Laptop", 60000, 4.5, 10));
        products.add(new Product("Phone", 30000, 4.8, 20));
        products.add(new Product("Watch", 5000, 4.2, 15));
        System.out.println("Sort by Price:");
        products.sort((a, b) -> Double.compare(a.price, b.price));
        products.forEach(System.out::println);
        System.out.println("\nSort by Rating:");
        products.sort((a, b) -> Double.compare(b.rating, a.rating));
        products.forEach(System.out::println);
        System.out.println("\nSort by Discount:");
        products.sort((a, b) -> Double.compare(b.discount, a.discount));
        products.forEach(System.out::println);
    }
}