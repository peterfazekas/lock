package hu.lock.data.service;

import hu.lock.data.read.CodeReader;
import hu.lock.data.read.DataReader;
import hu.lock.model.Lock;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Peter_Fazekas on 2017.05.07..
 */
public class Data {

    private static int id = 1;

    public List<Lock> getData(final String fileName) {
        DataReader file = new CodeReader(fileName);
        return parser(file.read());
    }

    private List<Lock> parser(List<String> lines) {
        return lines.stream().map(this::createLock).collect(Collectors.toList());
    }

    private Lock createLock(final String code) {
        return new Lock(id++, code);
    }

}
