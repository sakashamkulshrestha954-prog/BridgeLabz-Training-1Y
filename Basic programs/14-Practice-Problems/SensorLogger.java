public class SensorLogger {
    public static void log(double temp) { 
        Double boxed = temp;
        System.out.println("Stored: " + boxed);
    }
    public static void log(Double temp) { 
        double val = temp; 
        System.out.println("Stored: " + val);
    }
}