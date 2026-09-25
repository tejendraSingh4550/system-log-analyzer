
import java.util.*;

public class LogAnalyzer {

    public void analyze(List<LogEntry> logs) {

        int info = 0;
        int warning = 0;
        int error = 0;

        for (LogEntry log : logs) {

            switch (log.level) {

                case "INFO":
                    info++;
                    break;

                case "WARNING":
                    warning++;
                    break;

                case "ERROR":
                    error++;
                    break;
            }
        }

        System.out.println("\n========= LOG ANALYSIS =========");
        System.out.println("Total Entries : " + logs.size());
        System.out.println("INFO          : " + info);
        System.out.println("WARNING       : " + warning);
        System.out.println("ERROR         : " + error);

        if (error > 0) {
            System.out.println("System Health : ⚠️ NEEDS ATTENTION"); 
        }else {
            System.out.println("System Health : 🟢 HEALTHY");
        }
    }

    public void search(List<LogEntry> logs, String keyword) {

        System.out.println("\n========= SEARCH RESULTS =========");

        for (LogEntry log : logs) {

            if (log.message.toLowerCase()
                    .contains(keyword.toLowerCase())) {

                System.out.println(
                        "[" + log.level + "] " + log.message);
            }
        }
    }
}
