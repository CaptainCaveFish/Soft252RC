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

public class Patienthome extends Page{
    JButton ratingsButton, appointmentsButton, historyButton, prescriptionButton, terminationButton;
    JLabel ratingsLabel, appointmentLabel, historyLabel, prescriptionLabel, terminationLabel;
    JPanel panel;
    Pagemanager parent;
    Patienthome(Data database, User accessor,Pagemanager origin){
        super("Home",database,null,accessor);
        parent = origin;
        
        //Instances labels and sets bounds
        ratingsLabel = new JLabel("Veiw doctor ratings:");
        ratingsLabel.setBounds(50, 50, 200, 20);
        appointmentLabel = new JLabel("Veiw appointments:");
        appointmentLabel.setBounds(50, 100, 200, 20);
        historyLabel = new JLabel("Veiw your history:");
        historyLabel.setBounds(50, 150, 200, 20);
        prescriptionLabel = new JLabel("Veiw your prescriptions:");
        prescriptionLabel.setBounds(50, 200, 200, 20);
        terminationLabel = new JLabel("Terminate your account:");
        terminationLabel.setBounds(50, 250, 200, 20);
        
        //Add labels to frame
        frame.add(ratingsLabel);
        frame.add(appointmentLabel);
        frame.add(historyLabel);
        frame.add(prescriptionLabel);
        frame.add(terminationLabel);
        
        //Instances buttons and sets bounds
        ratingsButton = new JButton("Ratings");
        ratingsButton.setBounds(300, 50, 100, 20);
        ratingsButton.addActionListener(this);
        appointmentsButton = new JButton("Appointments");
        appointmentsButton.setBounds(300, 100, 100, 20);
        appointmentsButton.addActionListener(this);
        historyButton = new JButton("History");
        historyButton.setBounds(300, 150, 100, 20);
        historyButton.addActionListener(this);
        prescriptionButton = new JButton("Prescriptions");
        prescriptionButton.setBounds(300, 200, 100, 20);
        prescriptionButton.addActionListener(this);
        terminationButton = new JButton("Terminate");
        terminationButton.setBounds(300, 250, 100, 20);
        terminationButton.addActionListener(this);
        //Add buttons to frame
        frame.add(ratingsButton);
        frame.add(appointmentsButton);
        frame.add(historyButton);
        frame.add(prescriptionButton);
        frame.add(terminationButton);
    }
    
    @Override
    protected void action(ActionEvent ae){
        if(ae.getSource() == ratingsButton){
            child = new PatientRatingsVeiwer(info,user,this);
        }
        else if(ae.getSource() == appointmentsButton){
            child = new PatientAppointmentsVeiwer(info,user,this);
        }
        else if(ae.getSource() == historyButton){
            child = new PatientHistoryVeiwer(info,user,this);
        }
        else if(ae.getSource() == prescriptionButton){
            child = new PatientPrescriptionVeiwer(info,user,this);
        }
        else if(ae.getSource() == terminationButton){
            child = new TerminationWindow(info,user,this);
        }
    }
}
