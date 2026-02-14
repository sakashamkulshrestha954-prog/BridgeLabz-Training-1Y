import java.util.Scanner;

public class WindChill {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double temperature = sc.nextDouble();
        double windSpeed = sc.nextDouble();
        double windChill = 13.12 + 0.6215 * temperature
                - 11.37 * Math.pow(windSpeed, 0.16)
                + 0.3965 * temperature * Math.pow(windSpeed, 0.16);
        System.out.println(windChill);
    }
}
