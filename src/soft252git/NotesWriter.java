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
public class NotesWriter extends Page{
    JTextField Notes;
    JButton Accept, Cancel, Prescribe, History, NewMed;
    String patient;
    NotesWriter(Data database, Page origin, User accessor,String p){
        super("Notes",database,origin,accessor);
        patient = p;
        Notes = new JTextField();
        Notes.setBounds(10, 100, 480, 260);
        frame.add(Notes);
        Accept = new JButton("Publish");
        Accept.addActionListener(this);
        Accept.setBounds(30, 450, 50, 20);
        frame.add(Accept);
        Cancel = new JButton("Cancel");
        Cancel.addActionListener(this);
        Cancel.setBounds(130, 450, 50, 20);
        frame.add(Cancel);
        Prescribe = new JButton("Prescribe");
        Prescribe.addActionListener(this);
        Prescribe.setBounds(230,450, 50, 20);
        frame.add(Prescribe);
        History = new JButton("History");
        History.addActionListener(this);
        History.setBounds(270,450, 50, 20);
        frame.add(History);
        NewMed = new JButton("New Med");
        NewMed.addActionListener(this);
        NewMed.setBounds(430,450, 60, 20);
        frame.add(NewMed);
    }

    
    @Override
    protected void action(ActionEvent ae){
        if(ae.getSource() == Accept){
            Integer patientID = info.searchUsers(patient).getID();
                    History Note = new History(Integer.toString(patientID),Integer.toString(user.getID()),Notes.getText());
                    info.addPatientHistory(Note);
                    parent.closeChild();
                    frame.setVisible(false);
                }
        else if(ae.getSource() == Prescribe){
            child = new DoctorPrescriptionWriter(info,user,this,info.searchUsers(patient));
        }
        else if(ae.getSource() == History){
            child = new DoctorHistoryVeiwer(info,user,this,info.searchUsers(patient));
        }
        else if(ae.getSource() == NewMed){
            child = new MedicineRequestWindow(info,user,this);
        }
        else if(ae.getSource() == Cancel){
            parent.closeChild();
            frame.setVisible(false);
        }
    }
}
