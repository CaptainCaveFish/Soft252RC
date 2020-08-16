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
public class NewUser extends Page{
    JTextField fnBox,lnBox,adBox,agBox,gBox,pBox;
    JLabel fnLabel,lnLabel,adLabel,agLabel,gLabel,pLabel;
    JButton Publish, Cancel;
    NewUser(Data database,Page origin){
        super("New account",database,origin,null);
        fnBox = new JTextField();
        fnBox.setBounds(300, 50, 150, 20);
        lnBox = new JTextField();
        lnBox.setBounds(300, 100, 150, 20);
        adBox = new JTextField();
        adBox.setBounds(300, 150, 150, 20);
        agBox = new JTextField();
        agBox.setBounds(300, 200, 150, 20);
        gBox = new JTextField();
        gBox.setBounds(300, 250, 150, 20);
        pBox = new JTextField();
        pBox.setBounds(300, 300, 150, 20);
        frame.add(fnBox);
        frame.add(lnBox);
        frame.add(adBox);
        frame.add(agBox);
        frame.add(gBox);
        frame.add(pBox);
        
        fnLabel = new JLabel("Enter first name:");
        fnLabel.setBounds(100, 50, 150, 20);
        lnLabel = new JLabel("Enter last name:");
        lnLabel.setBounds(100, 100, 150, 20);
        adLabel = new JLabel("Enter address:");
        adLabel.setBounds(100, 150, 150, 20);
        agLabel = new JLabel("Enter age:");
        agLabel.setBounds(100, 200, 150, 20);
        gLabel = new JLabel("Enter gender");
        gLabel.setBounds(100, 250, 150, 20);
        pLabel = new JLabel("Enter password:");
        pLabel.setBounds(100, 300, 150, 20);
        frame.add(fnLabel);
        frame.add(lnLabel);
        frame.add(adLabel);
        frame.add(agLabel);
        frame.add(gLabel);
        frame.add(pLabel);
        
        Publish = new JButton("Create");
        Publish.setBounds(100, 400, 100, 20);
        Publish.addActionListener(this);
        frame.add(Publish);
        Cancel = new JButton("Cancel");
        Cancel.setBounds(300, 400, 100, 20);
        Cancel.addActionListener(this);
        frame.add(Cancel);
        
        frame.setVisible(false);
        frame.setVisible(true);
    }
    
    @Override
    protected void action(ActionEvent ae) {
        if(ae.getSource() == Publish){
            String newUID = Integer.toString(info.getUsers()[info.getUsers().length - 1].getID()+1);
            String newRID;
            if(info.getRequests().length > 0){
                newRID = Integer.toString(info.getRequests()[info.getRequests().length - 1].getRequestID()+1);
            }
            else{
                newRID = "0";
            }
            String details = fnBox.getText()+ "-" + lnBox.getText() + "-" + adBox.getText() + "-" + agBox.getText() + "-" + gBox.getText() + "-p-" + newUID + "-" + pBox.getText();
            info.addRequest(new Request(newUID,"c",details,newRID));
            parent.closeChild();
            frame.setVisible(false);
        }
        else if(ae.getSource() == Cancel){
            parent.closeChild();
            frame.setVisible(false);
        }
    }
}
