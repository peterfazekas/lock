package hu.lock.data.log;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Implementation of {@link DataLogger}.
 * Write text content to text file represent by fileName;
 * @author Peter_Fazekas on 2017.05.07..
 */
public class FileLogger implements DataLogger {

    private static final String PATH = "src\\main\\resources\\";

    private final String fileName;

    public FileLogger(final String fileName) {
        this.fileName = PATH + fileName;
    }

    @Override
    public void printAll(final List<String> lines) {
        try (PrintWriter log = new PrintWriter(new FileWriter(fileName))) {
            lines.forEach(i -> println(log, i));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void println(final PrintWriter log, final String line) {
        log.println(line);
    }

}
