import java.util.*;

class Vehicle {}
class Truck extends Vehicle {}
class Bike extends Vehicle {}

class FleetManager<T extends Vehicle> {
    List<T> list = new ArrayList<>();

    void addVehicle(T v){list.add(v);}
    void showFleet(){
        for(T v:list)
            System.out.println(v.getClass().getSimpleName());
    }
}

public class Q11 {
    public static void main(String[] args) {
        FleetManager<Truck> t = new FleetManager<>();
        t.addVehicle(new Truck());

        FleetManager<Bike> b = new FleetManager<>();
        b.addVehicle(new Bike());

        t.showFleet();
        b.showFleet();
    }
}