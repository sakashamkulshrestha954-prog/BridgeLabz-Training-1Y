public class RandomStats {
    public static void main(String[] args) {
        int[] numbers = new int[5];
        int sum = 0;
        for (int i = 0; i < 5; i++) {
            numbers[i] = (int)(Math.random() * 9000) + 1000;
            sum += numbers[i];
            System.out.println(numbers[i]);
        }
        int min = numbers[0];
        int max = numbers[0];
        for (int i = 1; i < 5; i++) {
            min = Math.min(min, numbers[i]);
            max = Math.max(max, numbers[i]);
        }
        double average = sum / 5.0;
        System.out.println("Average: " + average);
        System.out.println("Minimum: " + min);
        System.out.println("Maximum: " + max);
    }
}
