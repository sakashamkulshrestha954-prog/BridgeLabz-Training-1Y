import java.util.Scanner;

public class QuotientRemainder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int quotient = a / b;
        int remainder = a % b;
        System.out.println("Quotient: " + quotient);
        System.out.println("Remainder: " + remainder);
    }
}
