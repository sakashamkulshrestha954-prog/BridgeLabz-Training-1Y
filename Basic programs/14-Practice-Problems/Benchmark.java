import java.util.*;

public class Benchmark {
    public static void main(String[] args) {
        int n = 1_000_000;

        long start = System.currentTimeMillis();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = i;
        long sum = 0;
        for (int v : arr) sum += v;
        System.out.println("int[] sum=" + sum + " time=" + (System.currentTimeMillis()-start));

        start = System.currentTimeMillis();
        ArrayList<Integer> list = new ArrayList<>(n);
        for (int i = 0; i < n; i++) list.add(i);
        sum = 0;
        for (int v : list) sum += v;
        System.out.println("ArrayList sum=" + sum + " time=" + (System.currentTimeMillis()-start));
    }
}