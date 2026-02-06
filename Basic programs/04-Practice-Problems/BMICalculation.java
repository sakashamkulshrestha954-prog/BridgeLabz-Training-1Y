import java.util.Scanner;

public class BMICalculation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of persons: ");
        int n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            System.out.println("\nPerson " + i);
            System.out.print("Enter height (in meters): ");
            double height = sc.nextDouble();
            System.out.print("Enter weight (in kg): ");
            double weight = sc.nextDouble();
            double bmi = weight / (height * height);
            String status;
            if (bmi < 18.5) {
                status = "Underweight";
            } else if (bmi < 25) {
                status = "Normal";
            } else if (bmi < 30) {
                status = "Overweight";
            } else {
                status = "Obese";
            }
            System.out.println("Height: " + height + " m");
            System.out.println("Weight: " + weight + " kg");
            System.out.println("BMI: " + bmi);
            System.out.println("Status: " + status);
        }
        sc.close();
    }
}
