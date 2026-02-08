import java.util.Scanner;
import java.util.Random;

class RockPaperScissors {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        String[] choices = {"Rock", "Paper", "Scissors"};
        int playerWins = 0, computerWins = 0, draws = 0;
        System.out.print("Enter number of games: ");
        int games = sc.nextInt();
        for (int i = 1; i <= games; i++) {
            System.out.println("\nGame " + i);
            System.out.print("Enter choice (0-Rock, 1-Paper, 2-Scissors): ");
            int playerChoice = sc.nextInt();
            int computerChoice = rand.nextInt(3);
            System.out.println("Player: " + choices[playerChoice]);
            System.out.println("Computer: " + choices[computerChoice]);
            if (playerChoice == computerChoice) {
                draws++;
                System.out.println("Result: Draw");
            } else if ((playerChoice == 0 && computerChoice == 2) ||
                       (playerChoice == 1 && computerChoice == 0) ||
                       (playerChoice == 2 && computerChoice == 1)) {
                playerWins++;
                System.out.println("Result: Player Wins");
            } else {
                computerWins++;
                System.out.println("Result: Computer Wins");
            }
        }
        double playerPercent = (playerWins * 100.0) / games;
        double computerPercent = (computerWins * 100.0) / games;
        System.out.println("\n----- Game Statistics -----");
        System.out.println("Player Wins\tComputer Wins\tDraws");
        System.out.println(playerWins + "\t\t" + computerWins + "\t\t" + draws);
        System.out.println("\nWinning Percentage:");
        System.out.printf("Player: %.2f%%\n", playerPercent);
        System.out.printf("Computer: %.2f%%\n", computerPercent);
    }
}
