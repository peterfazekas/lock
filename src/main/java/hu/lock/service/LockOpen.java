package hu.lock.service;

/**
 * 6. feladat: Készítsen függvényt nyit néven az alábbi algoritmus alapján, amely a neki átadott két kódszámról
 * megállapítja, hogy ugyanazt a zárat nyitják-e! (A 239451 és a 017239 ugyanazt a zárat nyitja.)
 * A függvény két, legfeljebb 10 számjegyből álló karaktersorozathoz egy logikai értéket rendel.
 *
 * @author Peter_Fazekas on 2017.05.07..
 */
class LockOpen {

    private static final int TEN = 10;
    private final String base;

    public LockOpen(final String base) {
        this.base = base;
    }

    public boolean open(final String code) {
        return lengthCheck(code) && isMatchAll(code, codeDistance(code));
    }

    public boolean lengthCheck(final String code) {
        return base.length() == code.length();
    }

    private boolean isMatchAll(final String code, final int difference) {
        boolean match = true;
        for (int i = 1; i < base.length(); i++) {
            match = isMatch(code, difference, i) && match;
        }
        return match;
    }

    private boolean isMatch(final String code, final int difference, final int i) {
        return (difference - codeDistance(code, i)) % TEN == 0;
    }

    private int codeDistance(final String code) {
        return codeDistance(code, 0);
    }

    private int codeDistance(final String code, final int i) {
        return (int) base.charAt(i) - (int) code.charAt(i);
    }
}
