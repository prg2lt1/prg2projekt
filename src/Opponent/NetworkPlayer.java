/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Opponent;

import GameModel.Player;

/**
 *
 * @author Lorenz
 */
public class NetworkPlayer extends Opponent {

    private String ipNmb;
    private int port;

    public NetworkPlayer() {
        super("NetworkPlayer");
    }

    public NetworkPlayer(String newName) {
        super(newName);
    }

    public NetworkPlayer(String newName, String newIp, int newPort) {
        super(newName);
        this.ipNmb = newIp;
        this.port = newPort;
    }

    public void setIp(String newIp) {
        this.ipNmb = newIp;
    }

    public String getIp() {
        return this.ipNmb;
    }

    public void setport(int newPort) {
        this.port = newPort;
    }

    public int getPort() {
        return this.port;
    }

    public boolean playTurn() {
        //ComputerBrain.play whatever...
        return true;
    }

}
