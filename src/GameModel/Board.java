/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameModel;
import java.util.ArrayList;

/**
 *
 * @author tobias
 */
public class Board {
    
    private int size;
    
    private ArrayList<Box> boxList;
    private ArrayList<Line> lineList;
    private ArrayList<Dot> dotList;
    
    
    public Board(int size) {
        
        this.size = size;
        
        dotList = createDots();
        boxList = createBoxes();
        lineList = createLineList();
        
    }
    
    /**
     * Erstellt Dot-List für das Spielfeld mit xy Koordinaten für jeden Dot, Startpunkt bei 00, Ende bei size-1xsize-1
     * @return 
     */
    private ArrayList<Dot> createDots() {
        
        dotList = new ArrayList<Dot>();
        
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                dotList.add(new Dot(x, y));
            }
        }
        
        return dotList;
    }
    
    
    
    private ArrayList<Line> createLineList() {
        
        lineList = new ArrayList<Line>();
        return lineList;
    }
 
    
     private ArrayList<Box> createBoxes() {
        
        boxList = new ArrayList<Box>();
        return boxList;
    }
    
  
    
    
    
}
