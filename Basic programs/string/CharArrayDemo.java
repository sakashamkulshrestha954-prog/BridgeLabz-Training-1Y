import java.util.Scanner;

public class CharArrayDemo {
    static char[] getCharacters(String str) {
        char[] arr = new char[str.length()];
        for (int i = 0; i < str.length(); i++) {
            arr[i] = str.charAt(i);
        }
        return arr;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = sc.nextLine();
        char[] userArray = getCharacters(str);
        char[] builtInArray = str.toCharArray();
        System.out.println("\nCharacters using user-defined method:");
        for (char c : userArray) {
            System.out.print(c + " ");
        }
        System.out.println("\n\nCharacters using toCharArray():");
        for (char c : builtInArray) {
            System.out.print(c + " ");
        }
        boolean isSame = true;
        if (userArray.length != builtInArray.length) {
            isSame = false;
        } else {
            for (int i = 0; i < userArray.length; i++) {
                if (userArray[i] != builtInArray[i]) {
                    isSame = false;
                    break;
                }
            }
        }
        if (isSame) {
            System.out.println("\n\nBoth methods return the same characters.");
        } else {
            System.out.println("\n\nBoth methods return different characters.");
        }
        sc.close();
    }
}
