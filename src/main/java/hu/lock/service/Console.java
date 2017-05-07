package hu.lock.service;

import java.util.Scanner;

/**
 * @author Peter_Fazekas on 2017.05.07..
 */

/**
 * 2. feladat: Kérjen be a felhasználótól egy számjegysorozatot, amely a zár kódszáma lesz!
 */
public class Console {

    private final Scanner sc;

    public Console(final Scanner sc) {
        this.sc = sc;
    }

    public String readLine() {
        return sc.nextLine();
    }
}
