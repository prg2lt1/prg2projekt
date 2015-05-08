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
 * Erstellt neue Linie mit Anfangs- und Endpunkt sowie Angaben zur spielenden
 * Partei und somit zur Farbe der Linie.
 */
public final class Dot {

    private int x, y, radius;
    private Color fillColor;

    public Dot(int x, int y) {
        this.x = x;
        this.y = y;
        this.radius = 15;
        this.fillColor = new Color(0, 255, 0);
    }

    public Dot(int x, int y, int radius, Color color) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.fillColor = color;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getX() {
        return this.x;
    }

    public void setY(int y) {
        this.x = y;
    }

    public int getY() {
        return this.y;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public int getRadius() {
        return this.radius;
    }

    public final void setFillColor(Color color) {
        this.fillColor = color;
    }

    public final Color getFillColor() {
        return this.fillColor;
    }

}
