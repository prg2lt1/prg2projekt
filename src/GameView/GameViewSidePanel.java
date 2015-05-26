package GameView;

import GameModel.Player;
import Opponent.Opponent;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Dots & Boxes GUI.
 */
public final class GameViewSidePanel extends JPanel {
    
    private Player user;
    private Opponent opponent;
    
    private final JLabel playerNameLabel;
    private JLabel playerName;
    private final JLabel opponentNameLabel;
    private JLabel opponentName;
    private final JLabel playerScoreLabel;
    private JLabel playerScore;
    private final JLabel opponentScoreLabel;
    private JLabel opponentScore;

    public GameViewSidePanel() {
        
        this.setLayout(new GridLayout(6,2));
        
        playerNameLabel = new JLabel();
        playerNameLabel.setText("Your Name:");
        
        playerName = new JLabel();
        playerName.setText("-"); //default name
        
        opponentNameLabel = new JLabel();
        opponentNameLabel.setText("Other's Name:");
        
        opponentName = new JLabel();
        opponentName.setText("-"); //default name
        
        playerScoreLabel = new JLabel();
        playerScoreLabel.setText("Your score: ");
        
        playerScore = new JLabel();
        playerScore.setText(Integer.toString(0)); //default = 0
        
        opponentScoreLabel = new JLabel();
        opponentScoreLabel.setText("Other's score: ");
        
        opponentScore = new JLabel();
        opponentScore.setText(Integer.toString(0)); //default = 0
        
        add(playerNameLabel);
        add(playerName);
        add(playerScoreLabel);
        add(playerScore);
        add(opponentNameLabel);
        add(opponentName);
        add(opponentScoreLabel);
        add(opponentScore);
        
    }
    
    public void setPlayer(Player user){
        this.user = user;
        playerName.setText(user.getName());
    }
    
    public void getPlayerScore(){
        playerScore.setText(Integer.toString(user.getNmbOfBoxes()));
    }
    
    public void setOpponent(Opponent opponent){
        this.opponent = opponent;
        opponentName.setText(opponent.getName());
    }
    
    public void getOpponentScore(){
        opponentScore.setText(Integer.toString(opponent.getNmbOfBoxes()));
    }
}
