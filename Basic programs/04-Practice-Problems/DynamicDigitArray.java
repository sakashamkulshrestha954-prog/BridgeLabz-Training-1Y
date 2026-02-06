import java.util.Scanner;

public class DynamicDigitArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = sc.nextInt();
        int maxDigit = 10;              
        int[] arr = new int[maxDigit];
        int index = 0;
        while (num != 0) {
            if (index == maxDigit) {
                maxDigit = maxDigit + 10;
                int[] newArr = new int[maxDigit];

                // copy old array into new array
                for (int i = 0; i < index; i++) {
                    newArr[i] = arr[i];
                }
                arr = newArr;
            }
            arr[index] = num % 10;
            index++;
            num = num / 10;
        }
        int largest = arr[0];
        int secondLargest = -1;
        for (int i = 1; i < index; i++) {
            if (arr[i] > largest) {
                secondLargest = largest;
                largest = arr[i];
            } else if (arr[i] > secondLargest && arr[i] != largest) {
                secondLargest = arr[i];
            }
        }
        System.out.println("Largest digit: " + largest);
        System.out.println("Second largest digit: " + secondLargest);
        sc.close();
    }
}
