import java.util.function.Consumer;
public class SmartHomeLightingAutomation {
    public static void main(String[] args) {
        Consumer<String> motionTrigger = room ->
                System.out.println(room + ": Lights ON at 100% brightness (Motion detected)");
        Consumer<String> nightMode = room ->
                System.out.println(room + ": Lights ON at 30% warm brightness (Night Mode)");
        Consumer<String> voiceCommand = room ->
                System.out.println(room + ": Lights changed to Party Mode colors");
        motionTrigger.accept("Living Room");
        nightMode.accept("Bedroom");
        voiceCommand.accept("Hall");
    }
}