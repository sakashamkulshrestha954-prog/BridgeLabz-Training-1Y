import java.util.*;

public class Q7 {
    public static void copyList(List<? super Number> dest, List<? extends Number> src) {
        dest.addAll(src);
    }

    public static void main(String[] args) {
        List<Number> dest = new ArrayList<>();
        List<Integer> src = Arrays.asList(1,2,3);
        copyList(dest, src);
        System.out.println(dest);
    }
}