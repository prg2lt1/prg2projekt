/**
 * Memory beinhaltet sämtliche Speicherstrukturen, welche im Gameplay benötigt
 * werden.
 */
package GameModel;

import java.util.ArrayList;

/**
 *
 * @author Lorenz
 */
public class Memory {

    private ArrayList<Box> BoxList; //Liste der Boxen auf dem Spielfeld. ungeordnet.

    public Memory() {
        BoxList = new ArrayList<>();
    }

    public void addBox(Box newBox) {
        this.BoxList.add(newBox);
    }

    public Box getBox(int index) {
        return BoxList.get(index);
    }
    public boolean isEmpty(){
        return BoxList.isEmpty();
    }

    public void clearAllBoxes(){
        BoxList.clear();
    }
}
