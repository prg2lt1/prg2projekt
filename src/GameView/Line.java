/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameView;

import java.awt.Color;

/**
 * Line class
 *
 * @author Frowin Imholz
 *
 */
public class Line {

    private final int startX;
    private final int startY;
    private final int width;
    private final int height;
    private final int tolerance;
    private final Color defaultColor;
    private Color color;

    /**
     *
     * @param startX
     * @param startY
     * @param endX
     * @param endY
     * @param thickness
     */
    public Line(int startX, int startY, int endX, int endY, int thickness) {
        if (startX == endX) {
            this.width = thickness;
            this.startX = startX - this.width / 2;
        } else {
            this.width = endX - startX;
            this.startX = startX;
        }
        if (startY == endY) {
            this.height = thickness;
            this.startY = startY - this.height / 2;
        } else {
            this.height = endY - startY;
            this.startY = startY;
        }

        this.tolerance = 10;
        this.defaultColor = Color.GRAY;
        this.color = defaultColor;
    }

    /**
     *
     * @return start position x of the line
     */
    public int getStartX() {
        return this.startX;
    }

    /**
     *
     * @return start position y of the line
     */
    public int getStartY() {
        return this.startY;
    }

    /**
     *
     * @return width of the line
     */
    public int getWidth() {
        return this.width;
    }

    /**
     *
     * @return height of the line
     */
    public int getHeight() {
        return this.height;
    }

    /**
     *
     * @param color
     */
    public void setColor(Color color) {
        if (color != this.defaultColor){
            this.color = color;
        }
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
        if (this.startX - this.tolerance <= x && x <= this.startX + this.width + this.tolerance) {
            if (this.startY - this.tolerance <= y && y <= this.startY + this.height + this.tolerance) {
                return true;
            }
        }
        return false;
    }
}
