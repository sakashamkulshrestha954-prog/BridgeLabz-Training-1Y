import java.util.*;
import java.util.stream.Collectors;
class Invoice {
    String transactionId;
    public Invoice(String transactionId) {
        this.transactionId = transactionId;
    }
    public String toString() {
        return "Invoice for Transaction ID: " + transactionId;
    }
}
public class InvoiceCreation {
    public static void main(String[] args) {
        List<String> ids = Arrays.asList(
                "TXN1001",
                "TXN1002",
                "TXN1003"
        );
        List<Invoice> invoices = ids.stream()
                .map(Invoice::new)
                .collect(Collectors.toList());

        invoices.forEach(System.out::println);
    }
}