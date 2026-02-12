import java.util.Scanner;

public class AnagramCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first string: ");
        String str1 = sc.nextLine();
        System.out.print("Enter second string: ");
        String str2 = sc.nextLine();
        str1 = str1.replace(" ", "").toLowerCase();
        str2 = str2.replace(" ", "").toLowerCase();
        if (str1.length() != str2.length()) {
            System.out.println("The strings are NOT anagrams.");
        } else {
            int[] count = new int[26];
            for (int i = 0; i < str1.length(); i++) {
                count[str1.charAt(i) - 'a']++;
            }
            for (int i = 0; i < str2.length(); i++) {
                count[str2.charAt(i) - 'a']--;
            }
            boolean isAnagram = true;
            for (int i = 0; i < 26; i++) {
                if (count[i] != 0) {
                    isAnagram = false;
                    break;
                }
            }
            if (isAnagram)
                System.out.println("The strings are ANAGRAMS.");
            else
                System.out.println("The strings are NOT anagrams.");
        }
        sc.close();
    }
}
