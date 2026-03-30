import java.util.*;

class SupportTicket extends Thread {
    private static int ticketCounter = 1;
    private int ticketNumber;
    private String ticketType;
    private int processingTime;
    private long startTime;
    private long endTime;
    private int queuePosition;

    public SupportTicket(String agentName, String ticketType, int priority, int queuePosition) {
        super(agentName);
        this.ticketNumber   = ticketCounter++;
        this.ticketType     = ticketType;
        this.processingTime = (new Random().nextInt(5) + 1) * 1000;
        this.queuePosition  = queuePosition;
        setPriority(priority);
    }

    @Override
    public void run() {
        startTime = System.currentTimeMillis();

        System.out.println("------------------------------------------------------------");
        System.out.println("  [START] Ticket #" + ticketNumber);
        System.out.println("  Type          : " + ticketType);
        System.out.println("  Agent         : " + getName());
        System.out.println("  Priority      : " + getPriority());
        System.out.println("  Queue Position: " + queuePosition);
        System.out.println("  Est. Time     : " + (processingTime / 1000) + " seconds");
        System.out.println("  Started At    : " + new Date());
        System.out.println("------------------------------------------------------------");

        try {
            Thread.sleep(processingTime);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        endTime = System.currentTimeMillis();

        System.out.println("  [DONE]  Ticket #" + ticketNumber + " | " + ticketType + " | Agent: " + getName() + " | Time Taken: " + getTotalTime() + "s | Completed: " + new Date());
    }

    public int getTicketNumber()  { return ticketNumber; }
    public String getTicketType() { return ticketType; }
    public long getTotalTime()    { return (endTime - startTime) / 1000; }
    public long getEndTime()      { return endTime; }
    public long getStartTime()    { return startTime; }
}

public class CustomerSupportSystem {

    public static void main(String[] args) throws InterruptedException {
        List<SupportTicket> tickets = new ArrayList<>();

        tickets.add(new SupportTicket("Agent-Ravi",   "Critical Bug",     10, 1));
        tickets.add(new SupportTicket("Agent-Priya",  "Critical Bug",     10, 2));
        tickets.add(new SupportTicket("Agent-Arjun",  "Critical Bug",     10, 3));
        tickets.add(new SupportTicket("Agent-Meera",  "Feature Request",   4, 4));
        tickets.add(new SupportTicket("Agent-Kiran",  "Feature Request",   4, 5));
        tickets.add(new SupportTicket("Agent-Anita",  "Feature Request",   4, 6));
        tickets.add(new SupportTicket("Agent-Suresh", "General Query",     2, 7));
        tickets.add(new SupportTicket("Agent-Divya",  "General Query",     2, 8));
        tickets.add(new SupportTicket("Agent-Rahul",  "Feedback",          1, 9));
        tickets.add(new SupportTicket("Agent-Nisha",  "Feedback",          1, 10));

        tickets.sort((a, b) -> b.getPriority() - a.getPriority());

        System.out.println("############################################################");
        System.out.println("#        CUSTOMER SUPPORT SYSTEM STARTED                  #");
        System.out.println("############################################################");
        System.out.println("  Total Tickets  : " + tickets.size());
        System.out.println("  Critical Bugs  : 3  (Priority 10)");
        System.out.println("  Feature Request: 3  (Priority 4)");
        System.out.println("  General Query  : 2  (Priority 2)");
        System.out.println("  Feedback       : 2  (Priority 1)");
        System.out.println("  System Start   : " + new Date());
        System.out.println("############################################################\n");

        System.out.println(">> QUEUE ORDER (By Priority):");
        System.out.println(String.format("  %-6s %-10s %-22s %-10s %-10s", "Pos", "Ticket#", "Type", "Agent", "Priority"));
        System.out.println("  " + "-".repeat(62));
        for (SupportTicket t : tickets) {
            System.out.println(String.format("  %-6d %-10d %-22s %-10s %-10d",
                    t.getPriority() == 10 ? 1 : t.getPriority() == 4 ? 4 : t.getPriority() == 2 ? 7 : 9,
                    t.getTicketNumber(), t.getTicketType(), t.getName(), t.getPriority()));
        }
        System.out.println();

        long systemStart = System.currentTimeMillis();

        for (SupportTicket ticket : tickets) {
            ticket.start();
        }

        for (SupportTicket ticket : tickets) {
            ticket.join();
        }

        long systemEnd = System.currentTimeMillis();
        long totalSystemTime = (systemEnd - systemStart) / 1000;

        Map<String, List<Long>> waitTimes = new LinkedHashMap<>();
        waitTimes.put("Critical Bug",     new ArrayList<>());
        waitTimes.put("Feature Request",  new ArrayList<>());
        waitTimes.put("General Query",    new ArrayList<>());
        waitTimes.put("Feedback",         new ArrayList<>());

        for (SupportTicket t : tickets) {
            waitTimes.get(t.getTicketType()).add(t.getTotalTime());
        }

        System.out.println("\n############################################################");
        System.out.println("#               SUPPORT SYSTEM STATISTICS                 #");
        System.out.println("############################################################");
        System.out.println(String.format("  %-22s %-12s %-12s %-12s", "Ticket Type", "Tickets", "Avg Time(s)", "Priority"));
        System.out.println("  " + "-".repeat(60));

        for (Map.Entry<String, List<Long>> entry : waitTimes.entrySet()) {
            String type     = entry.getKey();
            List<Long> times = entry.getValue();
            double avg      = times.stream().mapToLong(Long::longValue).average().orElse(0);
            int priority    = type.equals("Critical Bug") ? 10 : type.equals("Feature Request") ? 4 : type.equals("General Query") ? 2 : 1;
            System.out.println(String.format("  %-22s %-12d %-12.1f %-12d", type, times.size(), avg, priority));
        }

        System.out.println("\n  Total Tickets Resolved : " + tickets.size());
        System.out.println("  Total System Time      : " + totalSystemTime + " seconds");
        System.out.println("  System Completed At    : " + new Date());
        System.out.println("############################################################");
    }
}
```

**Ticket Type Summary**

| Ticket Type | Count | Priority | Processing Time |
|---|---|---|---|
| Critical Bug | 3 | 10 | Random 1–5s |
| Feature Request | 3 | 4 | Random 1–5s |
| General Query | 2 | 2 | Random 1–5s |
| Feedback | 2 | 1 | Random 1–5s |

**System Flow**
```
Tickets Created → Sorted by Priority → All Threads Start Concurrently
      ↓
Critical Bugs (10) get CPU preference
      ↓
Feature Requests (4) → General Queries (2) → Feedback (1)
      ↓
join() waits for all → Statistics printed