/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameControl;

import GameModel.Line;
import GameModel.Player;
import GameModel.Board;
import Opponent.NetworkPlayer;
import Opponent.ComputerBrain;
import Opponent.Opponent;


/**
 *
 * @author tobias
 */
public class MoveExecutor {

    Player activePlayer;
    Board board;
    boolean validMove;
    NetworkPlayer opponent;

    public MoveExecutor(Board newBoard) {

        this.board = newBoard;
       
        
    }

    public void inputLine(Line inputLine) {

        //Linie kontrollieren:
        if (emptyLine(inputLine)) {
            //inputLine.setOwner(activePlayer);
            //Linie sichtbar machen
            
            //Boxen kontrollieren (eine vollständig geworden?)
            //Problem: wie kann man Zug umschalten.. keinen Zugriff auf Flow...
        }
}

    public boolean emptyLine(Line clickedLine) {
        return board.getLines().contains(clickedLine);
        
    }
    
    public void setActivePlayer(Player newPlayer){
        this.activePlayer = newPlayer;
    }
    
    public String playLine (int lineIndex, Player p) {
        
        String answer1 = 
        Line l = board.getLines().get(lineIndex);
        
        if (l.getOwner() == null) {
        l.setOwner(p);
            if(l.getFirstTouchingBox().isBoxComplete() || l.getSecondTouchingBox().isBoxComplete()) {
                
            }
        
        }
        
        
         if(p instanceof Opponent) {
        answer = "userTurn";
        }
        else {
        answer = "opponentTurn";
        }
        
        return playedLine;
        
    }
    
}
