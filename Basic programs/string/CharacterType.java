import java.util.Scanner;

class CharacterType {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String text = sc.nextLine().toLowerCase();
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u')
                    System.out.println(ch + " : Vowel");
                else
                    System.out.println(ch + " : Consonant");
            } else {
                System.out.println(ch + " : Not a Letter");
            }
        }
    }
}
