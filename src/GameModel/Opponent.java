/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameModel;

/**
 *
 * @author Lorenz
 */
public class Opponent extends Player {

    private String ipNmb;

    public Opponent() {
        super();
    }
    
    public Opponent(String newName) {
        super(newName);
    }
    
    public Opponent(String newName, String newIp) {
        super(newName);
        this.ipNmb = newIp;
    }

    public void setIp(String newIp) {
        this.ipNmb = newIp;
    }

    public String getIp() {
        return this.ipNmb;
    }
}
