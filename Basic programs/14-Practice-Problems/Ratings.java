import java.util.*;
import java.util.stream.*;

public class Ratings {
    public static void main(String[] args) {
        int[] oldRatings = {4, 5, 3};
        ArrayList<Integer> newRatings = new ArrayList<>(Arrays.asList(5, null, 4));
        List<Integer> all = new ArrayList<>();
        for (int r : oldRatings) all.add(r); // auto-boxing
        all.addAll(newRatings);
        double avg = all.stream()
                        .filter(Objects::nonNull)
                        .mapToInt(Integer::intValue)
                        .average().orElse(0);
        System.out.println("Average Rating = " + avg);
    }
}