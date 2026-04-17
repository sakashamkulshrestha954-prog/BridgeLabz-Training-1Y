import java.util.*;

class Animal {}
class Dog extends Animal {}
class Cat extends Animal {}

public class Q8 {
    public static void printAnimals(List<? extends Animal> animals) {
        for (Animal a : animals)
            System.out.println(a.getClass().getSimpleName());
    }

    public static void main(String[] args) {
        printAnimals(Arrays.asList(new Dog(), new Dog()));
        printAnimals(Arrays.asList(new Cat(), new Cat()));
    }
}