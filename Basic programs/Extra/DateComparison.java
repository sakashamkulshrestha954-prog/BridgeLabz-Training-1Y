import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class DateComparison {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        System.out.print("Enter first date (dd-MM-yyyy): ");
        String input1 = sc.nextLine();
        System.out.print("Enter second date (dd-MM-yyyy): ");
        String input2 = sc.nextLine();
        LocalDate date1 = LocalDate.parse(input1, formatter);
        LocalDate date2 = LocalDate.parse(input2, formatter);
        if (date1.isBefore(date2)) {
            System.out.println("First date is before the second date.");
        } else if (date1.isAfter(date2)) {
            System.out.println("First date is after the second date.");
        } else if (date1.isEqual(date2)) {
            System.out.println("Both dates are the same.");
        }
    }
}
