/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Opponent;

import GameModel.Board;
import GameModel.Box;
import GameModel.Line;
import GameControl.MoveExecutor;
import java.util.Random;
import GameControl.Flow;

/**
 *
 * @author tobias
 */
public class ComputerBrain extends Opponent {
    private final Board board;
    private final MoveExecutor myExecutor;
    private final Random randomInt;
    private final int numberOfLines;

    /**
     *
     * @param board
     * @param moveExecutor
     */
    public ComputerBrain(Board board, MoveExecutor moveExecutor) {
        super("Computer");
        this.board = board;
        myExecutor = moveExecutor;
        randomInt = new Random();
        numberOfLines = board.getLines().size();
    }

    public int play() {

        int playedIndex = -1;
        //boolean foundMove = false;
        //foundMove = playFirstPrio();
        playedIndex = playFirstPrio();
        if (playedIndex == -1) {
            playedIndex = playSecondPrio();
        }
        if (playedIndex == -1) {
            playedIndex = playThirdPrio();
        }
        return playedIndex;
    }

    /**
     * Sucht Boxes mit drei Linien und komplettiert sie.
     *
     * @return
     */
    public int playFirstPrio() {

        //boolean playedMove = false;
        int lineIndex = -1;
        for (int i = 0; i < board.getBoxes().size() && lineIndex == -1; i++) {
            Box b = board.getBoxes().get(i);
            if (b.getNumberOfLines() == 3) {
                lineIndex = choosePossibleLine(b);
               // playedMove = playPossibleLine(b);
            }
        }
        System.out.println("First prio resulted in" + lineIndex);
        return lineIndex;
    }

    /**
     * Sucht Boxes mit weniger als zwei gespielten Linien und setzt eine Linie
     * (insofern diese nicht die dritte Linie der benachbarten Box wäre).
     *
     * @return
     */
    public int playSecondPrio() {

        int lineIndex = -1;
        //boolean playedMove = false;
        for (int i = 0; i < board.getBoxes().size() && lineIndex == -1; i++) {

            Box c = board.getBoxes().get(i);

            if (c.getNumberOfLines() < 2 && c.getBottomLine().getOwner() == null && !criticalNeighbour(c.getBottomLine(), i)) {
                lineIndex = chooseSpecificLine(c.getBottomLine());
            } else if (c.getNumberOfLines() < 2 && c.getTopLine().getOwner() == null && !criticalNeighbour(c.getTopLine(), i)) {
                lineIndex = chooseSpecificLine(c.getTopLine());
            } else if (c.getNumberOfLines() < 2 && c.getLeftLine().getOwner() == null && !criticalNeighbour(c.getLeftLine(), i)) {
                lineIndex = chooseSpecificLine(c.getLeftLine());
            } else if (c.getNumberOfLines() < 2 && c.getRightLine().getOwner() == null && !criticalNeighbour(c.getRightLine(), i)) {
                lineIndex = chooseSpecificLine(c.getRightLine());
            }
        }
        System.out.println("First prio resulted in" + lineIndex);
        return lineIndex;
    }

    public int playThirdPrio() {
        //boolean foundMove = false;
        int lineIndex = -1;
        while (lineIndex == -1) {

            Line l = getRandomLine();
            if (l.getOwner() == null) {
                lineIndex = chooseSpecificLine(l);
            }
        }
        System.out.println("First prio resulted in" + lineIndex);
        return lineIndex;
    }

    /**
     *
     * @return a random Line, taken through index in ArrayList<Line>.
     */
    private Line getRandomLine() {

        int r = randomInt.nextInt(numberOfLines);
        return board.getLines().get(r);
    }

    private Box findNeighbourBox(Line t, int boxIndex) {

        boolean found = false;
        Box neighbourBox = null;

        //Boxes mit kleinerem Index durchsuchen
        for (int i = 0; i < boxIndex; i++) {

            Box b = board.getBoxes().get(boxIndex);
            Line m = b.getBottomLine();
            Line n = b.getTopLine();
            Line o = b.getRightLine();
            Line p = b.getLeftLine();

            if (t.equals(m) || t.equals(n) || t.equals(o) || t.equals(p)) {
                found = true;
                neighbourBox = board.getBoxes().get(i);
            }
        }
        if (!found) {
            //Boxes mit grösserem Index durchsuchen
            for (int j = boxIndex + 1; j < board.getBoxes().size(); j++) {

                Box d = board.getBoxes().get(boxIndex);
                Line w = d.getBottomLine();
                Line x = d.getTopLine();
                Line y = d.getRightLine();
                Line z = d.getLeftLine();

                if (t.equals(w) || t.equals(x) || t.equals(y) || t.equals(z)) {
                    found = true;
                    neighbourBox = board.getBoxes().get(j);
                }
            }
        }
        return neighbourBox;
    }

    private boolean criticalNeighbour(Line t, int boxIndex) {

        boolean critical = false;
        Box c = findNeighbourBox(t, boxIndex);
        if (c == null) {

        } else if (c.getNumberOfLines() > 1) {
            critical = true;
        }
        return critical;
    }

    private int choosePossibleLine(Box b) {

        int lineIndex = -1;
        //boolean playedLine = false;

        if (b.getBottomLine().getOwner() == null) {
            lineIndex = board.getLines().indexOf(b.getBottomLine());
            //myExecutor.playLine(lineIndex, this);
            
            //playedLine = true;
        } else if (b.getTopLine().getOwner() == null) {
            lineIndex = board.getLines().indexOf(b.getTopLine());
            //myExecutor.playLine(lineIndex, this);
            //playedLine = true;
        } else if (b.getLeftLine().getOwner() == null) {
            lineIndex = board.getLines().indexOf(b.getLeftLine());
            //myExecutor.playLine(lineIndex, this);
            //playedLine = true;
        } else if (b.getRightLine().getOwner() == null) {
            lineIndex = board.getLines().indexOf(b.getRightLine());
            //myExecutor.playLine(lineIndex, this);
            //playedLine = true;
        }
        return lineIndex;
    }

    private int chooseSpecificLine(Line t) {
        int lineIndex = board.getLines().indexOf(t);
        //myExecutor.playLine(lineIndex, this);
        return lineIndex;
    }
}
