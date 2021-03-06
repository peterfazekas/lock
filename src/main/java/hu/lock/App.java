package hu.lock;

import hu.lock.data.log.DataLogger;
import hu.lock.data.log.FileLogger;
import hu.lock.data.service.Data;
import hu.lock.service.Console;
import hu.lock.service.LockFactory;
import hu.lock.service.LockService;

import java.util.Scanner;

/**
 * Lock - Main method.
 * @author Peter_Fazekas on 2017.05.07..
 */
class App {

    private static final String INPUT = "ajto.txt";
    private static final String OUTPUT = "siker.txt";

    private final Data data;
    private final Console console;
    private final DataLogger log;

    private App() {
        data = new Data();
        console = new Console(new Scanner(System.in));
        log = new FileLogger(OUTPUT);
    }

    public static void main(String[] args) {
        App app = new App();
        app.println();
    }

    private void println() {
        System.out.print("2. feladat: Adja meg mi nyitja a zárat: ");
        String code = console.readLine();
        LockService lock = LockFactory.createLockService(code, data.getData(INPUT));
        System.out.println("3. feladat: A nyitó kódszámok sorai: " + lock.getSameLockIds());
        System.out.println("4. feladat: " + lock.getFirstRecurrence());
        System.out.println("5. feladat: " + lock.getRandomCode());
        log.printAll(lock.getDetailedAttemptList());
    }
}
