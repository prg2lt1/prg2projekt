/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameModel;

import java.awt.Color;

/**
 *
 * @author tobias
 *
 *
 */
public final class Dot {

    private int x, y, radius;
    private Color fillColor;

    public Dot(int x, int y) {
        this.x = x;
        this.y = y;
        this.radius = 20;
        this.fillColor = Color.GRAY;
    }

    public Dot(int x, int y, int radius, Color color) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.fillColor = color;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public int getRadius() {
        return this.radius;
    }

    public final Color getFillColor() {
        return this.fillColor;
    }
}
