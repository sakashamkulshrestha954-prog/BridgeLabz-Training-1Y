public class ValidateCreditCard {
    public static void main(String[] args) {
        String visa = "4123456789012345";
        String master = "5123456789012345";

        if (visa.matches("^4\\d{15}$"))
            System.out.println(visa + " Valid Visa");

        if (master.matches("^5\\d{15}$"))
            System.out.println(master + " Valid MasterCard");
    }
}