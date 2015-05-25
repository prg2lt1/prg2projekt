/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameControl;

import javax.swing.JOptionPane;
/**
 *
 * @author tobias
 */
public class GameOver {
 
    MainControl mainControl;
    
    public GameOver (MainControl myMainControl) {
        mainControl = myMainControl;
    }
    
     public void gameOver() {
        //Custom button text
        Object[] options = {"New Game",
            "Load Game",
            "Quit"};
        int n = JOptionPane.showOptionDialog(null,
                "Game over\n"
                + "what would you like to do?",
                "Game Over",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[2]);

        if (n == 0) {
            System.out.println("[info (UserInput)] new Game");
            mainControl.newGame();
        } else if (n == 1) {
            System.out.println("[info (UserInput)] load Game");
            mainControl.loadGame();
        } else if (n == 2) {
            System.exit(0);
        }
    }
}
