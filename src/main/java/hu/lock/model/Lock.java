package hu.lock.model;

import java.util.Map;
import java.util.TreeMap;

/**
 * DTO for {@link Lock}
 * @author Peter_Fazekas on 2017.05.07..
 */
public class Lock {

    private final int id;
    private final String code;

    public Lock(final int id, final String code) {
        this.id = id;
        this.code = code;
    }

    public int getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public boolean hasRecurrence() {
        boolean recurrence = false;
        for (Map.Entry<Integer, Integer> codeEntry : createMap().entrySet()) {
            if (codeEntry.getValue() > 1) recurrence = true;
        }
        return recurrence;
    }

    private Map<Integer, Integer> createMap() {
        Map<Integer, Integer> codeMap = new TreeMap<>();
        for (int i = 0; i < code.length(); i++) {
            int key = Integer.parseInt(String.valueOf(code.charAt(i)));
            int value = (codeMap.getOrDefault(key, 0)) + 1;
            codeMap.put(key, value);
        }
        return codeMap;
    }
}

