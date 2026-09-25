
import java.io.*;
import java.util.*;

public class LogFileReader {

    public List<LogEntry> read(String fileName) {

        List<LogEntry> logs = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] parts = line.split(" ", 3);

                if (parts.length >= 3) {
                    logs.add(new LogEntry(parts[1], parts[2]));
                }
            }
        } catch (IOException e) {
            System.out.println(" Unable to read log file");
        }

        return logs;
    }
}
