import java.util.Scanner;

class PowerCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int number = sc.nextInt();
        int power = sc.nextInt();
        long result = 1;

        if (number >= 0 && power >= 0) {
            for (int i = 1; i <= power; i++) {
                result *= number;
            }
            System.out.println("Result: " + result);
        } else {
            System.out.println("Please enter positive integers");
        }

        sc.close();
    }
}
