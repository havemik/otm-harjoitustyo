# Arkkitehtuurikuvaus

## Rakenne

Ohjelman rakenne on kolmitasoinen, Pakkaus TetrisUI rakentaa sovellukselle käyttöliittymän, tetris.logic 
vastaa sovelluslogiikasta, joka vastaa palojen sijainnin muistamisesta ja siirtämisestä logiikan kannalta 
ja tetris.block luo itse palat ja sisältää metodit niiden graafisten mallien siirtämiseen.

## Käyttöliittymä

Käyttöliittymä sisältää kaksi eri näkymää
-Tervetulosivu
-Tetris

Molemmat on toteutettu omana scene -oliona ja vain yksi näkymä on näkyvänä kerrallaan. Käyttyliittymän 
rakentaa luokka hienosti nimetty TetrisUI.TetrisUI.

Kun tetriksen paloja halutaan liikuttaa TetrisUI kutsuu sovelluslogiikassa toteutettuja metodeja, jotka 
siirtävät Pane oliolle piirrettyjä kappaleita.

## Sovelluslogiikka

Sovelluksen logiikan muodostaa vielä nerokkaammin nimetty luokka tetris.logic.TetrisLogic. 
Kun käyttöliittymä saa käyttäjältä esimerkiksi ohjeen siirtää kullakin hetkellä putoavaa tetris palikkaa, 
se kutsuu ensin sovelluslogiikan metodeja, joiden tehtävänä on ensin tarkistaa onko siirto mahdollista 
tehdä, kuten esimerkiksi metodi isDownValidMove kertoo, jos vastaus on kyllä, Sovelluslogiikalta löytyvät 
myös metodit jotka siirtävät palaa sovelluslogiikan taulukossa, ja kutsuvat blocks.Block luokan metodia, 
joka siirtää Pane olielle piirrettyä palan graafista esitystä.

Myös täysien rivien tyhjentäminen ja uusien palojen luominen ovat sovelluslogiikan vastuulla. Palat 
kuitenkin hoitavat kääntymisen itse, koska jokainen pala liikkuu kääntyessään eri asentoon, joten 
toiminnallisuus oli helpompi jakaa paloille.

### Päätoiminnallisuus

Kuvataan Tetris -pelin aloittamista sekvenssikaaviona.  

<img 
src="https://github.com/havemik/otm-harjoitustyo/blob/master/Dokumentaatio/Kuvat/Playing%20a%20game%20of%20tetris.png" 
width="750">

Aloittamalla uuden pelin, käyttyliittymä luo uuden olion TetrisLogicista ja pyytää tältä uuden palikan 
luomista. Logiikka luo Block -olion joka lisätään logiikan taulukkoon ja piirretään käyttöliittymän Pane 
olioon. Kaikki käyttäjän haluamavat (tai ajan kanssa tapahtuvat) liikkeet toteutetaan kutsumalla ensin 
sovelluslogiikkaa, joka tarkastaa voidaanko liikettä suorittaa, ennen kuin palikan graafinen esitys 
siirtyy, tai taulokkoa päivitetään.
