import java.util.Scanner;

public class ReverseNumberUsingArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = sc.nextInt();
        int temp = num;
        int count = 0;
        while (temp != 0) {
            count++;
            temp = temp / 10;
        }
        int[] arr = new int[count];
        temp = num;
        for (int i = 0; i < count; i++) {
            arr[i] = temp % 10;
            temp = temp / 10;
        }
        System.out.print("Reversed number: ");
        for (int i = 0; i < count; i++) {
            System.out.print(arr[i]);
        }
        sc.close();
    }
}
