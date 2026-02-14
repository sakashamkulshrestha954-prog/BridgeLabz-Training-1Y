import java.util.Scanner;

public class TrigonometricFunctions {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double degree = sc.nextDouble();
        double radian = Math.toRadians(degree);
        double sin = Math.sin(radian);
        double cos = Math.cos(radian);
        double tan = Math.tan(radian);
        System.out.println("sin: " + sin);
        System.out.println("cos: " + cos);
        System.out.println("tan: " + tan);
    }
}
