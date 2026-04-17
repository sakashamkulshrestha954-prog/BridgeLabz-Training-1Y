import java.util.*;

class Electronics {
    String name;
    Electronics(String name){this.name=name;}
    public String toString(){return name;}
}

class Clothing {
    String name;
    Clothing(String name){this.name=name;}
    public String toString(){return name;}
}

class Cart<T> {
    List<T> items = new ArrayList<>();

    void addItem(T item){items.add(item);}
    void removeItem(T item){items.remove(item);}
    void displayItems(){System.out.println(items);}
}

public class Q9 {
    public static void main(String[] args) {
        Cart<Electronics> c1 = new Cart<>();
        c1.addItem(new Electronics("Laptop"));

        Cart<Clothing> c2 = new Cart<>();
        c2.addItem(new Clothing("Shirt"));

        c1.displayItems();
        c2.displayItems();
    }
}