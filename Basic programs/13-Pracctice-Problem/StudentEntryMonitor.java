import java.util.Date;

class StudentEntryMonitor implements Runnable {
    @Override
    public void run() {
        System.out.println("[ENTRY]      Thread State: " + Thread.currentThread().getState() + " | " + new Date());
        for (int i = 1; i <= 5; i++) {
            System.out.println("[ENTRY]      Monitoring student entry... Batch " + i + "/5 | Agent: " + Thread.currentThread().getName() + " | Priority: " + Thread.currentThread().getPriority());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("[ENTRY]      All students entered. Thread completing.\n");
    }
}

class QuestionPaperDistributor implements Runnable {
    @Override
    public void run() {
        System.out.println("[Q-PAPER]    Thread State: " + Thread.currentThread().getState() + " | " + new Date());
        System.out.println("[Q-PAPER]    Waiting 5 seconds before distribution...");
        try {
            Thread.sleep(5000);
            for (int i = 1; i <= 5; i++) {
                System.out.println("[Q-PAPER]    Distributing question papers... Round " + i + "/5 | Agent: " + Thread.currentThread().getName() + " | Priority: " + Thread.currentThread().getPriority());
                Thread.sleep(1500);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("[Q-PAPER]    Question papers distributed. Thread completing.\n");
    }
}

class AttendanceMarker implements Runnable {
    @Override
    public void run() {
        System.out.println("[ATTENDANCE] Thread State: " + Thread.currentThread().getState() + " | " + new Date());
        System.out.println("[ATTENDANCE] Waiting 10 seconds before marking attendance...");
        try {
            Thread.sleep(10000);
            for (int i = 1; i <= 5; i++) {
                System.out.println("[ATTENDANCE] Marking attendance... Row " + i + "/5 | Agent: " + Thread.currentThread().getName() + " | Priority: " + Thread.currentThread().getPriority());
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("[ATTENDANCE] Attendance marking complete. Thread completing.\n");
    }
}

class AnswerSheetCollector implements Runnable {
    private int examDurationSeconds;

    public AnswerSheetCollector(int examDurationSeconds) {
        this.examDurationSeconds = examDurationSeconds;
    }

    @Override
    public void run() {
        System.out.println("[COLLECTION] Thread State: " + Thread.currentThread().getState() + " | " + new Date());
        System.out.println("[COLLECTION] Waiting " + examDurationSeconds + " seconds for exam to finish...");
        try {
            Thread.sleep(examDurationSeconds * 1000L);
            for (int i = 1; i <= 5; i++) {
                System.out.println("[COLLECTION] Collecting answer sheets... Student " + i + "/5 | Agent: " + Thread.currentThread().getName() + " | Priority: " + Thread.currentThread().getPriority());
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("[COLLECTION] All answer sheets collected. Thread completing.\n");
    }
}

public class ExamHallMonitoringSystem {

    static void printThreadState(String label, Thread t) {
        System.out.println("  " + label + " -> State: " + t.getState() + " | Priority: " + t.getPriority() + " | Name: " + t.getName());
    }

    public static void main(String[] args) throws InterruptedException {
        int examDuration = 20;

        Thread entryThread      = new Thread(new StudentEntryMonitor(),            "Entry-Monitor");
        Thread qPaperThread     = new Thread(new QuestionPaperDistributor(),       "QPaper-Distributor");
        Thread attendanceThread = new Thread(new AttendanceMarker(),               "Attendance-Marker");
        Thread collectionThread = new Thread(new AnswerSheetCollector(examDuration), "Sheet-Collector");

        qPaperThread.setPriority(10);
        attendanceThread.setPriority(8);
        collectionThread.setPriority(7);
        entryThread.setPriority(5);

        System.out.println("############################################################");
        System.out.println("#         EXAM HALL MONITORING SYSTEM STARTED              #");
        System.out.println("############################################################");
        System.out.println("  Exam Duration : " + examDuration + " seconds");
        System.out.println("  System Start  : " + new Date());
        System.out.println("############################################################\n");

        System.out.println(">> THREAD STATES BEFORE START:");
        printThreadState("Entry Monitor     ", entryThread);
        printThreadState("Q-Paper Distributor", qPaperThread);
        printThreadState("Attendance Marker ", attendanceThread);
        printThreadState("Sheet Collector   ", collectionThread);
        System.out.println();

        entryThread.start();
        qPaperThread.start();
        attendanceThread.start();
        collectionThread.start();

        Thread.sleep(1000);

        System.out.println("\n>> THREAD STATES AFTER START (1 second in):");
        printThreadState("Entry Monitor     ", entryThread);
        printThreadState("Q-Paper Distributor", qPaperThread);
        printThreadState("Attendance Marker ", attendanceThread);
        printThreadState("Sheet Collector   ", collectionThread);
        System.out.println();

        Thread.sleep(6000);

        System.out.println("\n>> THREAD STATES AT 7 SECONDS (Q-Paper distributing):");
        printThreadState("Entry Monitor     ", entryThread);
        printThreadState("Q-Paper Distributor", qPaperThread);
        printThreadState("Attendance Marker ", attendanceThread);
        printThreadState("Sheet Collector   ", collectionThread);
        System.out.println();

        Thread.sleep(5000);

        System.out.println("\n>> THREAD STATES AT 12 SECONDS (Attendance marking):");
        printThreadState("Entry Monitor     ", entryThread);
        printThreadState("Q-Paper Distributor", qPaperThread);
        printThreadState("Attendance Marker ", attendanceThread);
        printThreadState("Sheet Collector   ", collectionThread);
        System.out.println();

        entryThread.join();
        qPaperThread.join();
        attendanceThread.join();
        collectionThread.join();

        System.out.println("\n>> THREAD STATES AFTER ALL COMPLETE:");
        printThreadState("Entry Monitor     ", entryThread);
        printThreadState("Q-Paper Distributor", qPaperThread);
        printThreadState("Attendance Marker ", attendanceThread);
        printThreadState("Sheet Collector   ", collectionThread);

        System.out.println("\n############################################################");
        System.out.println("#      EXAM HALL MONITORING COMPLETED SUCCESSFULLY         #");
        System.out.println("############################################################");
        System.out.println("  Completed At: " + new Date());
        System.out.println("############################################################");
    }
}
```

**Activity Sequence & Priority**

| Activity | Thread Name | Priority | Starts After | Cycles |
|---|---|---|---|---|
| Question Paper | QPaper-Distributor | 10 | 5 seconds | 5 rounds |
| Answer Sheet Collection | Sheet-Collector | 7 | 20 seconds (exam end) | 5 students |
| Attendance Marking | Attendance-Marker | 8 | 10 seconds | 5 rows |
| Student Entry | Entry-Monitor | 5 | Immediately | 5 batches |

**Thread State Transitions**
```
NEW ──► RUNNABLE ──► TIMED_WAITING ──► RUNNABLE ──► TERMINATED
         (start)      (sleep/join)      (wakes up)    (run() ends)
```

**State Snapshots Captured At**
```
T=0s   → NEW        (before start)
T=1s   → RUNNABLE / TIMED_WAITING
T=7s   → Q-Paper active, others waiting
T=12s  → Attendance active, Entry still running
T=end  → TERMINATED (all threads)