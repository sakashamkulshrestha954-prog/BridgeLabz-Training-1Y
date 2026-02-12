import java.util.Scanner;

public class FactorialRecursive {
    static int getInput(Scanner sc) {
        System.out.print("Enter a number: ");
        return sc.nextInt();
    }
    static long factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }
    static void displayResult(int n, long result) {
        System.out.println("Factorial of " + n + " is: " + result);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = getInput(sc);
        long result = factorial(number);
        displayResult(number, result);
    }
}
