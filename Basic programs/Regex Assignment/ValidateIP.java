public class ValidateIP {
    public static void main(String[] args) {
        String ip = "192.168.1.1";

        boolean valid = ip.matches("^((25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)\\.){3}(25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)$");

        if (valid)
            System.out.println("Valid IP");
        else
            System.out.println("Invalid IP");
    }
}