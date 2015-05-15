/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Opponent;
import GameModel.Board;
import GameModel.Box;

/**
 *
 * @author tobias
 */
public class ComputerBrain {
    
    Board board;
    
    public ComputerBrain (Board board) {
        this.board = board;
    }
    
    public void play() {
        
        for(Box b : board.getBoxes()) {
        if(b.getNumberOfLines() == 3) {
            SomeClass.addLastLine()       
        }
        else if(b.getNumberOfLines() == 0)e
    }
}
