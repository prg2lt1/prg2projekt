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
    
    /**
     * 
     * @param size Seitenlänge in Anzahl Dots eines n x n Spielfelds. 
     */
    public Board(int size) {
        
        this.size = size;
        
        dotList = createDots();
        lineList = createLines();
        boxList = createBoxes();
        
    }
    
    public int getSize(){
        return this.size;
    }
    
    /**
     * Erstellt Dot-List für das Spielfeld mit xy Koordinaten für jeden Dot, Startpunkt bei 00, Ende bei size-1xsize-1
     * @return 
     */
    private ArrayList<Dot> createDots() {
        
        dotList = new ArrayList<>();
        
        for (int y = 0; y < size; y++) {
            for (int x = 0; x < size; x++) {
                dotList.add(new Dot(x, y));
            }
        }
        
        return dotList;
    }
    
    public ArrayList<Dot> getDots(){
        return dotList;
    }
    
    private ArrayList<Line> createLines() {
        
        lineList = new ArrayList<>();
        Dot first;
        Dot second;
        
        //Horizontal Lines
        for (int index=0; index < dotList.size()-1; index++)  {
            
            if(index%size == size-1) {
            index++;
            }
            
            first = dotList.get(index);
            second = dotList.get(index+1);
            lineList.add(new Line(first, second));
        }
        //Vertical Lines
        for (int index=0; index < dotList.size()-size; index++)  {
            first = dotList.get(index);
            second = dotList.get(index+size);
            lineList.add(new Line(first, second));
        }
        
        
        return lineList;
    }
   
    
     private ArrayList<Box> createBoxes() {
        
        boxList = new ArrayList<>();
        int totalBoxes = (size-1)^2;
        Line top;
        Line bottom;
        Line left;
        Line right;
        
        for (int boxno = 0; boxno < totalBoxes; boxno++)    {
         
         int horizontalIndex = 0;   
         int verticalIndex = size*(size-1);
         top = lineList.get(horizontalIndex);
         bottom = lineList.get(horizontalIndex+size-1);
         
         if(verticalIndex%size == size-1) {
             verticalIndex++;
         }
         left = lineList.get(verticalIndex);
         right = lineList.get(verticalIndex+1);
         boxList.add(new Box(boxno, top, bottom, left, right ));
         
         horizontalIndex++;
         verticalIndex++;
         
        }
        return boxList;
    }
     
     public ArrayList<Box> getBoxes(){
         return boxList;
     }
     
    public ArrayList<Line> getLines(){
        return lineList;
    }
    
 
    
}
