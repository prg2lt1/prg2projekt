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
    
    private static ArrayList<Box> boxList;
    private static ArrayList<Line> horizontalLineList;
    private static ArrayList<Line> verticalLineList;
    private static ArrayList<Dot> dotList;
    
    /**
     * 
     * @param size Seitenlänge in Anzahl Dots eines n x n Spielfelds. 
     */
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
        Line top;
        Line bottom;
        Line left;
        Line right;
        
        for (int index=0; horizontalLineList.size()-size >= index ; index++) {
            
        
         int verticalIndex = 0;
         top = horizontalLineList.get(index);
         bottom = horizontalLineList.get(index+3);
         
         if(verticalIndex%size != size-1) {
             verticalIndex++;
         }
         left = verticalLineList.get(verticalIndex);
         right = verticalLineList.get(verticalIndex+1);
         boxList.add(new Box(index, top, bottom, left, right ));
         verticalIndex++;
         
        }
        return boxList;
    }
    
  /**
     
    public static void main(final String[] args) {
        
        
        Board t = new Board(4);
       for(int i = 0; i<dotList.size(); i++) {
           System.out.println(dotList.get(i).getX());
           System.out.println(dotList.get(i).getY());
           System.out.println();
       }
           
       for(int j = 0; j<horizontalLineList.size(); j++) {
           System.out.println(horizontalLineList.get(j).getStartingDot().getX());
           System.out.println(horizontalLineList.get(j).getStartingDot().getY());
           System.out.println(horizontalLineList.get(j).getEndingDot().getX());
           System.out.println(horizontalLineList.get(j).getEndingDot().getY());
           System.out.println();
       }
           
        for(int k = 0; k<verticalLineList.size(); k++) {
           System.out.println(verticalLineList.get(k).getStartingDot().getX());
           System.out.println(verticalLineList.get(k).getStartingDot().getY());
           System.out.println(verticalLineList.get(k).getEndingDot().getX());
           System.out.println(verticalLineList.get(k).getEndingDot().getY());
           System.out.println();   
           System.out.println();
           System.out.println();
           System.out.println();
        }
           System.out.println(boxList.get(4).getRightLine());
    }
    */
    
}
