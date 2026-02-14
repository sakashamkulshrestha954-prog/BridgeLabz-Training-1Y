import java.util.Scanner;

public class ChocolateDivision {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int eachChild = N / M;
        int remaining = N % M;
        System.out.println("Each child gets: " + eachChild);
        System.out.println("Remaining chocolates: " + remaining);
    }
}
