public class BankLimit {
    public static double remainingLimit(Double limit, double used) {
        if (limit == null) return 0.0;
        return limit - used;
    }
}