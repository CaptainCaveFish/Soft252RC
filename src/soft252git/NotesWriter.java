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
    JButton Publish, Cancel, Prescribe, History, NewMed;
    User patient;
    NotesWriter(Data database, Page origin, User accessor,User subject){
        super("Notes",database,origin,accessor);
        patient = subject;
        Notes = new JTextField();
        Notes.setBounds(10, 100, 440, 260);
        frame.add(Notes);
        Publish = new JButton("Publish");
        Publish.addActionListener(this);
        Publish.setBounds(30, 450, 50, 20);
        frame.add(Publish);
        Cancel = new JButton("Cancel");
        Cancel.addActionListener(this);
        Cancel.setBounds(100, 450, 50, 20);
        frame.add(Cancel);
        Prescribe = new JButton("Prescribe");
        Prescribe.addActionListener(this);
        Prescribe.setBounds(170, 450, 100, 20);
        frame.add(Prescribe);
        History = new JButton("History");
        History.addActionListener(this);
        History.setBounds(290, 450, 50, 20);
        frame.add(History);
        NewMed = new JButton("New Med");
        NewMed.addActionListener(this);
        NewMed.setBounds(360, 450, 100, 20);
        frame.add(NewMed);
    }

    
    @Override
    protected void action(ActionEvent ae){
        if(ae.getSource() == Publish){
            Integer patientID = patient.getID();
            History Note = new History(Integer.toString(patientID),Integer.toString(user.getID()),Notes.getText());
            info.addPatientHistory(Note);
            parent.closeChild();
            frame.setVisible(false);
        }
        else if(ae.getSource() == Prescribe){
            child = new DoctorPrescriptionWriter(info,user,this,patient);
        }
        else if(ae.getSource() == History){
            child = new DoctorHistoryVeiwer(info,user,this,patient);
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
