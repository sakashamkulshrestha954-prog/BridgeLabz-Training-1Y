import java.util.Scanner;

class SumCheckFor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        if (n > 0) {
            int f = n * (n + 1) / 2, s = 0;
            for (int i = 1; i <= n; i++) s += i;
            System.out.println(f == s ? "Both computations are correct." : "Mismatch in results.");
        } else {
            System.out.println("Not a natural number");
        }

        sc.close();
    }
}
