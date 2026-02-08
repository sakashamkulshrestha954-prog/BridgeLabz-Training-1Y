import java.util.Scanner;

class WordsWithLength {

    static Object[][] splitWithLength(String text) {
        int count = 1;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == ' ')
                count++;
        }
        Object[][] result = new Object[count][2];
        int row = 0;
        String word = "";
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) != ' ') {
                word += text.charAt(i);
            } else {
                result[row][0] = word;
                result[row][1] = word.length();
                row++;
                word = "";
            }
        }
        result[row][0] = word;
        result[row][1] = word.length();
        return result;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = sc.nextLine();
        Object[][] words = splitWithLength(text);
        System.out.println("Word\tLength");
        for (int i = 0; i < words.length; i++) {
            System.out.println(words[i][0] + "\t" + words[i][1]);
        }
    }
}
