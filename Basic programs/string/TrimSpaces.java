import java.util.Scanner;

class TrimSpaces {
    static String manualTrim(String str) {
        int start = 0;
        int end = str.length() - 1;
        while (start <= end && str.charAt(start) == ' ')
            start++;
        while (end >= start && str.charAt(end) == ' ')
            end--;
        String result = "";
        for (int i = start; i <= end; i++)
            result += str.charAt(i);
        return result;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String text = sc.nextLine();
        String trimmed = manualTrim(text);
        System.out.println("Trimmed string: \"" + trimmed + "\"");
    }
}
