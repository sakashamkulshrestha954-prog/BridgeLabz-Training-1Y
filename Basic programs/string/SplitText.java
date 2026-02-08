import java.util.Scanner;

class SplitText {

    static String[] manualSplit(String text) {
        int count = 1;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == ' ')
                count++;
        }
        String[] words = new String[count];
        int index = 0;
        String temp = "";

        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) != ' ') {
                temp += text.charAt(i);
            } else {
                words[index++] = temp;
                temp = "";
            }
        }
        words[index] = temp;
        return words;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = sc.nextLine();

        String[] manual = manualSplit(text);
        String[] builtIn = text.split(" ");
        System.out.println("Manual split result:");
        for (String word : manual)
            System.out.println(word);
        System.out.println("split() method result:");
        for (String word : builtIn)
            System.out.println(word);
    }
}
