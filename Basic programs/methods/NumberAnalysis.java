import java.util.Scanner;

public class NumberAnalysis {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[5];
        for (int i = 0; i < 5; i++) {
            arr[i] = sc.nextInt();
        }
        for (int i = 0; i < 5; i++) {
            if (arr[i] >= 0) {
                System.out.print(arr[i] + " is Positive and ");
                if (arr[i] % 2 == 0) {
                    System.out.println("Even");
                } else {
                    System.out.println("Odd");
                }
            } else {
                System.out.println(arr[i] + " is Negative");
            }
        }
        if (arr[0] == arr[4]) {
            System.out.println("First and Last elements are Equal");
        } else if (arr[0] > arr[4]) {
            System.out.println("First element is Greater than Last");
        } else {
            System.out.println("First element is Less than Last");
        }
    }
}
