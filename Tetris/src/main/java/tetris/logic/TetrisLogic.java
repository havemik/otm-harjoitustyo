/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris.logic;

import tetris.blocks.Block;
import tetris.blocks.IBlock;
import tetris.blocks.JBlock;
import tetris.blocks.LBlock;
import tetris.blocks.Piece;
import tetris.blocks.SBlock;
import tetris.blocks.Square;
import tetris.blocks.TBlock;
import tetris.blocks.ZBlock;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.Node;

/**
 *Sovelluksen sovelluslogiikka.
 * 
 * Logiikka toimii merkitsemällä palikoiden sijainteja kaksiulotteiseen taulukkoon,
 * ykköset merkitsevät aktiivisena olevaa palaa johon käyttäjän syöte kohdistuu,
 * kakkoset passiivisia paloja, jotka voidaan tarvittaessa poistaa ja nollta
 * ovat tyhjää tilaa.
 * 
 * @author Mikko
 */
public class TetrisLogic {

    private int[][] pieceMap;

    public TetrisLogic() {
        this.pieceMap = new int[10][22];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 20; j++) {
                pieceMap[i][j] = 0;
            }

        }
    }
    
     /**
     * Metodi tarkistaa onko alaspäin siirto mahdollista tehdä.
     * 
     * @param   b  siirtyvä palikka
     */
    public boolean isDownValidMove(Block b) {
        boolean canEveryPieceMove = true;
        for (int i = 0; i < 10; i++) {
            if (this.pieceMap[i][20] == 1) {
                canEveryPieceMove = false;
            }
        }
        if (this.pieceMap[b.getP1().getX()][b.getP1().getY() + 1] == 2) {
            canEveryPieceMove = false;
        }
        if (this.pieceMap[b.getP2().getX()][b.getP2().getY() + 1] == 2) {
            canEveryPieceMove = false;
        }
        if (this.pieceMap[b.getP3().getX()][b.getP3().getY() + 1] == 2) {
            canEveryPieceMove = false;
        }
        if (this.pieceMap[b.getP4().getX()][b.getP4().getY() + 1] == 2) {
            canEveryPieceMove = false;
        }
        return canEveryPieceMove;
    }

     /**
     * Metodi siirtää aktiivisia paloja oikealle.
     * 
     * @param   b  Palikka joka siirretään
     */
    public void right(Block b) {
        boolean isLastColumnFree = true;
        for (int i = 0; i < 20; i++) {
            if (this.pieceMap[this.pieceMap.length - 1][i] == 1) {
                isLastColumnFree = false;
            }
        }
        if (isLastColumnFree == true) {
            for (int j = 0; j < 20; j++) {
                for (int k = 9; k >= 0; k--) {
                    if (this.pieceMap[k][j] == 1) {
                        this.pieceMap[k + 1][j] = 1;
                        this.pieceMap[k][j] = 0;
                    }
                }
            }
            b.getP1().x++;
            b.getP2().x++;
            b.getP3().x++;
            b.getP4().x++;
            b.right();
        }
    }

     /**
     * Metodi siirtää aktiivisia paloja vasemmalle.
     * 
     * @param   b  Palikka joka siirretään
     */
    public void left(Block b) {
        boolean isFirstColumnFree = true;
        for (int i = 0; i < 20; i++) {
            if (this.pieceMap[0][i] == 1) {
                isFirstColumnFree = false;
            }
        }
        if (isFirstColumnFree == true) {
            for (int j = 0; j < 20; j++) {
                for (int k = 0; k < 10; k++) {
                    if (this.pieceMap[k][j] == 1) {
                        this.pieceMap[k - 1][j] = 1;
                        this.pieceMap[k][j] = 0;
                    }
                }
            }
            b.getP1().x--;
            b.getP2().x--;
            b.getP3().x--;
            b.getP4().x--;
            b.left();
        }
    }

     /**
     * Metodi siirtää aktiivisia paloja alas.
     * 
     * @param   b  Palikka joka liikkuu
     */
    public void down(Block b) {
        for (int i = 20; i >= 0; i--) {
            for (int j = 0; j < 10; j++) {
                if (this.pieceMap[j][i] == 1) {
                    this.pieceMap[j][i + 1] = 1;
                    this.pieceMap[j][i] = 0;
                }
            }
        }
        b.getP1().y++;
        b.getP2().y++;
        b.getP3().y++;
        b.getP4().y++;
        b.down();
    }

     /**
     * Metodi muuntaa aktiiviset palat epäaktiivisiksi sovelluslogiikassa.
     * 
     * @param   b  Palikka joka saavutti pohjan
     */
    public void dropOldBlock(Block b) {
        for (int i = 20; i >= 0; i--) {
            for (int j = 0; j < this.pieceMap.length; j++) {
                if (this.pieceMap[j][i] == 1) {
                    this.pieceMap[j][i] = 2;
                }
            }
        }
    }

    /**
     * Metodi päivittää Sovelluslogiikkaa kun täysi rivi tulee poistaa
     * 
     * @param   game  Peliruutu jossa palikat sijaitsevat
     * 
     */
    public void clearRows(Pane game) {
        for (int i = 20; i >= 0; i--) {
            boolean rowIsFull = true;
            for (int j = 0; j < this.pieceMap.length; j++) {
                if (this.pieceMap[j][i] != 2) {
                    rowIsFull = false;
                }
            }
            if (rowIsFull == true) {
                for (int k = 0; k < this.pieceMap.length; k++) {
                    this.pieceMap[k][i] = 0;
                    dropBricks(k);
                    clearRowsGraphic(game, i);
                }
            }
        }
    }

     /**
     * Metodi poistaa yhden rivin palat käyttöliittymästä
     * 
     * @param   game  Peliruutu jossa palikat sijaitsevat
     * @param   y Mikä rivi poistettiin.
     */   
    public void clearRowsGraphic(Pane game, int y) {
        game.getChildren().removeIf(a -> a.getTranslateY() == (y * 10));
        dropBlocksGraphic(game, y);
    }

     /**
     * Metodi päivittää käyttöliittymää kun täysi rivi on poistettu
     * 
     * @param   game  Peliruutu jossa palikat sijaitsevat
     * @param   y Mikä rivi poistettiin, eli mitä ylemmät palat tulee pudottaa.
     */
    public void dropBlocksGraphic(Pane game, double y) {
        game.getChildren().forEach(a -> {
            if (a.getTranslateY() < (y  * 10) && a.getTranslateY() > 10){
                a.setTranslateY(a.getTranslateY() + 1);
            }
        });
    }

     /**
     * Metodi muuntaa taulukon aktiiviset palat (eli 4 ykköstä) epäaktiivisiksi eli kakkosiksi.
     *Kääntäminen tapahtuu kolumni kerrallaan.
     * 
     * @param   column  Mikä kolumni käännetään
     * 
     */
    public void dropBricks(int column) {
        for (int i = 19; i >= 0; i--) {
            if (this.pieceMap[column][i] == 2 && this.pieceMap[column][i + 1] != 2) {
                this.pieceMap[column][i + 1] = 2;
                this.pieceMap[column][i] = 0;
            }
        }
    }
    
    
    //Now this thing doesnt work. It's not even that it doesn't work, but it doesn't work inconsistently.
    //It's implemented for 4 blocks, supposedly in a similar manner, yet works differently in every situation.
    //It breaks Z Blocks, doesn't do anything for S Blocks, leaves mysterious after images for T Blocks and 
    //works perfectly for IBlocks - but doesn't check if it will end up outside the array. Something to be added I guess.
    // I have no idea how to explain all of these issues, much less how to fix them.
    //Also, since deadline is today, later may not actually come. 
    public void rotate(Block b, Pane game){
        
        Block c = b.rotate(b);
        
    }

    public Block createBlock() {
        Random r = new Random();
        int i = r.nextInt(7) + 1;
        if (i == 1) {
            LBlock b = new LBlock(this);
            return b;
        }

        if (i == 2) {
            Square s = new Square(this);
            return s;
        }

        if (i == 3) {
            JBlock j = new JBlock(this);
            return j;
        }

        if (i == 4) {
            IBlock ib = new IBlock(this);
            return ib;

        }

        if (i == 5) {
            SBlock sb = new SBlock(this);
            return sb;
        }

        if (i == 6) {
            ZBlock z = new ZBlock(this);
            return z;
        }

        if (i == 7) {
            TBlock t = new TBlock(this);
            return t;
        }
        return null;
    }

    public int[][] getPieceMap() {
        return pieceMap;
    }

}
