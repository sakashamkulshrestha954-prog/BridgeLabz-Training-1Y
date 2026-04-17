class Fruit {}
class Apple extends Fruit {}
class Mango extends Fruit {}

class FruitBox<T extends Fruit> {
    T item;

    void add(T item) {
        this.item = item;
    }

    void display() {
        System.out.println(item.getClass().getSimpleName());
    }
}

public class Q5 {
    public static void main(String[] args) {
        FruitBox<Apple> box = new FruitBox<>();
        box.add(new Apple());
        box.display();
    }
}