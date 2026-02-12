import java.util.Scanner;

public class MaximumOfThree {
    static int getInput(Scanner sc, String message) {
        System.out.print(message);
        return sc.nextInt();
    }
    static int findMaximum(int a, int b, int c) {
        int max = a;
        if (b > max) {
            max = b;
        }
        if (c > max) {
            max = c;
        }
        return max;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num1 = getInput(sc, "Enter first number: ");
        int num2 = getInput(sc, "Enter second number: ");
        int num3 = getInput(sc, "Enter third number: ");
        int maximum = findMaximum(num1, num2, num3);
        System.out.println("Maximum number is: " + maximum);
    }
}
