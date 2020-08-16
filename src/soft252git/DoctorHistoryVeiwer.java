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
public class DoctorHistoryVeiwer extends Page{
    JButton back;
    History[] history;
    User patient;
    DoctorHistoryVeiwer(Data database,User accessor,Page origin,User p){
        super("Patient history",database,origin,accessor);
        patient = p;
        history = new History[0];
        fetchHistory();
        back = new JButton("Back");
        back.addActionListener(this);
        frame.add(back);
        update();
    }
    
    private void fetchHistory(){
        for(History h: info.getPatientHistory()){
            if(h.getPatientID() ==  patient.getID()){
                history = add(history,h);
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
    
    protected void update(){
        int Y = 50;
        for(History h : history){
            JLabel label = new JLabel(info.searchUsers(h.getPatientID())+ " " + h.getNote());
            label.setBounds(Y, 150, 20, 200);
            frame.add(label);
            frame.setSize(500,frame.getSize().height+30);
            Y += 30;
        }
        back.setBounds(250, 260 + Y, 20, 20);
        frame.revalidate();
        frame.repaint();
    }
    
    
    @Override
    protected void action(ActionEvent ae){
        if(ae.getSource() == back){
            parent.closeChild();
            frame.setVisible(false);
        }
    }
}
