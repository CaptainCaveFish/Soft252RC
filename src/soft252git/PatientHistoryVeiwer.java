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
public class PatientHistoryVeiwer extends Page{
    History[] history;
    JButton Back;
    PatientHistoryVeiwer(Data database ,User accessor,Page origin){
        super("History",database,origin,accessor);
        history = new History[0];
        fetchHistory();
        Back = new JButton("Back");
        Back.addActionListener(this);
        frame.add(Back);
        update();
    }
    
    private void fetchHistory(){
        for(History entry: info.getPatientHistory()){
            if (entry.getPatientID() == user.getID()){
                history = add(history,entry);
            } 
        }
    }
    
    private History[] add(History[] list, History subject){
        History[] output = new History[list.length + 1];
        int place = 0;
        for (History item : list){
            output[place] = item;
            place += 1;
        }
        output[place] = subject;
        return output;
    }
    
    private void update(){
        int Y = 50;
        String doc = null;
        for(History h : history){
            for(User u : info.getUsers()){
                if(u.getID() == h.getDoctorID()){
                    doc = u.getLastName();
                }
            }
            if (doc != null){
            JLabel label = new JLabel(doc + " " + h.getNote());
            label.setBounds(Y, 150, 200, 20);
            frame.add(label);
            frame.setSize(500,500+Y);
            Y += 30;
            }
        }
        Back.setBounds(250, 260 + Y, 50, 20);
        frame.setVisible(false);
        frame.setVisible(true);
    }
    
    @Override
    protected void action(ActionEvent ae){
        if (ae.getSource() == Back){
            parent.closeChild();
            frame.setVisible(false);
        }
    }
}
