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
public class RatingsVeiwer extends Page{
    JButton Back;
    User[] docs;
    Rating[] ratings; 
    RatingsVeiwer(Data database,Page origin,User accessor){
        super("Ratings",database,origin,accessor);
        docs = new User[0];
        fetchDocs();
        ratings = new Rating[0];
        fetchRatings();
        Back = new JButton("Cancel");
        Back.addActionListener(this);
        frame.add(Back);
        update();
    }
    
    private void update(){
        int Y = 50;
        for(Rating r : ratings){
            User d = searchDocs(r.getSubject());
            JLabel label = new JLabel(d.getFirstName() + " " + d.getLastName() + " " + r.getComment());
            label.setBounds(150, Y, 200, 20);
            frame.add(label);
            frame.setSize(500,500+Y);
            Y += 30;
        }
        Back.setBounds(230, 350 + Y, 50, 20);
        frame.revalidate();
        frame.repaint();
    }
    
    private User[] addU(User[] list, User subject){
        User[] output = new User[list.length + 1];
        int place = 0;
        for (User item : list){
            output[place] = item;
            place += 1;
        }
        output[place] = subject;
        return output;
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
    
    private void fetchDocs(){
        User[] allUsers = info.getUsers();
        for(User entry : allUsers){
            if(entry.getType().equals("d")){
                docs = addU(docs,entry);
            }
        }
    }
    
    private void fetchRatings(){
        Rating[] allRatings = info.getRatings();
        for(Rating entry : allRatings){
                ratings = addR(ratings,entry);
            }
        }

    
    private User searchDocs(int id){
        for(User doc : docs){
            if(doc.getID() == id){
                return doc;
            }
        }
        return null;
    }
    
    @Override
    protected void action(ActionEvent ae){
        if (ae.getSource() == Back){
            parent.closeChild();
            frame.setVisible(false);
        }
    }
}
