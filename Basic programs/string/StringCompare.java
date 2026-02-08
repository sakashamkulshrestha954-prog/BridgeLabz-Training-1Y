import java.util.Scanner;

public class StringCompare {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first string: ");
        String s1 = sc.nextLine();
        System.out.print("Enter second string: ");
        String s2 = sc.nextLine();
        boolean isEqual = true;
        if (s1.length() != s2.length()) {
            isEqual = false;
        } else {
            for (int i = 0; i < s1.length(); i++) {
                if (s1.charAt(i) != s2.charAt(i)) {
                    isEqual = false;
                    break;
                }
            }
        }
        if (isEqual) {
            System.out.println("Strings are equal (using charAt()).");
        } else {
            System.out.println("Strings are not equal (using charAt()).");
        }
        if (s1.equals(s2)) {
            System.out.println("Strings are equal (using equals()).");
        } else {
            System.out.println("Strings are not equal (using equals()).");
        }
        sc.close();
    }
}
