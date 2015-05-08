/**
 * Memory beinhaltet sämtliche Speicherstrukturen, welche im Gameplay benötigt
 * werden.
 */
package GameModel;

import java.util.ArrayList;
import java.util.Iterator;

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
    public int getSize(){
        return BoxList.size();
    }
    
    public boolean isEmpty(){
        return BoxList.isEmpty();
    }
    
    public Iterator getIterator(){
        return BoxList.iterator();
    }

    public void clearAllBoxes(){
        BoxList.clear();
    }
}
