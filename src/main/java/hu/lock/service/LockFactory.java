package hu.lock.service;

import hu.lock.model.Lock;

import java.util.List;

/**
 * Static Factory Method for {@link LockService}.
 * @author Peter_Fazekas on 2017.05.07..
 */
public class LockFactory {

    public static LockService createLockService(final String code, final List<Lock> codeList) {
        return new LockService(code, codeList);
    }
}
