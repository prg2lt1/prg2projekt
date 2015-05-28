package GameView;

import GameModel.Player;


/**
 * This class defines a Box with starting and ending x-/y-positions.
 * It provides two constructors, one with and one without setting of
 * the box owner.
 * 
 * @author Frowin Imholz
 */
public class Box {
    private final int startX;
    private final int startY;
    private final int endX;
    private final int endY;
    private Player owner;
    
    /**
     * Short constructor, without owner of the box.
     * 
     * @param startX    starting x position
     * @param startY    starting y position
     * @param endX      ending x position
     * @param endY      ending y position 
     */
    public Box (int startX, int startY, int endX, int endY){
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
        this.owner = null;
    }
    
    /**
     * Constructor with owner of the box.
     * 
     * @param startX    starting x position
     * @param startY    starting y position
     * @param endX      ending x position
     * @param endY      ending y position 
     * @param owner     owner of the box
     */
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
