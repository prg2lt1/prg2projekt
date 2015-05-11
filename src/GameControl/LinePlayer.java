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
public class LinePlayer {

    private Line l;
    private int tempStart;
    private int tempEnd;

    public LinePlayer(int startingPoint, int endingPoint, Player p) {
        /*
         l = new Line(startingPoint, endingPoint, p);
         */
    }

    public boolean lineAllreadyExists() {
        return false;
    }
}
