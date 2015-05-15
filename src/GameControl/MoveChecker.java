/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameControl;
import GameModel.Line;
import GameModel.Player;
import GameModel.Board;
import GameModel.Flow;


/**
 *
 * @author tobias
 */
public class MoveChecker {
    
    Player playingPlayer;
    Line clickedLine;
    Board actualBoard;
    boolean validMove;
    
    
    public MoveChecker(Board playingBoard, Line clickedLine,) {
        
       this.actualBoard = actualBoard;
       playingPlayer = 
       this.clickedLine = clickedLine;
        
        
    }
    
    public boolean emptyLine(Line clickedLine) {
        return playingBoard.getLines().contains(clickedLine);
        
    }
    
}
