import java.util.Scanner;

public class FactorsArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] factors = new int[n];
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                factors[count++] = i;
            }
        }
        int sum = 0;
        int sumOfSquares = 0;
        long product = 1;
        for (int i = 0; i < count; i++) {
            System.out.print(factors[i] + " ");
            sum += factors[i];
            sumOfSquares += factors[i] * factors[i];
            product *= factors[i];
        }
        System.out.println();
        System.out.println("Sum: " + sum);
        System.out.println("Sum of Squares: " + sumOfSquares);
        System.out.println("Product: " + product);
    }
}
