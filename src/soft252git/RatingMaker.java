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
public class RatingMaker extends Page{
    String target, rating;
    JLabel doctorLabel, reveiwLabel,status;
    JTextField doctorField, reveiwField;
    JButton publish, cancel;
    RatingMaker(Data database,User accessor,Page origin){
        super("New rating",database,origin,accessor);
        doctorLabel = new JLabel("Enter the last name of the doctor you wish to reveiw:");
        doctorLabel.setBounds(150,150,50,20);
        frame.add(doctorLabel);
        reveiwLabel = new JLabel("Enter your reveiw:");
        reveiwLabel.setBounds(150, 300, 50, 20);
        frame.add(reveiwLabel);
        doctorField = new JTextField();
        doctorField.setBounds(300,150,50,20);
        frame.add(doctorField);
        reveiwField = new JTextField();
        reveiwField.setBounds(300, 300, 100, 20);
        frame.add(reveiwField);
        publish = new JButton("Publish");
        publish.addActionListener(this);
        publish.setBounds(150, 450, 50, 20);
        cancel = new JButton("Cancel");
        cancel.addActionListener(this);
        cancel.setBounds(300, 450, 50, 20);
        frame.add(publish);
        status = new JLabel();
        status.setBounds(200, 350, 50, 20);
        frame.add(status);
    }
    
    private String find(String ID){
        for(User u : info.getUsers()){
            if(u.getType().equals("d") && u.getLastName().equals(ID)){
                return Integer.toString(u.getID());
            }
        }
        return null;
    }
    
    @Override
    protected void action(ActionEvent ae){
        if(ae.getSource() == publish){
            String docID = find(doctorField.getSelectedText());
            if(docID != null){
                Rating reveiw = new Rating(Integer.toString(user.getID()),docID,reveiwField.getSelectedText());
                info.addRating(reveiw);
                parent.closeChild();
                frame.setVisible(false);
            }
            else{
                status.setText("Doctor not found");
            }
        }
        else if(ae.getSource() == cancel){
                parent.closeChild();
                frame.setVisible(false);
        }
    }
}

