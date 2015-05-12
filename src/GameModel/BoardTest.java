/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameModel;

/**
 *
 * @author tobias
 */
public class BoardTest {
    
    public static void main(final String[] args) {
        
        
        Board t = new Board(4);
       for(int i = 0; i < t.getDots().size(); i++) {
           System.out.println(t.getDots().get(i).getY());
           System.out.println(t.getDots().get(i).getX());
           System.out.println();
       }
           
       for(int j = 0; j<t.getLines().size(); j++) {
           System.out.println(t.getLines().get(j).getStartingDot().getY());
           System.out.println(t.getLines().get(j).getStartingDot().getX());
           System.out.println(t.getLines().get(j).getEndingDot().getY());
           System.out.println(t.getLines().get(j).getEndingDot().getX());
           System.out.println();
       }
           
      
           System.out.println(t.getBoxes().get(4).getRightLine());
    }
    
}
