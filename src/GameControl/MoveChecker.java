/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameControl;
import GameModel.Line;
import GameModel.Player;


/**
 *
 * @author tobias
 */
public class MoveChecker {
    
    Player playingPlayer;
    Line clickedLine;
    boolean validMove;
    
    
    public MoveChecker(Player playedBy, Line clickedLine,) {
        
       playingPlayer = playedBy;
       this.clickedLine = clickedLine;
        
        
    }
    
    public boolean emptyLine(Line clickedLine) {
        
        
    }
    
}
