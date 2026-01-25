import java.util.Scanner;

class FriendsShort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int aAge = sc.nextInt(), bAge = sc.nextInt(), cAge = sc.nextInt();
        double aHt = sc.nextDouble(), bHt = sc.nextDouble(), cHt = sc.nextDouble();

        String youngest = (aAge <= bAge && aAge <= cAge) ? "Amar" : (bAge <= cAge) ? "Akbar" : "Anthony";
        String tallest = (aHt >= bHt && aHt >= cHt) ? "Amar" : (bHt >= cHt) ? "Akbar" : "Anthony";

        System.out.println("Youngest friend: " + youngest);
        System.out.println("Tallest friend: " + tallest);

        sc.close();
    }
}
