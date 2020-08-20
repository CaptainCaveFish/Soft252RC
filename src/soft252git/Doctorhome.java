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
public class Doctorhome extends Page{
    JButton appointmentsButton, notesButton;
    JLabel appointmentsLabel, notesLabel, responseLabel;
    JTextField patientfBox, patientsbox;
    Doctorhome(Data database,User accessor,Pagemanager origin){
        super("Home",database,null,accessor);
        appointmentsButton = new JButton("Appointments");
        appointmentsButton.setBounds(350,50,120,20);
        appointmentsButton.addActionListener(this);
        notesButton  = new JButton("Notes");
        notesButton.setBounds(300,250,150,20);
        notesButton.addActionListener(this);
        
        frame.add(appointmentsButton);
        frame.add(notesButton);
        
        appointmentsLabel = new JLabel("Click here to veiw appointments:");
        appointmentsLabel.setBounds(50,50,250,20);
        notesLabel = new JLabel("Enter your patients full name and click to open notes");
        notesLabel.setBounds(50,100,350,20);
        responseLabel = new JLabel();
        responseLabel.setBounds(50,100,300,20);
        patientfBox = new JTextField();
        patientfBox.setBounds(100,150,100,20);
        patientsbox = new JTextField();
        patientsbox.setBounds(250,150,100,20);
        frame.add(appointmentsLabel);
        frame.add(notesLabel);
        frame.add(responseLabel);
        frame.add(patientfBox);
        frame.add(patientsbox);
    }
    
    @Override
    protected void action(ActionEvent ae){
        if(ae.getSource() == appointmentsButton){
            child = new DoctorAppointmentsVeiwer(info,this,user);
        }
        else if(ae.getSource() == notesButton){
            User patient = info.searchUsers(patientfBox.getText(),patientsbox.getText());
            if(patient == null){
                responseLabel.setText("User not found");
            }
            else{
                child = new NotesWriter(info,this,user,patient);
            }
        }
    }
}
