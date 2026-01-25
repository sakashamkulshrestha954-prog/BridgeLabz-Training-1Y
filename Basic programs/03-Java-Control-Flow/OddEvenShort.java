import java.util.Scanner;

class OddEvenShort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n > 0)
            for (int i = 1; i <= n; i++)
                System.out.println(i + " is " + (i % 2 == 0 ? "even" : "odd"));
        else
            System.out.println("Not a natural number");
        sc.close();
    }
}
