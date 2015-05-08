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
 * Erstellt neue Linie mit Anfangs- und Endpunkt sowie Angaben zur spielenden Partei und somit zur Farbe der Linie.
 */
public class Line {
    
   
    private final int startingPoint;
    private final int endingPoint;
    private Color color;
    private final boolean playedByOpponent;
    
    /**
     * 
     * @param start Zeilennummer-Spaltennummer des Startpunktes (ganz oben links wäre 11)
     * @param end Zeilennummer-Spaltennummer des Endpunktes (ganz unten links wäre n1)
     * @param playedByOpponent TRUE falls Spielzug von Opponent-Instanz ausgeführt wurde
     */
    public Line(int start, int end, boolean playedByOpponent) {
        
        startingPoint = start;
        endingPoint = end;
        this.playedByOpponent = playedByOpponent;
        setColor(playedByOpponent);
    }
    
    
    
    public int getStartingPoint() {
        return startingPoint;
    }
    
    public int getEndingPoint() {
        return endingPoint;
    }
    
    public int getCoordinates() {
        return Integer.parseInt(String.valueOf(startingPoint+""+endingPoint));
    }
    /**
     * 
     * @param p TRUE falls Spielzug vom Gegner ausgeführt.
     * 
     */
    public final void setColor(boolean p) {
        
        if(p) {       // somit Gegenspieler, "computer" oder "network"
            color = new Color(255, 0, 0); // = Rot
        }
        else {
            color = new Color(0, 0, 255); // = Blau
        }
    }
    
}
