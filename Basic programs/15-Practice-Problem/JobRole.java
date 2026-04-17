import java.util.*;

abstract class JobRole {}
class SoftwareEngineer extends JobRole {}
class DataScientist extends JobRole {}
class ProductManager extends JobRole {}

class Resume<T extends JobRole> {
    T role;
    Resume(T role){this.role=role;}
}

public class Q16 {
    static void screen(List<? extends JobRole> list){
        for(JobRole r:list)
            System.out.println(r.getClass().getSimpleName());
    }

    public static void main(String[] args) {
        screen(Arrays.asList(new SoftwareEngineer(), new DataScientist()));
    }
}