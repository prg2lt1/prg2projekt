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
    private ArrayList<Line> horizontalLineList;
    private ArrayList<Line> verticalLineList;
    private ArrayList<Dot> dotList;
    
    
    public Board(int size) {
        
        this.size = size;
        
        dotList = createDots();
        boxList = createBoxes();
        horizontalLineList = createHorizontalLines();
        verticalLineList = createVerticalLines();
        
    }
    
    /**
     * Erstellt Dot-List für das Spielfeld mit xy Koordinaten für jeden Dot, Startpunkt bei 00, Ende bei size-1xsize-1
     * @return 
     */
    private ArrayList<Dot> createDots() {
        
        dotList = new ArrayList<Dot>();
        
        for (int y = 0; y < size; y++) {
            for (int x = 0; x < size; x++) {
                dotList.add(new Dot(x, y));
            }
        }
        
        return dotList;
    }
    
    
    
    private ArrayList<Line> createHorizontalLines() {
        
        horizontalLineList = new ArrayList<Line>();
        Dot first;
        Dot second;
        
        for (int index=0; index <= dotList.size() -2; index++)  {
            first = dotList.get(index);
            second = dotList.get(index+1);
            horizontalLineList.add(new Line(first, second));
        }
        return horizontalLineList;
    }
    
    private ArrayList<Line> createVerticalLines() {
        
        verticalLineList = new ArrayList<Line>();
        Dot first;
        Dot second;
        
        for (int index=0; index <= dotList.size()-size-1; index++)  {
            first = dotList.get(index);
            second = dotList.get(index+4);
            verticalLineList.add(new Line(first, second));
        }
        return verticalLineList;
    }
 
    
     private ArrayList<Box> createBoxes() {
        
        boxList = new ArrayList<Box>();
        return boxList;
    }
    
  
    
    
    
}
