package GameModel;

import java.io.Serializable;

/**
 * Parent-Class der Spielerinstanzen
 * 
 * @author tobias
 */
public class Player implements Serializable {

    private String name;
    private int nmbOfBoxes;

    public Player() {
        this.nmbOfBoxes = 0;
    }

    public Player(String newName) {
        this.name = newName;
        this.nmbOfBoxes = 0;
    }

    public void plusBox() {
        this.nmbOfBoxes++;
    }

    public void setNmbOfBoxesZero() {
        this.nmbOfBoxes = 0;
    }

    public int getNmbOfBoxes() {
        return this.nmbOfBoxes;
    }

    public void setName(String newName) {
        this.name = newName;
    }
    
    public String getName()    {
        return this.name;
    }
    
    public void resetNmbOfBoxes() {
        nmbOfBoxes = 0;
    }
}
