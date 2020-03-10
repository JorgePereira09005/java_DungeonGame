/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Jorge
 */
public class Dungeon {
    
    private int length, height, vampires, moves;
    private boolean vampireMove;
    private int playerX, playerY;
//    private Scanner reader;
    private List<Vampire> baddies;
    
    public Dungeon(int length, int height, int vampires, int moves, boolean vampiresMove) {
        
        this.length = length;
        this.height = height;
        this.vampires = vampires;
        this.moves = moves;
        this.vampireMove = vampiresMove;
        this.baddies = new ArrayList<Vampire>();
        this.playerX = 0;
        this.playerY = 0;
    }
    
    public void useMove() {
        this.moves--;
    }
    
    public void spawnBaddies() {

        int randomX = 0;
        int randomY = 0;
        boolean repeatingCoordinates = false;
        
        while (this.baddies.size() < this.vampires) {
            
            randomX = new Random().nextInt(this.length);
            randomY = new Random().nextInt(this.height);
            
            while(randomX == 0 && randomY == 0) {
                randomX = new Random().nextInt(this.length);
                randomY = new Random().nextInt(this.height);
                
            }
            for (Vampire baddy : this.baddies) {
                
                if (randomX == baddy.getX() && randomY == baddy.getY()) {
                    
                    repeatingCoordinates = true;
                }
            }
            if (!repeatingCoordinates) {
                
                this.baddies.add(new Vampire(randomX, randomY));
            }
        }
    }
    
    public void executeMove(Vampire vampire) {
        int support = 0;
        int savedX = vampire.getX();
        int savedY = vampire.getY();
        vampire.vampMove(this.length, this.height);
        
        for (Vampire baddy : this.baddies) {
            if (vampire.getX() == baddy.getX() && vampire.getY()== baddy.getY()) {
                support++;
            }
        }
        if (support > 1) {
            vampire.setCoordinates(savedX, savedY);
        }
    }
    
    public void moveVampires() {
        
        if (this.vampireMove) {
            for (Vampire baddy : this.baddies) {
                this.executeMove(baddy);
            }
        }
    }
    
    public void bopBaddies() {
        List<Vampire> bopped = new ArrayList<Vampire>();
        
        for (Vampire vampire : this.baddies) {
            if (this.playerX == vampire.getX() && this.playerY==vampire.getY()) {
                bopped.add(vampire);
            }   
        }
        this.baddies.removeAll(bopped);
    }
    
    private void playerMove(String direction) {
        
        int index = 0;
        char supportChar = 'o';
        
        while (index < direction.length()) {
            supportChar = direction.charAt(index);
           
            if (supportChar == 'w' && this.playerY > 0 ) {
                this.playerY--;
            }
            if (supportChar == 's' && this.playerY < this.height -1 ) {
                this.playerY++;
            }
            if (supportChar == 'a' && this.playerX > 0 ) {
                this.playerX--;
            }
            if (supportChar == 'd' && this.playerX < this.length - 1) {
                this.playerX++;
            }
            index++;        
        } 
    }
    
    
    public void drawDungeon() {
        
        String dungeon = "";
        
        for (int i=0; i < this.height; i++) {
            for (int j=0; j < this.length; j++) {
                
                boolean addDot = true;
                
                if (this.playerX == j && this.playerY == i) {
                    dungeon += "@";
                    addDot = false;
                }
                for (Vampire baddy : this.baddies) {
                    if (baddy.getX() == j && baddy.getY() == i) {
                        dungeon += "v";
                        addDot = false;
                    }
                }
                if (addDot) {
                    dungeon +=".";
                }
                
                if (j == (this.length - 1)) {
                    dungeon += "\n";
                }
            }
        }
        System.out.println(dungeon);
    }

    public void printPositions() {
        
        System.out.println("@ " + this.playerX + " " + this.playerY);
        for (Vampire baddy : this.baddies) {
            System.out.println("v " + baddy.getX() + " " + baddy.getY());
        }
    }

    public void run() {
        
        Scanner reader = new Scanner(System.in);
//        int movesLeft = this.moves;
        
        this.spawnBaddies();
        
        while (this.moves >= 0) {
            
            System.out.println(this.moves);
            System.out.println("");
            
            this.printPositions();
            System.out.println("");
            this.drawDungeon();
            System.out.println("");
            
            
            String steps = reader.nextLine();
            
            this.playerMove(steps);
            
            this.moveVampires();
            
            this.bopBaddies();
            
            
            this.useMove();
            
            if (this.baddies.isEmpty()) {
                System.out.println("YOU WIN");
                break;
            }
            if (this.moves == 0) {
                System.out.println("YOU LOSE");
                break;
            }
        }
    }
}
