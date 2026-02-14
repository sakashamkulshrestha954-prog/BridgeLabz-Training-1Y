import java.util.Scanner;

public class TriangularParkRun {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double a = sc.nextDouble();
        double b = sc.nextDouble();
        double c = sc.nextDouble();
        double perimeter = a + b + c;
        double rounds = Math.ceil(5000 / perimeter);
        System.out.println((int)rounds);
    }
}
