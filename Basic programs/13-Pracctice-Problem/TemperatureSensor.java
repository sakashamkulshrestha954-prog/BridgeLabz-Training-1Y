import java.util.Date;

class TemperatureSensor implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            double temp = 20 + Math.random() * 10;
            System.out.println("[TEMPERATURE] Cycle " + i + "/5 | Temp: " + String.format("%.1f", temp) + "°C | Priority: " + Thread.currentThread().getPriority() + " | " + new Date());
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("[TEMPERATURE] Sensor completed all cycles.\n");
    }
}

class SecurityCamera extends Thread {
    public SecurityCamera() {
        super("Security-Camera");
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("[SECURITY]    Cycle " + i + "/5 | Recording... | Priority: " + getPriority() + " | " + new Date());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("[SECURITY]    Camera completed all cycles.\n");
    }
}

class LightController implements Runnable {
    @Override
    public void run() {
        String[] states = {"DIM", "BRIGHT", "OFF", "AUTO", "NIGHT"};
        for (int i = 1; i <= 5; i++) {
            System.out.println("[LIGHT]       Cycle " + i + "/5 | Mode: " + states[i - 1] + " | Priority: " + Thread.currentThread().getPriority() + " | " + new Date());
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("[LIGHT]       Controller completed all cycles.\n");
    }
}

class DoorLockMonitor extends Thread {
    public DoorLockMonitor() {
        super("Door-Lock-Monitor");
    }

    @Override
    public void run() {
        String[] status = {"LOCKED", "LOCKED", "UNLOCKED", "LOCKED", "LOCKED"};
        for (int i = 1; i <= 5; i++) {
            System.out.println("[DOOR]        Cycle " + i + "/5 | Status: " + status[i - 1] + " | Priority: " + getPriority() + " | " + new Date());
            try {
                Thread.sleep(6000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("[DOOR]        Monitor completed all cycles.\n");
    }
}

public class SmartHomeSystem {
    public static void main(String[] args) {
        SecurityCamera securityCamera = new SecurityCamera();
        DoorLockMonitor doorLockMonitor = new DoorLockMonitor();

        Thread temperatureThread = new Thread(new TemperatureSensor(), "Temperature-Sensor");
        Thread lightThread = new Thread(new LightController(), "Light-Controller");

        securityCamera.setPriority(10);
        temperatureThread.setPriority(7);
        lightThread.setPriority(5);
        doorLockMonitor.setPriority(5);

        System.out.println("============================================================");
        System.out.println("           SMART HOME SYSTEM STARTED");
        System.out.println("============================================================");
        System.out.println("Initializing devices...\n");

        securityCamera.start();
        temperatureThread.start();
        lightThread.start();
        doorLockMonitor.start();

        try {
            securityCamera.join();
            temperatureThread.join();
            lightThread.join();
            doorLockMonitor.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted.");
        }

        System.out.println("============================================================");
        System.out.println("      ALL DEVICES COMPLETED - SYSTEM SHUTTING DOWN");
        System.out.println("============================================================");
    }
}