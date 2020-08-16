package soft252git;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dillonlaskey
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public abstract class Page implements ActionListener{
    //This class contains methods that all the different pages will use
    JFrame frame;
    JButton exit;
    Page child,parent;
    Data info;
    User user;
    Page(String title, Data database, Page origin,User accessor){
        // Allows information about the current user to be passed between pages
        user = accessor;
        // Allows the application data to be passed between page
        info = database;
        // Stores the parent page of this page
        parent = origin;
        frame = new JFrame(title);
        frame.setSize(500, 500);
        frame.setLayout(null);
        exit = new JButton("X");
        exit.addActionListener(this);
        exit.setBounds(0, 0, 50, 50);
        frame.add(exit);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    
    protected void closeChild(){
        child = null;
    }
    
    protected void setChild(Page target){
        child = target;
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == exit){
            info.close();
            System.exit(0);
        }
        else{
            this.action(ae);
        }
    }
    
    protected void action(ActionEvent ae){
        
    }
    
}
 