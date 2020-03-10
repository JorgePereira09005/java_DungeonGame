/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon;

import java.util.Random;

/**
 *
 * @author Jorge
 */
public class Vampire {
    
    
    private int positionX, positionY;
    
    public Vampire (int x, int y) { 
        this.positionX = x;
        this.positionY = y;
    }
    
    public int getX() {
        return this.positionX;
    }
    
    public int getY() {
        return this.positionY;
    }
    
    public void setCoordinates(int x, int y) {
        this.positionX = x;
        this.positionY = y;
    }
    
    public void setRandomCoordinates(int x, int y) {
        int randomX = 0;
        int randomY = 0;
        
        while(randomX == 0 && randomY == 0) {   
            randomX = new Random().nextInt(x);
            randomY = new Random().nextInt(y);
            this.positionX = randomX;
            this.positionY = randomY;
        }
    }
    
    public void vampMove(int mapLength, int mapHeight) {
        
        int random = new Random().nextInt(4);
        
        switch (random) {
            case 0:
                if (this.positionX > 0) {
                    this.positionX--;
                }
                break;
            case 1:
                if (this.positionX < (mapLength - 1)) {
                    this.positionX++;
                }
                break;
            case 2:
                if (this.positionY > 0) {
                    this.positionY--;
                }
                break;
            case 3:
                if (this.positionY < (mapHeight - 1)) {
                    this.positionY++;
                }
                break;
        }
    }
}
