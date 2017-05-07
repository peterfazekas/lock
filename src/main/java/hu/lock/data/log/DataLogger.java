package hu.lock.data.log;

import java.util.List;

/**
 * Interface for {@link DataLogger}
 * @author Peter_Fazekas on 2017.05.07..
 */
public interface DataLogger {

    void printAll(List<String> lines);

}
