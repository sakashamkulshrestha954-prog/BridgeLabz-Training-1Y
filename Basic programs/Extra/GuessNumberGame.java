import java.util.Scanner;
import java.util.Random;

public class GuessNumberGame {
    static int generateGuess(int low, int high, Random rand) {
        return rand.nextInt(high - low + 1) + low;
    }
    static String getFeedback(Scanner sc, int guess) {
        System.out.print("Is " + guess + " High, Low, or Correct? ");
        return sc.next().toLowerCase();
    }
    static int[] adjustRange(String feedback, int low, int high, int guess) {
        if (feedback.equals("high")) {
            high = guess - 1;
        } else if (feedback.equals("low")) {
            low = guess + 1;
        }
        return new int[]{low, high};
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        int low = 1, high = 100;
        String feedback = "";
        System.out.println("Think of a number between 1 and 100.");
        System.out.println("Respond with: High, Low, or Correct.\n");
        while (!feedback.equals("correct")) {
            int guess = generateGuess(low, high, rand);
            feedback = getFeedback(sc, guess)
            if (!feedback.equals("correct")) {
                int[] range = adjustRange(feedback, low, high, guess);
                low = range[0];
                high = range[1];
            }
        }
        System.out.println("Yay! I guessed your number correctly.");
    }
}
