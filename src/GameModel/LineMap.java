/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameModel;
import java.util.HashMap;
/**
 *
 * @author tobias
 * HashMap mit sämtlichen existierenden Linien. Koordinatenpaar als Key, Line-Objekt als Value.
 * Dient der schnellen Suche nach dem bereits-vorhanden-sein einer Linie.
 * Andere Spielstandüberprüfungen laufen über die BoxList.
 */
public class LineMap {
   
    private HashMap<Integer, Line> lines;
    
    public LineMap() {
        lines = new HashMap<Integer, Line>();
    }
    
    public void addLineToMap(int coordinates, Line l) {
        lines.put(coordinates, l);
    }
    
    public Line getLine(int key) {
        return lines.get(key);
    }
    
}
