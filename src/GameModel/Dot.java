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
        setX(x);
        setY(y);
        setRadius(5);
        setFillColor(new Color(125, 125, 125));
    }

    public Dot(int x, int y, int radius, Color color) {
        setX(x);
        setY(y);
        setRadius(radius);
        setFillColor(color);
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getX() {
        return x;
    }

    public void setY(int y) {
        this.x = y;
    }

    public int getY() {
        return y;
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
