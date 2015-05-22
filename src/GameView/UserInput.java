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
            System.out.println("choose!");
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
            System.out.println("choose!");
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
}
