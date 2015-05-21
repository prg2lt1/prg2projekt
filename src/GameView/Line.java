/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameView;

import javafx.scene.paint.Color;


/**
 *
 * @author Frowin Imholz
 * 
 */
public class Line {
    private final Dot startingDot;
    private final Dot endingDot;
    private final Color color;
    
    /**
     * 
     * @param startingDot
     * @param endingDot 
     */
    public Line(Dot startingDot, Dot endingDot) {
        this.startingDot = startingDot;
        this.endingDot = endingDot;
        this.color = Color.GRAY;
    }
    
    /**
     * 
     * @return starting dot of the line
     */
    public Dot getStartingDot() {
        return this.startingDot;
    }
    
    /**
     * 
     * @return ending dot of the line
     */
    public Dot getEndingDot() {
        return this.endingDot;
    }
    
    /**
     * 
     * @return color of the line
     */
    public Color getColor() {
        return this.color;
    }
}
