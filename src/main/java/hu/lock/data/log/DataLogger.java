package hu.lock.data.log;

import java.io.PrintWriter;
import java.util.List;

/**
 * @author Peter_Fazekas on 2017.05.07..
 */
public interface DataLogger {

    void printAll(List<String> lines);

    void print(PrintWriter log, String line);
}
