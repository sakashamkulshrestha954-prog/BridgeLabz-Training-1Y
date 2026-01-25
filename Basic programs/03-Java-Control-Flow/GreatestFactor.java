import java.util.Scanner;

class GreatestFactor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        int greatestFactor = 1;

        if (number > 0) {
            for (int i = number - 1; i >= 1; i--) {
                if (number % i == 0) {
                    greatestFactor = i;
                    break;
                }
            }
            System.out.println("Greatest factor besides itself: " + greatestFactor);
        } else {
            System.out.println("Not a positive integer");
        }

        sc.close();
    }
}
