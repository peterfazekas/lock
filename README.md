<h1>Lock - Zár</h1>
<h2>Informatika érettségi emelt szintű feladat: 2016. május</h2> 
<p>Egy ajtót elektronikus zárral láttak el. A zárat egy ismétlődő pontokat nem tartalmazó, megfelelő irányban rajzolt, törött vonalból álló mintával lehet nyitni. A minta megadását egy szabályos tízszög segíti, amelynek csúcsait <b>0</b>-tól <b>9</b>-ig sorszámozták, így a leghosszabb használható minta 10 számjegyet tartalmazhat. Az ajtót nyitó kódszám megadásánál csupán az alakzat és annak iránya érdekes, ezért a <b>135</b> mintával nyitható zárat a <b>802</b> is nyitja (vagy akár a <b>024</b> kódszám is), de a <b>208</b> nem. Tehát ebben a mintában a zár csak az óramutató járásával megegyező irányban nyílik. A nyitás az egyes számok egymást követő megérintésével történik.</p>
<p>Az ajto.txt fájl soronként egy-egy nyitási próbálkozás adatait tartalmazza. A fájlban legfeljebb 500 sor, soronként legalább 3, legfeljebb 10 karakter lehet.</p>
<p>Készítsen programot, amely az <base>ajto.txt</base> állomány adatait felhasználva az alábbi kérdésekre válaszol! A program forráskódját mentse zar néven! (A program megírásakor a felhasználó által megadott adatok helyességét, érvényességét nem kell ellenőriznie, feltételezheti, hogy a rendelkezésre álló adatok a leírtaknak megfelelnek.)</p>
<p>A képernyőre írást igénylő részfeladatok eredményének megjelenítése előtt írja a képernyőre a feladat sorszámát (például: <base>3. feladat:</base>)! Ha a felhasználótól kér be adatot, jelenítse meg a képernyőn, hogy milyen értéket vár! Az ékezetmentes kiírás is elfogadott.</p>
<ol>
<li>Olvassa be és tárolja el az ajto.txt fájl tartalmát!</li>
<li>Kérjen be a felhasználótól egy számjegysorozatot, amely a zár kódszáma lesz! (Feltételezheti, hogy a felhasználó ismétlődés nélküli jelsorozatot ad meg.) A teszteléshez használhatja a <b>239451</b> sorozatot is.</li>
<li>Jelenítse meg a képernyőn, hogy mely kísérleteknél használták a nyitáshoz pontosan az előző feladatban beolvasott kódszámot! A sorok számát egymástól pontosan egy szóközzel válassza el! (A sorok számozását 1-től kezdje!)</li>
<li>Adja meg, hogy melyik az első olyan próbálkozás, amely ismétlődő karaktert tartalmaz! Ha nem volt ilyen, írja ki a „<base>nem volt ismétlődő számjegy</base>” üzenetet! (A sorok számozását 1-től kezdje!)</li>
<li>Állítson elő egy, a második feladatban beolvasottal egyező hosszúságú, véletlenszerű, ismétlődés nélküli jelsorozatot, majd a mintának megfelelően jelenítse meg a hosszát és az előállított kódszámot!</li>
<li>Készítsen függvényt nyit néven az alábbi algoritmus alapján, amely a neki átadott két kódszámról megállapítja, hogy ugyanazt a zárat nyitják-e! (A <b>239451</b> és a <b>017239</b> ugyanazt a zárat nyitja.) A függvény két, legfeljebb 10 számjegyből álló karaktersorozathoz egy logikai értéket rendel. A függvény elkészítésekor az algoritmusban megadott változóneveket használja! Az elkészített függvényt a következő feladat megoldásánál felhasználhatja.</li>
<pre>
	Függvény nyit(jo, proba:karaktersorozat): logikai érték
		egyezik:=(hossz(jo)=hossz(proba))
		Ha egyezik akkor
			elteres=ascii(jo[1])-ascii(proba[1])
			Ciklus i:=2-től hossz(jo)
				Ha ( elteres - (ascii(jo[i])-ascii(proba[i])) ) mod 10 <> 0
				akkor egyezik:=hamis
			Ciklus vége
		Elágazás vége
		nyit:=egyezik
	Függvény vége
</pre>
<p>A mondatszerű leírásban:</p>
<ul>
<li>az a mod b művelet eredménye az a szám b számmal történő osztásának maradéka;</li>
<li>az ascii() függvény egy karakterhez annak karakterkódját rendeli.</li>
</ul>
<p>Az ascii() függvény megvalósításához használhatja a következőket az egyes programozási nyelveken:</p>
<pre>
	C, C++, C#, Java: (int)karakter; (char)asciikod
	Pascal, Python, Perl: ord(karakter); chr(asciikod)
	Visual Basic: Asc(karakter); Chr(asciikod)
</pre>
<li>Állítsa elő a siker.txt fáljt, amelynek soraiban a nyitási próbálkozás kódszáma után – attól egy szóközzel elválasztva – annak értékelése olvasható.
<ul>
<li>„hibás hossz”, ha a felhasználótól a 2. feladatban bekért kódszám és a sorbeli kódszám hossza eltér;</li>
<li>„hibás kódszám”, ha a felhasználótól a 2. feladatban bekért kódszám és a sorbeli kódszám hossza egyezik, de nem összetartozók;</li>
<li>„sikeres”, ha a két kódszám egyenértékű.</li>
</ol>
<h3>Minta a szöveges kimenetek kialakításához:</h3>
<pre>
2. feladat
Adja meg, mi nyitja a zárat! 239451
3. feladat
A nyitó kódszámok sorai: 1 4 5 8 10…
4. feladat
Az első ismétlődést tartalmazó próbálkozás sorszáma: 9
5. feladat
Egy 6 hosszú kódszám: 078695
</pre>
<h3>Részlet a <base>siker.txt</base> fájlból:</h3>
<pre>
239451 sikeres
154932 hibás kódszám
340562 sikeres
…
</pre>
<hr>
<h3>Források:</h3>
<li><a href="https://www.oktatas.hu/bin/content/dload/erettsegi/feladatok_2016tavasz_emelt/e_infmafor_16maj_fl.zip">Feladatlap</a>
<li><a href="https://www.oktatas.hu/bin/content/dload/erettsegi/feladatok_2016tavasz_emelt/e_infmafor_16maj_fl.zip">Forrásállományok</a>


