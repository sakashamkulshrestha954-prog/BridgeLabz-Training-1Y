import java.util.Scanner;

public class ZaraBonus {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 10;
        double totalBonus = 0;
        for (int i = 1; i <= n; i++) {
            System.out.println("\nEnter details of Employee " + i);
            System.out.print("Enter old salary: ");
            double salary = sc.nextDouble();
            System.out.print("Enter years of service: ");
            int years = sc.nextInt();
            double bonus;
            if (years >= 5) {
                bonus = salary * 0.10;  
            } else {
                bonus = salary * 0.05;  
            }
            double newSalary = salary + bonus;
            totalBonus += bonus;
            System.out.println("Bonus: " + bonus);
            System.out.println("Old Salary: " + salary);
            System.out.println("New Salary: " + newSalary);
        }
        System.out.println("\nTotal bonus amount paid by Zara: " + totalBonus);
        sc.close();
    }
}
