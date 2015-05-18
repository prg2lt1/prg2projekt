/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameControl;

import GameModel.Line;
import GameModel.Player;
import GameModel.Board;

/**
 *
 * @author tobias
 */
public class MoveChecker {

    Player activePlayer;
    Line clickedLine;
    Board board;
    boolean validMove;

    public MoveChecker(Board newBoard) {

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
}
