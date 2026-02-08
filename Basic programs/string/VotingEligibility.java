import java.util.Scanner;

class VotingEligibility {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] age = new int[10];
        for (int i = 0; i < 10; i++) {
            System.out.print("Enter age of student " + (i + 1) + ": ");
            age[i] = sc.nextInt();
        }
        System.out.println("\nVoting Eligibility:");
        for (int i = 0; i < 10; i++) {
            if (age[i] >= 18)
                System.out.println("Student " + (i + 1) + ": Eligible to vote");
            else
                System.out.println("Student " + (i + 1) + ": Not eligible to vote");
        }
    }
}
