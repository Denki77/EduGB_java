package Level3.lesson3;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class Logger {
    private final String log_file_name = "./log.txt";

    public void getMeLastMessages() throws IOException {

        File file = getMeLogFile();

        BufferedReader raf = new BufferedReader(new InputStreamReader(new FileInputStream(log_file_name)));
        String line;
        ArrayList<String> linesIntoFile = new ArrayList<>();
        int count_line = 10;

        while ((line = raf.readLine()) != null) {
            linesIntoFile.add(line);
        }

        if (linesIntoFile.size() > count_line) {
            linesIntoFile.subList(0, linesIntoFile.size() - count_line).clear();
        } else {
            count_line = linesIntoFile.size();
        }

        for (String outline :
                linesIntoFile) {
            System.out.println(count_line + ". " + outline);
            count_line--;
        }
    }

    public void setMessageIntoLogFile() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        File file = getMeLogFile();
        FileOutputStream out = new FileOutputStream(file, true);

        while (true) {
            System.out.print("Enter String (or -exit for exit)... ");
            String s = br.readLine() + "\n";
            if (s.equals("-exit\n")) {
                break;
            }
            out.write(s.getBytes(StandardCharsets.UTF_8));
        }
    }

    private File getMeLogFile() throws FileNotFoundException {
        File file = new File(log_file_name);
        if (!file.exists()) {
            // If not exist log file - create it
            new FileOutputStream(log_file_name);
        }
        return file;
    }
}
