/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soft252git;

/**
 *
 * @author dillonlaskey
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class TerminationWindow extends Page{
    JButton accept,cancel;
    JLabel message;
    TerminationWindow(Data database, User accessor, Page origin){
        super("Terminate account",database,origin,accessor);
        accept = new JButton("Yes");
        accept.addActionListener(this);
        accept.setBounds(150, 300, 50, 20);
        frame.add(accept);
        cancel = new JButton("No");
        cancel.addActionListener(this);
        cancel.setBounds(300,300,50,20);
        frame.add(cancel);
        message = new JLabel();
        message.setText("Are you sure you wish to terminate your account?");
        message.setBounds(100, 150, 300, 20);
        frame.add(message);
    }
    
    @Override
    protected void action(ActionEvent ae){
        if (ae.getSource() == accept){
            int newId = info.getRequests()[info.getRequests().length - 1].getRequestID() + 1;
            info.addRequest(new Request(Integer.toString(user.getID()),"t","Requesting account termination",Integer.toString(newId)));
            parent.closeChild();
            frame.setVisible(false);
        }
        else if(ae.getSource() == accept){
            parent.closeChild();
            frame.setVisible(false);
        }
    }
}
