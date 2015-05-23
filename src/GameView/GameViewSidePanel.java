package GameView;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Dots & Boxes GUI.
 */
public final class GameViewSidePanel extends JPanel {
    
    private String playerNameString; 
    private String opponentNameString;
    
    private final JLabel playerNameLabel;
    private JLabel playerName;
    private final JLabel opponentNameLabel;
    private JLabel opponentName;
    private final JLabel playerScoreLabel;
    private JLabel playerScore;
    private int playerScoreNumber;
    private final JLabel opponentScoreLabel;
    private JLabel opponentScore;
    private int opponentScoreNumber;

    public GameViewSidePanel() {
        this.playerNameString = "-";    // default name
        this.opponentNameString = "-";  // default name
        
        this.setLayout(new GridLayout(6,2));
        
        playerNameLabel = new JLabel();
        playerNameLabel.setText("Your Name:");
        
        playerName = new JLabel();
        playerName.setText(this.playerNameString);
        
        opponentNameLabel = new JLabel();
        opponentNameLabel.setText("Other's Name:");
        
        opponentName = new JLabel();
        opponentName.setText(this.opponentNameString);
        
        playerScoreLabel = new JLabel();
        playerScoreLabel.setText("Your score: ");
        
        playerScore = new JLabel();
        playerScore.setText(Integer.toString(this.playerScoreNumber));
        
        opponentScoreLabel = new JLabel();
        opponentScoreLabel.setText("Other's score: ");
        
        opponentScore = new JLabel();
        opponentScore.setText(Integer.toString(this.opponentScoreNumber));
        
        add(playerNameLabel);
        add(playerName);
        add(playerScoreLabel);
        add(playerScore);
        add(opponentNameLabel);
        add(opponentName);
        add(opponentScoreLabel);
        add(opponentScore);
        
    }
    
    public void setPlayerName(String name){
        this.playerNameString = name;
        playerName.setText(this.playerNameString);
    }
    
    public void incrementPlayerScore(){
        this.playerScoreNumber++;
        playerScore.setText(Integer.toString(this.playerScoreNumber));
    }
    
    public void setOpponentName(String name){
        this.opponentNameString = name;
        opponentName.setText(this.opponentNameString);
    }
    
    public void incrementOpponentScore(){
        this.opponentScoreNumber++;
        opponentScore.setText(Integer.toString(this.opponentScoreNumber));
    }
}
