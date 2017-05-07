package hu.lock.service;

import hu.lock.model.Lock;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * @author Peter_Fazekas on 2017.05.07..
 */
public class LockService {

    private final String base;
    private final List<Lock> lockList;
    private final RandomCode random;
    private final LockOpen lockOpen;


    public LockService(final String base, final List<Lock> lockList) {
        this.base = base;
        this.lockList = lockList;
        random = new RandomCode(new Random());
        lockOpen = new LockOpen(base);
    }

    /**
     * 3. feladat: Jelenítse meg a képernyőn, hogy mely kísérleteknél használták a nyitáshoz pontosan az
     * előző feladatban beolvasott kódszámot! A sorok számát egymástól pontosan egy szóközzel válassza el!
     * @return
     */
    public String successOpen() {
        StringBuilder sb = new StringBuilder();
        lockList.stream()
                .filter(i -> i.getCode().equals(base))
                .map(i -> i.getId() + " ")
                .forEach(sb::append);
        return sb.toString();
    }

    /**
     * 4. feladat: Adja meg, hogy melyik az első olyan próbálkozás, amely ismétlődő karaktert tartalmaz!
     * Ha nem volt ilyen, írja ki a „nem volt ismétlődő számjegy” üzenetet!
     * @return
     */
    public String getRecurrences() {
        Optional<Integer> first = lockList.stream()
                .filter(Lock::hasRecurrence)
                .map(i -> i.getId())
                .findFirst();
        return first.isPresent()
                ? "Az első ismétlődést tartalmazó próbálkozás sorszáma: " + first.get()
                : "Nem volt ismétlődő számjegy";
    }

    /**
     * 5. feladat: Állítson elő egy, a második feladatban beolvasottal egyező hosszúságú, véletlenszerű,
     * ismétlődés nélküli jelsorozatot, majd a mintának megfelelően jelenítse meg a hosszát és az
     * előállított kódszámot!
     * @return
     */
    public String getRandomCode() {
        int length = base.length();
        return String.format("Egy %d hosszú kódszám: %s", length, random.createCode(length));
    }

    /**
     * 7. feladat: Állítsa elő a siker.txt fáljt, amelynek soraiban a nyitási próbálkozás kódszáma után
     * – attól egy szóközzel elválasztva – annak értékelése olvasható.
     *      -   „hibás hossz”, ha a felhasználótól a 2. feladatban bekért kódszám és a sorbeli kódszám hossza eltér;
     *      -   „hibás kódszám”, ha a felhasználótól a 2. feladatban bekért kódszám és a sorbeli kódszám hossza egyezik,
     *          de nem összetartozók;
     *      -   „sikeres”, ha a két kódszám egyenértékű.
     * @return
     */
    public List<String> getDetailedAttempt() {
        return lockList.stream().map(this::createAnswer).collect(Collectors.toList());
    }

    private String createAnswer(final Lock lock) {
        String code = lock.getCode();
        String answer = !lockOpen.lengthCheck(code)
                ? "hibás hossz"
                : !lockOpen.open(code) ? "hibás kódszám" : "sikeres";
        return code + " " + answer;
    }

}
