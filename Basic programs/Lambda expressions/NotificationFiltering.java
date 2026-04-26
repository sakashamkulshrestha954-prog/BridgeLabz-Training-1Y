import java.util.*;
import java.util.function.Predicate;
public class NotificationFiltering {
    public static void main(String[] args) {
        List<String> alerts = Arrays.asList(
                "Emergency Alert",
                "Medicine Reminder",
                "Appointment Notice",
                "Critical BP Alert"
        );
        Predicate<String> criticalOnly =
                alert -> alert.contains("Emergency") || alert.contains("Critical");
        System.out.println("Filtered Alerts:");
        alerts.stream()
                .filter(criticalOnly)
                .forEach(System.out::println);
    }
}