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
public class PatientPrescriptionVeiwer extends Page{
    Prescription[] prescriptions;
    JButton back;
    PatientPrescriptionVeiwer(Data database,User accessor,Page origin){
        super("History",database,origin,accessor);
        prescriptions = new Prescription[0];
        fetchPrescriptions();
        back = new JButton("Back");
        back.addActionListener(this);
        frame.add(back);
        update();
    }
    
    private void fetchPrescriptions(){
        for(Prescription entry: info.getPrescriptions()){
            if (entry.getPatient() == user.getID()){
                prescriptions = add(prescriptions,entry);
            } 
        }
    }
    
    private void update(){
        int Y = 50;
        for(Prescription p : prescriptions){
                JLabel label = new JLabel(p.getMedicine()+ " " + Integer.toString(p.getDose()));
                label.setBounds(Y, 150, 200, 20);
                frame.add(label);
                frame.setSize(500,500 + Y);
                Y += 30;
        }
        back.setBounds(250, 260 + Y, 50, 20);
        frame.setVisible(false);
        frame.setVisible(true);
    }
    
    protected Prescription[] add(Prescription[] list, Prescription subject){
        Prescription[] output = new Prescription[list.length + 1];
        int index = 0;
        for (Prescription line : list){
            output[index] = line;
            index += 1;
        }
        output[index] = subject;
        return output;
    }
    
    @Override
    protected void action(ActionEvent ae){
        if (ae.getSource() == back){
            parent.closeChild();
            frame.setVisible(false);
            }
        }
    }

