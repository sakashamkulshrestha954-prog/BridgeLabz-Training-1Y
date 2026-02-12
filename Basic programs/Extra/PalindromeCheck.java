import java.util.Scanner;

public class PalindromeCheck {
    static String getInput(Scanner sc) {
        System.out.print("Enter a string: ");
        return sc.nextLine();
    }
    static boolean isPalindrome(String str) {
        String cleaned = str.replaceAll("\\s+", "").toLowerCase();
        int left = 0;
        int right = cleaned.length() - 1;
        while (left < right) {
            if (cleaned.charAt(left) != cleaned.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    static void displayResult(String str, boolean result) {
        if (result) {
            System.out.println("\"" + str + "\" is a palindrome.");
        } else {
            System.out.println("\"" + str + "\" is not a palindrome.");
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = getInput(sc);
        boolean result = isPalindrome(input);
        displayResult(input, result);
    }
}
