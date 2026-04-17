class BookCategory {}
class ClothingCategory {}

class Product<T> {
    String name;
    double price;
    T category;

    Product(String name,double price,T category){
        this.name=name;
        this.price=price;
        this.category=category;
    }
}

public class Q13 {
    public static <T extends Product<?>> void applyDiscount(T p,double per){
        p.price -= p.price * per / 100;
        System.out.println(p.price);
    }

    public static void main(String[] args) {
        Product<BookCategory> b = new Product<>("Java Book",500,new BookCategory());
        applyDiscount(b,10);
    }
}