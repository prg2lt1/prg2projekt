/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameModel;

import GameControl.FileIO;

/**
 *
 * @author tobias
 */
public class BoardTest implements FileIO {
    
    public static void main(final String[] args) {
        
        
        Board t = new Board(4);
        //t = FileIO.loadBoard();
        System.out.println("Dots (y/x):");
       for(int i = 0; i < t.getDots().size(); i++) {
           System.out.print(t.getDots().get(i).getY());
           System.out.println(t.getDots().get(i).getX());
       }
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("Lines (start/end):");
        

       for(int j = 0; j<t.getLines().size(); j++) {
           System.out.print(t.getLines().get(j).getStartingDot().getY());
           System.out.print(t.getLines().get(j).getStartingDot().getX()+" ");
           System.out.print(t.getLines().get(j).getEndingDot().getY());
           System.out.println(t.getLines().get(j).getEndingDot().getX());
           
           System.out.println();
           System.out.println();
           
           int b = t.getLines().get(j).getFirstTouchingBox().getBoxNumber();
           System.out.println("Erste betroffene Box");
           System.out.print(t.getBoxes().get(b).getTopLine().getStartingDot().getY());
           System.out.print(t.getBoxes().get(b).getTopLine().getStartingDot().getX()+" ");
           System.out.print(t.getBoxes().get(b).getTopLine().getEndingDot().getY());
           System.out.print(t.getBoxes().get(b).getTopLine().getEndingDot().getX()+"   ");
           
           System.out.print(t.getBoxes().get(b).getRightLine().getStartingDot().getY());
           System.out.print(t.getBoxes().get(b).getRightLine().getStartingDot().getX()+" ");
           System.out.print(t.getBoxes().get(b).getRightLine().getEndingDot().getY());
           System.out.print(t.getBoxes().get(b).getRightLine().getEndingDot().getX()+"   ");
           
           System.out.print(t.getBoxes().get(b).getBottomLine().getStartingDot().getY());
           System.out.print(t.getBoxes().get(b).getBottomLine().getStartingDot().getX()+" ");
           System.out.print(t.getBoxes().get(b).getBottomLine().getEndingDot().getY());
           System.out.print(t.getBoxes().get(b).getBottomLine().getEndingDot().getX()+"   ");
           
           System.out.print(t.getBoxes().get(b).getLeftLine().getStartingDot().getY());
           System.out.print(t.getBoxes().get(b).getLeftLine().getStartingDot().getX()+" ");
           System.out.print(t.getBoxes().get(b).getLeftLine().getEndingDot().getY());
           System.out.println(t.getBoxes().get(b).getLeftLine().getEndingDot().getX()+"   ");
           
           System.out.println();
           System.out.println();
           
           if (t.getLines().get(j).getSecondTouchingBox() != null) {
           b = t.getLines().get(j).getSecondTouchingBox().getBoxNumber();
           
           System.out.println("Zweite betroffene Box");
           
           System.out.print(t.getBoxes().get(b).getTopLine().getStartingDot().getY());
           System.out.print(t.getBoxes().get(b).getTopLine().getStartingDot().getX()+" ");
           System.out.print(t.getBoxes().get(b).getTopLine().getEndingDot().getY());
           System.out.print(t.getBoxes().get(b).getTopLine().getEndingDot().getX()+"   ");
           
           System.out.print(t.getBoxes().get(b).getRightLine().getStartingDot().getY());
           System.out.print(t.getBoxes().get(b).getRightLine().getStartingDot().getX()+" ");
           System.out.print(t.getBoxes().get(b).getRightLine().getEndingDot().getY());
           System.out.print(t.getBoxes().get(b).getRightLine().getEndingDot().getX()+"   ");
           
           System.out.print(t.getBoxes().get(b).getBottomLine().getStartingDot().getY());
           System.out.print(t.getBoxes().get(b).getBottomLine().getStartingDot().getX()+" ");
           System.out.print(t.getBoxes().get(b).getBottomLine().getEndingDot().getY());
           System.out.print(t.getBoxes().get(b).getBottomLine().getEndingDot().getX()+"   ");
           
           System.out.print(t.getBoxes().get(b).getLeftLine().getStartingDot().getY());
           System.out.print(t.getBoxes().get(b).getLeftLine().getStartingDot().getX()+" ");
           System.out.print(t.getBoxes().get(b).getLeftLine().getEndingDot().getY());
           System.out.println(t.getBoxes().get(b).getLeftLine().getEndingDot().getX()+"   ");
           
           System.out.println();
           System.out.println();
           
           
            }
       }
        System.out.println();
        System.out.println("Boxes (TopLine, LeftLine, BottomLine, RightLine):");

      
       for(int b = 0; b < t.getBoxes().size(); b++) {
           System.out.print(t.getBoxes().get(b).getTopLine().getStartingDot().getY());
           System.out.print(t.getBoxes().get(b).getTopLine().getStartingDot().getX()+" ");
           System.out.print(t.getBoxes().get(b).getTopLine().getEndingDot().getY());
           System.out.print(t.getBoxes().get(b).getTopLine().getEndingDot().getX()+"   ");
           
           System.out.print(t.getBoxes().get(b).getRightLine().getStartingDot().getY());
           System.out.print(t.getBoxes().get(b).getRightLine().getStartingDot().getX()+" ");
           System.out.print(t.getBoxes().get(b).getRightLine().getEndingDot().getY());
           System.out.print(t.getBoxes().get(b).getRightLine().getEndingDot().getX()+"   ");
           
           System.out.print(t.getBoxes().get(b).getBottomLine().getStartingDot().getY());
           System.out.print(t.getBoxes().get(b).getBottomLine().getStartingDot().getX()+" ");
           System.out.print(t.getBoxes().get(b).getBottomLine().getEndingDot().getY());
           System.out.print(t.getBoxes().get(b).getBottomLine().getEndingDot().getX()+"   ");
           
           System.out.print(t.getBoxes().get(b).getLeftLine().getStartingDot().getY());
           System.out.print(t.getBoxes().get(b).getLeftLine().getStartingDot().getX()+" ");
           System.out.print(t.getBoxes().get(b).getLeftLine().getEndingDot().getY());
           System.out.println(t.getBoxes().get(b).getLeftLine().getEndingDot().getX()+"   ");
           
           
       }
       
       FileIO.saveBoard(t);
    }
    
}
