package hu.lock.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Random code generator.
 * @author Peter_Fazekas on 2017.05.07..
 */
class RandomCode {

    private final Random random;
    private final List<Integer> options;

    public RandomCode(final Random random) {
        this.random = random;
        options = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));
    }

    public String createCode(final int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(generateNumber());
        }
        return sb.toString();
    }

    private int generateNumber() {
        return options.remove(random.nextInt(options.size()));
    }
}
