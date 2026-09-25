
import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        LogFileReader reader = new LogFileReader();
        LogAnalyzer analyzer = new LogAnalyzer();

        List<LogEntry> logs = new ArrayList<>();

        while (true) {

            System.out.println("\n================================");
            System.out.println("       SYSTEM LOG ANALYZER");
            System.out.println("================================");
            System.out.println("1. Load Log File");
            System.out.println("2. Analyze Logs");
            System.out.println("3. Search Logs");
            System.out.println("4. Exit");
            System.out.print("Choose: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    logs = reader.read("sample.log");

                    System.out.println(
                            "✓ " + logs.size() + " log entries loaded."
                    );
                    break;

                case 2:
                    if (logs.isEmpty()) {
                        System.out.println("Load log file first.");
                    } else {
                        analyzer.analyze(logs);
                    }
                    break;

                case 3:
                    if (logs.isEmpty()) {
                        System.out.println("Load log file first.");
                    } else {

                        System.out.print("Search keyword: ");
                        String keyword = sc.nextLine();

                        analyzer.search(logs, keyword);
                    }
                    break;

                case 4:
                    System.out.println("Analyzer closed.");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
