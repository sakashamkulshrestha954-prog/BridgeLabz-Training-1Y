import java.util.Scanner;

public class SumRecursive {
    public static int recursiveSum(int n) {
        if (n == 0)
            return 0;
        return n + recursiveSum(n - 1);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sumRecursive = recursiveSum(n);
        int sumFormula = n * (n + 1) / 2;
        System.out.println("Sum using recursion: " + sumRecursive);
        System.out.println("Sum using formula: " + sumFormula);
        if (sumRecursive == sumFormula)
            System.out.println("Both results are correct and equal.");
        else
            System.out.println("Results are not equal.");
    }
}
