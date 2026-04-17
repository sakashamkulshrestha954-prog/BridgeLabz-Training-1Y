import java.util.*;

abstract class WarehouseItem {}
class Electronics extends WarehouseItem {}
class Groceries extends WarehouseItem {}
class Furniture extends WarehouseItem {}

class Storage<T extends WarehouseItem> {
    List<T> items = new ArrayList<>();

    void add(T item){items.add(item);}
    List<T> getItems(){return items;}
}

public class Q12 {
    static void show(List<? extends WarehouseItem> list){
        for(WarehouseItem i:list)
            System.out.println(i.getClass().getSimpleName());
    }

    public static void main(String[] args) {
        Storage<Electronics> s = new Storage<>();
        s.add(new Electronics());
        show(s.getItems());
    }
}