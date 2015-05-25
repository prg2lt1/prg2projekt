/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameView;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JButton;
import GameControl.MainControl;
import javax.swing.JLabel;
import java.awt.GridLayout;


/**
 *
 * @author tobias
 */
public class EndOfGame extends JFrame{
   
    MainControl myMainControl;
   
    
    public EndOfGame(MainControl newMain) {
        super("Game Over");
        myMainControl = newMain;
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        
        JButton buttonLeft = new JButton("New Game");
        buttonLeft.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) { myMainControl.newGame();
                                                            }
        });

        JButton buttonRight = new JButton("Quit");
        buttonRight.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) { System.exit(0); }
        });
        
        this.getContentPane().setLayout(new GridLayout(1, 2));
        
        add(buttonLeft);
        add(buttonRight);
        
        setSize(300, 200);
        setVisible(false);

        
        
        

    }
    
    public void setVisible() {
        setVisible(true);
    }
    
    
   // public static void main(String[] args) {
     //   JFrame test = new EndOfGame();
    //}
}
