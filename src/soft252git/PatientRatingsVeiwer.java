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
public class PatientRatingsVeiwer extends Page{
    JButton newrating, back;
    JTextField firstname,lastname,content;
    JLabel docLabel,contentLabel,responseLabel;
    Rating[] ratings;
    PatientRatingsVeiwer(Data database,User accessor,Page origin){
        super("Ratings",database,origin,accessor);
        fetchRatings();
        newrating = new JButton("Add rating");
        newrating.addActionListener(this);
        frame.add(newrating);
        back = new JButton("Back");
        back.addActionListener(this);
        frame.add(back);
        firstname = new JTextField();
        frame.add(firstname);
        lastname = new JTextField();
        frame.add(lastname);
        content = new JTextField();
        frame.add(content);
        docLabel = new JLabel("Enter your doctors first and last name");
        frame.add(docLabel);
        contentLabel = new JLabel("Enter your comment");
        frame.add(contentLabel);
        responseLabel = new JLabel();
        frame.add(responseLabel);
        update();
    }
    
    private void fetchRatings(){
        ratings = new Rating[0];
        for(Rating entry : info.getRatings()){
           ratings = addR(ratings,entry);
        }
    }
    
    private Rating[] addR(Rating[] list, Rating subject){
        Rating[] output = new Rating[list.length + 1];
        int place = 0;
        for (Rating item : list){
            output[place] = item;
            place += 1;
        }
        output[place] = subject;
        return output;
    }
    
    private void update(){
        int Y = 50;
        frame.setSize(500, 500);
        for(Rating r : ratings){
            String writer = info.searchUsers(r.getWriter()).getFirstName() + " " + info.searchUsers(r.getWriter()).getLastName();
            String subject = info.searchUsers(r.getSubject()).getFirstName() + " " + info.searchUsers(r.getSubject()).getLastName();
            String comment = r.getComment();
            JLabel label = new JLabel(writer + " " + subject + " " + comment);
            label.setBounds(Y, 150, 200, 20);
            frame.add(label);
            frame.setSize(500,frame.getSize().height+30);
            Y += 30;
        }
        back.setBounds(150, 350 + Y, 100, 20);
        newrating.setBounds(300, 350 + Y, 100, 20);
        docLabel.setBounds(50, 300 + Y, 250, 20);
        firstname.setBounds(250, 300 + Y, 100, 20);
        lastname.setBounds(350, 300 + Y, 100, 20);
        content.setBounds(250, 260 + Y, 150, 20);
        contentLabel.setBounds(50, 260 + Y, 250, 20);
        responseLabel.setBounds(200, 300 + Y, 100,20);
        frame.revalidate();
        frame.repaint();
    }
    
    @Override
    protected void action(ActionEvent ae){
        if (ae.getSource() == back){
            parent.closeChild();
            frame.setVisible(false);
        }
        else if(ae.getSource() == newrating){
            User doctor = info.searchUsers(firstname.getText(),lastname.getText());
            if(doctor == null){
               responseLabel.setText("Doctor not found"); 
            }
            else{
                info.addRating(new Rating(Integer.toString(user.getID()),Integer.toString(doctor.getID()),content.getText()));
                parent.closeChild();
                frame.setVisible(false);
                responseLabel.setText("");
            }
            
        }
    }
}
