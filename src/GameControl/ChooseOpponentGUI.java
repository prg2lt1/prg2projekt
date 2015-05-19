/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameControl;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import Opponent.ComputerBrain;
import Opponent.Network;
import Opponent.Opponent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.LayoutManager;
import java.awt.BorderLayout;
/**
 *
 * @author tobias
 */
public class ChooseOpponentGUI extends JFrame {
    
    private String[] choose = new String[2];
    private JComboBox adversary;
    private DefaultComboBoxModel list = new DefaultComboBoxModel();
    private JPanel myPanel = new JPanel();
    private JButton okButton = new JButton("OK");
    
    
    public ChooseOpponentGUI() {
    
        
    super("Choose Opponent"); 
    list.addElement("Computer");
    list.addElement("NetworkPlayer");
        
    choose[0] = "Computer";
    choose[1] = "Network";
   
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    
    adversary = new JComboBox(list);
    setLayout(new BorderLayout());
    add(adversary, BorderLayout.NORTH);
    add(okButton, BorderLayout.SOUTH);
    
    setSize(300,100);
    setVisible(true);
    
    
    
    
    //adversary.setSelectedIndex(0);
    /**adversary.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            JComboBox temp = e.getSource();
            String newChoose = temp.getSelectedItem();
       3     updateLabel(newChoose);
       * 
       * /
       * */
    
        }
        
    
    //private String getSelectedOpponent(); {
    

    
    public static void main(String[] args) {
        JFrame test = new ChooseOpponentGUI();
    }
    
    
    
    
}
