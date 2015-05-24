/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameView;

import java.awt.Color;



/**
 *
 * @author Frowin Imholz
 * 
 */
public class Line {
    private final int startX;
    private final int startY;
    private final int endX;
    private final int endY;
    private final int tolerance;
    private Color color;
    
    /**
     * 
     * @param startX
     * @param startY
     * @param endX
     * @param endY
     */
    public Line(int startX, int startY, int endX, int endY) {
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
        this.tolerance = 10;
        this.color = Color.GRAY;
    }
    
    /**
     * 
     * @return starting x position of the line
     */
    public int getStartX() {
        return this.startX;
    }
    
    /**
     * 
     * @return starting y position of the line
     */
    public int getStartY() {
        return this.startY;
    }
    
    /**
     * 
     * @return ending x position of the line
     */
    public int getEndX() {
        return this.endX;
    }
    
    /**
     * 
     * @return ending y position of the line
     */
    public int getEndY() {
        return this.endY;
    }
    
    /**
     * 
     * @param newColor
     */
    public void setColor(Color newColor) {
        this.color = newColor;
    }
    
    /**
     * 
     * @return color of the line
     */
    public Color getColor() {
        return this.color;
    }
    
    /**
     * 
     * @param x position
     * @param y position
     * @return true, if line matched
     */
    public boolean lineMatch(int x, int y) {
        if (this.startX-tolerance <= x && x <= this.endX+tolerance) {
            if (this.startY-tolerance <= y && y <= this.endY+tolerance) {
                return true;
            }
        }
        return false;
    }
}
