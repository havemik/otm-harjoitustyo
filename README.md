**AIVAN MAHTAVA README**

Nonni tässäpä on mahtava readme tälle *hianolle* tetrikselle!
Tarkoituksena siis tehdä tetris, eli peli jossa palikoita tippuu 
taivaalta ja niitä kasataan mahdollisimman tasaisesti pohjalle.
Paloja kyllä tippuu ja niitä voi kasata ja tuhota, vaan kääntäminen kenkkuilee.

[Vaatimusmäärittely](https://github.com/havemik/otm-harjoitustyo/blob/master/Dokumentaatio/Vaatimusmaarittely.md)

[Arkkitehtuurikuvaus](https://github.com/havemik/otm-harjoitustyo/blob/master/Dokumentaatio/arkkitehtuuri.md)

[Tuntikirjanpito](https://github.com/havemik/otm-harjoitustyo/blob/master/Dokumentaatio/tuntikirjanpito.md)

[(Pre-)Release](https://github.com/havemik/otm-harjoitustyo/releases/tag/viikko5)


## Komentorivitoiminnot

### Testaus

Testit suoritetaan komennolla

```
mvn test
```

Testikattavuusraportti luodaan komennolla

```
mvn jacoco:report
```

Kattavuusraporttia voi tarkastella avaamalla selaimella tiedosto _target/site/jacoco/index.html_

### Suoritettavan jarin generointi

Komento

```
mvn package
```

generoi hakemistoon _target_ suoritettavan jar-tiedoston _Tetris-1.0-SNAPSHOT.jar_

### JavaDoc

JavaDoc generoidaan komennolla

```
mvn javadoc:javadoc
```

JavaDocia voi tarkastella avaamalla selaimella tiedosto _target/site/apidocs/index.html_

### Checkstyle

Checkstyle tarkistukset suoritetaan komennolla

```
 mvn jxr:jxr checkstyle:checkstyle
```

Mahdolliset virheilmoitukset selviävät avaamalla selaimella tiedosto _target/site/checkstyle.html_
