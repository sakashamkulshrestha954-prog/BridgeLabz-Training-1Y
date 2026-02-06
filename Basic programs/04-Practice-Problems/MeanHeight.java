import java.util.Scanner;

public class MeanHeight {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of players in the team: ");
        int n = sc.nextInt();
        double[] heights = new double[n]; // array to store heights
        double sum = 0;
        for (int i = 0; i < n; i++) {
            System.out.print("Enter height of player " + (i + 1) + " (in cm): ");
            heights[i] = sc.nextDouble();
            sum += heights[i]; // add to sum
        }
        double mean = sum / n;
        System.out.println("\nMean height of the players = " + mean + " cm");
        sc.close();
    }
}
