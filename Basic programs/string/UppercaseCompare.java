import java.util.Scanner;

public class UppercaseCompare {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the text: ");
        String text = sc.nextLine();
        String upperText = text.toUpperCase();
        System.out.println("Original text: " + text);
        System.out.println("Uppercase text: " + upperText);
        if (text.equals(upperText)) {
            System.out.println("Original text and uppercase text are same.");
        } else {
            System.out.println("Original text and uppercase text are different.");
        }

        sc.close();
    }
}
