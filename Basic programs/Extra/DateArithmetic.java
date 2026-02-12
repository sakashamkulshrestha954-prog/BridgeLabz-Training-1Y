import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class DateArithmetic {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        System.out.print("Enter a date (dd-MM-yyyy): ");
        String input = sc.nextLine();
        LocalDate date = LocalDate.parse(input, formatter);
        LocalDate result = date.plusDays(7)
                               .plusMonths(1)
                               .plusYears(2)
                               .minusWeeks(3);
        System.out.println("Final Date: " + result.format(formatter));
    }
}
