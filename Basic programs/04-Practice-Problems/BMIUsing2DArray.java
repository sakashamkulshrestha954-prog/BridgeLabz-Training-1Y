import java.util.Scanner;

public class BMIUsing2DArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of persons: ");
        int n = sc.nextInt();
        double[][] data = new double[n][3];
        for (int i = 0; i < n; i++) {
            System.out.println("\nPerson " + (i + 1));
            System.out.print("Enter height (in meters): ");
            data[i][0] = sc.nextDouble();
            System.out.print("Enter weight (in kg): ");
            data[i][1] = sc.nextDouble();
            data[i][2] = data[i][1] / (data[i][0] * data[i][0]);
        }
        System.out.println("\n--- BMI DETAILS ---");
        for (int i = 0; i < n; i++) {
            double bmi = data[i][2];
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
            System.out.println("\nPerson " + (i + 1));
            System.out.println("Height: " + data[i][0] + " m");
            System.out.println("Weight: " + data[i][1] + " kg");
            System.out.println("BMI: " + data[i][2]);
            System.out.println("Status: " + status);
        }
        sc.close();
    }
}
