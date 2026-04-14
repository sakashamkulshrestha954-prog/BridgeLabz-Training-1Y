import java.util.*;

public class MarksReport {
    public static void main(String[] args) {
        String[] inputs = {"85", "95", "null", "88"};
        List<Integer> marks = new ArrayList<>();
        for (String in : inputs) {
            try {
                if (!"null".equals(in)) marks.add(Integer.valueOf(in));
            } catch (Exception e) { /* ignore invalid */ }
        }
        double avg = marks.stream().mapToInt(Integer::intValue).average().orElse(0);
        System.out.println("Average Marks = " + avg);
    }
}