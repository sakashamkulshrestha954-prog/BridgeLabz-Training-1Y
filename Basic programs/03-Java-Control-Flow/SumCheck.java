import java.util.Scanner;

class SumCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        if (n > 0) {
            int f = n * (n + 1) / 2, w = 0, i = 1;
            while (i <= n) w += i++;
            System.out.println(f == w ? "Both computations are correct." : "Mismatch in results.");
        } else {
            System.out.println("Not a natural number");
        }

        sc.close();
    }
}
