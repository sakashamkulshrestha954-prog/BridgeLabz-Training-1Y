import java.util.Scanner;

class MultiplesBelow100While {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();

        if (number > 0 && number < 100) {
            System.out.print("Multiples of " + number + " below 100: ");
            int i = 1;
            while (i < 100) {
                if (i % number == 0) {
                    System.out.print(i + " ");
                }
                i++;
            }
        } else {
            System.out.println("Number must be a positive integer less than 100");
        }

        sc.close();
    }
}
