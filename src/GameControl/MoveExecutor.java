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
import java.io.Serializable;


/**
 *
 * @author tobias
 */
public class MoveExecutor implements Serializable {

    private Board board;
    private NetworkPlayer opponent;
    private int opponentScore;
    private int userScore;
    

    public MoveExecutor(Board newBoard) {

        this.board = newBoard;
        opponentScore = 0;
        userScore = 0;
        countScore();
        System.out.print("new ME created " + getUserScore() + getOpponentScore() );

    }

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

            else if ((firstBox != null && firstBox.isBoxComplete()) || (secondBox != null && secondBox.isBoxComplete())) {
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
        else {
            answer = Flow.FlowStates.userTurn;
        }
        return answer;
    }
    
    public void countScore() {
        
        int countedOpponentScore = 0;
        int countedUserScore = 0;
        
        for(Box b : board.getBoxes() ) {
            if(b.getOwner() instanceof Opponent ) {
                countedOpponentScore++;
                }
            else {
                countedUserScore++;
            }
        }
        opponentScore = countedOpponentScore;
        userScore = countedUserScore;
    }
    
    public int getUserScore() {
        return userScore;
    }
    
    public int getOpponentScore() {
        return opponentScore;
    }
    
    
    
   
}
