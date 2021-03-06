
package GameControl;

import GameModel.Line;
import GameModel.Player;
import GameModel.Board;
import GameModel.Box;
import Opponent.Opponent;
import java.io.Serializable;

/**
 *Erhält Spielzüge von Spielern und führt sie im GameModel aus.
 * 
 * @author tobias
 */
public class MoveExecutor implements Serializable {

    private Board board;
    private Opponent opponent;
    private Player user;

    public MoveExecutor(Board newBoard) {
        this.board = newBoard;
        this.user = null;
        this.opponent = null;
        //System.out.print("[info (Moveexecutor)] new ME created ");

    }

    public void setPlayer(Player user) {
        this.user = user;
    }

    public void setOpponent(Opponent opponent) {
        this.opponent = opponent;
    }

    public boolean emptyLine(Line clickedLine) {
        return board.getLines().contains(clickedLine);
    }

    
    /**
     * 
     * Spielt linie, überprüft welcher Spieler anschliessend an der Reihe ist.
     * Rückmeldung an Flow.
     * 
     * @param lineIndex index in ArrayList<Line>
     * @param p playing player
     * @return 
     */
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

            if (board.allBoxesComplete()) {

                answer = Flow.FlowStates.gameOver;
            } else if ((firstBox != null && firstBox.isBoxComplete()) || (secondBox != null && secondBox.isBoxComplete())) {
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
        } else {
            answer = Flow.FlowStates.userTurn;
        }
        return answer;
    }
}
