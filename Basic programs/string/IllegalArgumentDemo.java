public class IllegalArgumentDemo {
    public static void main(String[] args) {
        int number = -5;

        if (number < 0) {
            throw new IllegalArgumentException("Number cannot be negative");
        }
        System.out.println("Number is: " + number);
    }
}
