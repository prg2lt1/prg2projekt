/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameView;

import GameModel.Player;
import java.io.Serializable;


/**
 *
 * @author Frowin Imholz
 */
public class Box {
    private final int startX;
    private final int startY;
    private final int endX;
    private final int endY;
    private Player owner;
    
    public Box (int startX, int startY, int endX, int endY){
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
        this.owner = null;
    }
    
    public Box (int startX, int startY, int endX, int endY, Player owner){
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
        this.owner = owner;
    }
    
    public void setOwner(Player owner) {
        this.owner = owner;
    }
    
    public Player getOwner() {
        return this.owner;
    }
    
    public int getStartX() {
        return this.startX;
    }  
    
    public int getStartY() {
        return this.startY;
    }  
    
    public int getEndX() {
        return this.endX;
    }  
    
    public int getEndY() {
        return this.endY;
    }    
}
