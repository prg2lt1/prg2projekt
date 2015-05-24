/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameModel;

import java.io.Serializable;

/**
 *
 * @author Tobias Heer
 *
 *
 */
public final class Dot implements Serializable {
    private final int x, y;

    /**
     * 
     * @param x
     * @param y 
     */
    public Dot(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * 
     * @return x position of the dot
     */
    public int getX() {
        return this.x;
    }

    /**
     * 
     * @return y position of the dot
     */
    public int getY() {
        return this.y;
    }
}
