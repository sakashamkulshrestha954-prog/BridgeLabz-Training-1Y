import java.util.Scanner;

public class LowercaseCompare {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the text: ");
        String text = sc.nextLine();
        String lowerText = text.toLowerCase();
        System.out.println("Original text: " + text);
        System.out.println("Lowercase text: " + lowerText);
        if (text.equals(lowerText)) {
            System.out.println("Original text and lowercase text are same.");
        } else {
            System.out.println("Original text and lowercase text are different.");
        }
        sc.close();
    }
}
