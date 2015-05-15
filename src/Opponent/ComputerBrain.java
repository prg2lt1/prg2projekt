/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Opponent;
import GameModel.Board;
import GameModel.Box;
import GameModel.Line;

/**
 *
 * @author tobias
 */
public class ComputerBrain {
    
    Board board;
    
    /**
     * 
     * @param board wird von Opponent->Computer übergeben. 
     */
    public ComputerBrain (Board board) {
        this.board = board;
    }
    
    public void play() {
        
        for(Box b : board.getBoxes()) {
            if(b.getNumberOfLines() == 3) {
                SomeClass.addLastLine();    //NOCH ZU ERSTELLEN: Klasse die Linien "hinzufügen" kann.      
            }
            else if(b.getNumberOfLines() < 2){
                Line t = b.getBottomLine();
                int boxIndex = board.getBoxes().indexOf(b);
                Box bcheck = findNeighbourBox(t, boxIndex);
                    if (bcheck == null || bcheck.getNumberOfLines() < 2) {
                        
                    }
                
            }
        }
    }
    
    private Box findNeighbourBox(Line t, int boxIndex) {
        
        boolean found = false;
        Box neighbourBox = null;
        
        //Boxes mit kleinerem Index durchsuchen
        for(int i = 0; i<boxIndex; i++) {
            
            Box b = board.getBoxes().get(boxIndex);
            Line m = b.getBottomLine();
            Line n = b.getTopLine();
            Line o = b.getRightLine();
            Line p = b.getLeftLine();
        
            if(t.equals(m) || t.equals(n) || t.equals(o) || t.equals(p)) {
                found = true;
                neighbourBox = board.getBoxes().get(i);
                }
        }
        if (!found) {
            //Boxes mit grösserem Index durchsuchen
            for (int j = boxIndex+1; j<board.getBoxes().size(); j++ ) {
            
                Box d = board.getBoxes().get(boxIndex);
                Line w = d.getBottomLine();
                Line x = d.getTopLine();
                Line y = d.getRightLine();
                Line z = d.getLeftLine();
        
                if(t.equals(w) || t.equals(x) || t.equals(y) || t.equals(z)) {
                    found = true;
                    neighbourBox = board.getBoxes().get(i);

                }
            }
        }
        return neighbourBox;
    }
         
}
    
    
