import java.util.Scanner;

public class GCD_LCM {
    static int getInput(Scanner sc, String message) {
        System.out.print(message);
        return sc.nextInt();
    }
    static int findGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    static int findLCM(int a, int b) {
        return (a * b) / findGCD(a, b);
    }
    static void displayResult(int a, int b, int gcd, int lcm) {
        System.out.println("GCD of " + a + " and " + b + " is: " + gcd);
        System.out.println("LCM of " + a + " and " + b + " is: " + lcm);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num1 = getInput(sc, "Enter first number: ");
        int num2 = getInput(sc, "Enter second number: ");
        int gcd = findGCD(num1, num2);
        int lcm = findLCM(num1, num2);
        displayResult(num1, num2, gcd, lcm);
    }
}
