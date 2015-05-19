/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameControl;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author tobias
 */
public class ChooseOpponentGUI extends JFrame{

    private String[] choose = new String[2];
    private JComboBox adversary;
    private DefaultComboBoxModel list = new DefaultComboBoxModel();
    private JPanel myPanel = new JPanel();
    private JButton okButton = new JButton("OK");

    public ChooseOpponentGUI() {

        super("Choose Opponent");

        //ComboBox
        list.addElement("Computer");
        list.addElement("NetworkPlayer");

        choose[0] = "Computer";
        choose[1] = "Network";

        adversary = new JComboBox(list);

        //Frame:
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        add(adversary);
        add(okButton);
        okButtonAction();

        this.setResizable(false);
        this.setLocation(600, 300);
        setSize(300, 100);
        setVisible(true);

        //adversary.setSelectedIndex(0);
        adversary.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                JComboBox cb = (JComboBox) e.getSource();
                String input = (String) cb.getSelectedItem();
                System.out.println(input);
                //updateLabel(input);
            }
        });    
    }
    public void okButtonAction() {
        okButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                if (e.getSource() == okButton) {
                    System.out.println("OK");
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame test = new ChooseOpponentGUI();
    }
}