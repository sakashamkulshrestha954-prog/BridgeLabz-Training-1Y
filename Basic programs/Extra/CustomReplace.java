import java.util.Scanner;

public class CustomReplace {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String sentence = sc.nextLine();
        System.out.print("Enter the word to replace: ");
        String oldWord = sc.nextLine();
        System.out.print("Enter the new word: ");
        String newWord = sc.nextLine();
        String result = replaceWord(sentence, oldWord, newWord);
        System.out.println("Modified sentence: " + result);
        sc.close();
    }
    public static String replaceWord(String sentence, String oldWord, String newWord) {
        String result = "";
        int i = 0;
        while (i <= sentence.length() - oldWord.length()) {
            String sub = sentence.substring(i, i + oldWord.length());
            if (sub.equals(oldWord)) {
                result += newWord;
                i += oldWord.length();
            } else {
                result += sentence.charAt(i);
                i++;
            }
        }
        result += sentence.substring(i);
        return result;
    }
}
