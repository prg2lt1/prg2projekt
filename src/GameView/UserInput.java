package GameView;

import GameControl.MainControl;
import javax.swing.JOptionPane;
import GameControl.MoveExecutor;

/**
 *
 * @author Lorenz
 */
public class UserInput extends JOptionPane {
    private final MainControl mainControl;
    private final MoveExecutor moveExecutor;

    public UserInput(MainControl newMainControl, MoveExecutor moveExecutor) {

        this.mainControl = newMainControl;
        this.moveExecutor = moveExecutor;
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
            s = "n0oBb4sH3r";
        }
        mainControl.setUserName(s);
    }

    /**
     * Spielbrettgrösse ändern !noch nicht benutzt!
     */
    public void setBoardSize() {
        int value;

        Object[] possibilities = {"4", "5", "6"};
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

    public void GameOver(int userScore, int opponentScore) {
        String winnerText = (userScore > opponentScore) ? "Your won" : "You lose";
        winnerText = winnerText + "\n";
        
        //Custom button text        
        Object[] options = {"New Game",
            "Load Game",
            "Quit"};
        int n = JOptionPane.showOptionDialog(this,
                winnerText
                + "You: " + userScore + " " + "Opponent: " + opponentScore + "\n" 
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

    public void Message(String text, String title) {
        //custom message and title, warning icon
        JOptionPane.showMessageDialog(this,
                text,
                title,
                JOptionPane.WARNING_MESSAGE);
    }
}
