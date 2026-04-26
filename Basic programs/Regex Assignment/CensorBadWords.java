public class CensorBadWords {
    public static void main(String[] args) {
        String text = "This is a damn bad example with some stupid words.";
        String result = text.replaceAll("(?i)damn|stupid", "****");
        System.out.println(result);
    }
}