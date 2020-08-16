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
    JLabel appointmentsLabel, notesLabel;
    JTextField patientBox;
    Doctorhome(Data database,User accessor,Pagemanager origin){
        super("Home",database,null,accessor);
        appointmentsButton = new JButton("Appointments");
        appointmentsButton.setBounds(350,50,120,20);
        appointmentsButton.addActionListener(this);
        notesButton  = new JButton("Notes");
        notesButton.setBounds(350,150,120,20);
        notesButton.addActionListener(this);
        
        frame.add(appointmentsButton);
        frame.add(notesButton);
        
        appointmentsLabel = new JLabel("Click here to veiw appointments:");
        appointmentsLabel.setBounds(100,50,200,20);
        notesLabel = new JLabel("Enter your patients last name and click to open notes");
        notesLabel.setBounds(100,100,200,20);
        patientBox = new JTextField();
        patientBox.setBounds(100,150,100,20);
        
        frame.add(appointmentsLabel);
        frame.add(notesLabel);
        frame.add(patientBox);
    }
    
    @Override
    protected void action(ActionEvent ae){
        if(ae.getSource() == appointmentsButton){
            child = new DoctorAppointmentsVeiwer(info,this,user);
        }
        else if(ae.getSource() == notesButton){
            child = new NotesWriter(info,this,user,patientBox.getText());
        }
    }
}
