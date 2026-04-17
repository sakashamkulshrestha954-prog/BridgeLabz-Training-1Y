import java.util.*;

public class Q6 {
    public static double sumNumbers(List<? extends Number> list) {
        double sum = 0;
        for (Number n : list) sum += n.doubleValue();
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(sumNumbers(Arrays.asList(1,2,3)));
        System.out.println(sumNumbers(Arrays.asList(1.5,2.5)));
    }
}