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
 *
 */
public final class Dot {
    private final int x, y, radius;
    private final Color color;

    /**
     * 
     * @param x
     * @param y 
     */
    public Dot(int x, int y) {
        this.x = x;
        this.y = y;
        this.radius = 25;
        this.color = Color.GRAY;
    }
    
    public int getX(){
        return this.x;
    }
    
    public int getY(){
        return this.y;
    }
    
    public int getRadius(){
        return this.radius;
    }
    
    public Color getColor(){
        return this.color;
    }
}
