package GameView;

import GameControl.MainControl;
import javax.swing.JOptionPane;

/**
 *
 * @author Lorenz
 */
public class UserInput extends JOptionPane {

    private MainControl mainControl;

    public UserInput(MainControl newMainControl) {

        this.mainControl = newMainControl;
    }

    /**
     * Auswählen, ob Spiel gegen Computer oder gegen Netzwerk
     */
    public void setGameMode() {

        Object[] possibilities = {"Computer", "Network"};
        String s = (String) JOptionPane.showInputDialog(
                this,
                "Please select Opponent\n",
                "Opponent",
                JOptionPane.PLAIN_MESSAGE,
                null,
                possibilities,
                "Computer");

        //If a string was returned, say so.
        if ((s != null) && (s.length() > 0)) {
            System.out.println(s);

        } else {
            //If you're here, the return value was null/empty.
            //System.out.println("[info (UserInput)] user didnt't choose modi..");
            s = "Computer";
        }

        mainControl.setOpponent(s);
    }

    /**
     * Name ändern des lokalen Spielers
     */
    public void setPlayerName() {

        String s = (String) JOptionPane.showInputDialog(
                this,
                "Please enter your name\n",
                "name",
                JOptionPane.PLAIN_MESSAGE);

        //If a string was returned, say so.
        if ((s != null) && (s.length() > 0)) {
            System.out.println(s);

        } else {
            //If you're here, the return value was null/empty.
            //System.out.println("[info (UserInput)] user didn't choose name..");
            s = "n0oBb4sH3r1337";
        }

        mainControl.setUserName(s);
    }

    /**
     * Spielbrettgrösse ändern !noch nicht benutzt!
     */
    public void setBoardSize() {
        int value;

        Object[] possibilities = {"3", "4", "5", "6"};
        String str = (String) JOptionPane.showInputDialog(
                this,
                "Which Boardsize would you like?\n",
                "Boardsize",
                JOptionPane.PLAIN_MESSAGE,
                null,
                possibilities,
                "4");

        //If a string was returned, say so.
        if ((str != null) && (str.length() > 0)) {
            System.out.println(str);
            value = Integer.valueOf(str);

        } else {
            //If you're here, the return value was null/empty.
            System.out.println("choose!");
            value = 4;
        }
        mainControl.setBoardSize(value);
    }

    public void GameOver() {
        //Custom button text
        Object[] options = {"New Game",
            "Load Game",
            "Quit"};
        int n = JOptionPane.showOptionDialog(this,
                "Game over\n "
                + "what would you like to do?",
                "Game Over",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[2]);

        if (n == 0) {
            System.out.println("new Game");
        } else if (n == 1) {
            System.out.println("load Game");
        } else if (n == 2) {
            //Nichts machen.. flow läuft aus -> ende.
        }
    }

    public void Message(String text, String title) {
        //custom message and title, warning icon
        JOptionPane.showMessageDialog(this,
                text,
                title,
                JOptionPane.WARNING_MESSAGE);
    }
}
