import java.util.Scanner;

public class SubstringDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = sc.nextLine();
        System.out.print("Enter start index: ");
        int start = sc.nextInt();
        System.out.print("Enter end index: ");
        int end = sc.nextInt();
        String sub1 = "";
        for (int i = start; i < end; i++) {
            sub1 = sub1 + str.charAt(i);
        }
        String sub2 = str.substring(start, end);
        System.out.println("Substring using charAt(): " + sub1);
        System.out.println("Substring using substring(): " + sub2);
        if (sub1.equals(sub2)) {
            System.out.println("Both substrings are equal.");
        } else {
            System.out.println("Both substrings are not equal.");
        }
        sc.close();
    }
}
