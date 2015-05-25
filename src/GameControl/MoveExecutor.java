/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameControl;

import GameModel.Line;
import GameModel.Player;
import GameModel.Board;
import GameModel.Box;
import Opponent.NetworkPlayer;
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

   // public void inputLine(Line inputLine) {
    //Linie kontrollieren:
    // if (emptyLine(inputLine)) {
    //inputLine.setOwner(activePlayer);
    //Linie sichtbar machen
    //Boxen kontrollieren (eine vollständig geworden?)
    //Problem: wie kann man Zug umschalten.. keinen Zugriff auf Flow...
    //}
    public boolean emptyLine(Line clickedLine) {
        return board.getLines().contains(clickedLine);
    }

    public Flow.FlowStates playLine(int lineIndex, Player p) {

        //System.out.println("Lineindex in PlayLine in MoveExecuter: " + lineIndex);
        //System.out.println("Player in PlayLine in MoveExecuter: " + p.toString());
        Flow.FlowStates answer = Flow.FlowStates.error;
        Line l = board.getLines().get(lineIndex);
        Box firstBox = l.getFirstTouchingBox();
        Box secondBox = l.getSecondTouchingBox();

        if (l.getOwner() == null) {
            
            l.setOwner(p);
            
            System.out.println("Line owner set");
            
            if (firstBox != null) {
                firstBox.updateOwner(p);
                }
            
            if (secondBox != null) {
                secondBox.updateOwner(p);
                }

            if(board.allBoxesComplete()) {
               answer = Flow.FlowStates.gameOver;
            }

            if ((firstBox != null && firstBox.isBoxComplete()) || (secondBox != null && secondBox.isBoxComplete())) {
                if (p instanceof Opponent) {
                    System.out.println("[info (MoveExecutor)] opponentTurn once again");
                    answer = Flow.FlowStates.opponentTurn;
                } else {
                    System.out.println("[info (MoveExecutor)] userTurn once again");
                    answer = Flow.FlowStates.userTurn;

                }
            } else {
                if (p instanceof Opponent) {
                    answer = Flow.FlowStates.userTurn;
                    System.out.println("[info (MoveExecutor)] userTurn");
                } else {
                    answer = Flow.FlowStates.opponentTurn;
                    System.out.println("[info (MoveExecutor)] opponentTurn");
                }
            }
        }
        return answer;
    }
}
