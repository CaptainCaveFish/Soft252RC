/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soft252git;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author dillonlaskey
 */
public class Adminhome extends Page{
    JButton accountButton, ratingsButton;
    JLabel accountLabel, ratingsLabel;
    Pagemanager parent;
    Adminhome(Data database, User accessor,Pagemanager origin){
        super("Home", database,null,accessor);
        parent = origin;
        accountLabel = new JLabel("Veiw accounts:");
        accountLabel.setBounds(130, 150, 100, 20);
        ratingsLabel = new JLabel("Veiw ratings:");
        ratingsLabel.setBounds(130, 250, 100, 20);
        accountButton = new JButton("Accounts");
        accountButton.setBounds(270, 150, 100, 20);
        accountButton.addActionListener(this);
        ratingsButton = new JButton("Ratings");
        ratingsButton.setBounds(270, 250, 100, 20);
        ratingsButton.addActionListener(this);
        
        frame.add(accountLabel);
        frame.add(accountButton);
        frame.add(ratingsLabel);
        frame.add(ratingsButton);
        
        frame.setVisible(false);
        frame.setVisible(true);
    }
    
    @Override
    protected void action(ActionEvent ae){
        if (ae.getSource() == accountButton){
            child = new AccountVeiwer(info,this,user);
        }
        else if(ae.getSource() == ratingsButton){
            child = new RatingsVeiwer(info,this,user);
        }
    }
}
