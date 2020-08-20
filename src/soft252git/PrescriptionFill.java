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
public class PrescriptionFill extends Page{
    JButton fill,cancel,confirm;
    JTextField ID;
    JLabel instructions,pLabel,pName,pAddress,pSex,pAge,dLabel,dName,dAddress;
    PrescriptionFill(Data database,User accessor,Page origin){
        super("Fill Prescription",database,origin,accessor);
        ID = new JTextField();
        ID.setBounds(200,100,100, 20);
        frame.add(ID);
        instructions = new JLabel("Enter the ID number of the prescription:");
        instructions.setBounds(100,50,300,20);
        pLabel = new JLabel("Patient:");
        pName = new JLabel();
        pAddress = new JLabel();
        pSex = new JLabel();
        pAge = new JLabel();
        dLabel = new JLabel("Doctor:");
        dName = new JLabel();
        dAddress = new JLabel();
        pLabel.setBounds(100,150,50,20);
        pName.setBounds(100,180,50,20);
        pAddress.setBounds(100,210,50,20);
        pSex.setBounds(100,240,50,20);
        pAge.setBounds(100,270,50,20);
        dLabel.setBounds(300,150,50,20);
        dName.setBounds(100,180,50,20);
        dAddress.setBounds(100,210,50,20);
        frame.add(instructions);
        frame.add(pLabel);
        frame.add(pName);
        frame.add(pAddress);
        frame.add(pSex);
        frame.add(pAge);
        frame.add(dLabel);
        frame.add(dName);
        frame.add(dAddress);
        frame.add(instructions);
        fill = new JButton("Fill");
        fill.setBounds(100,400,50,20);
        fill.addActionListener(this);
        frame.add(fill);
        cancel = new JButton("Cancel");
        cancel.setBounds(300,400,50,20);
        cancel.addActionListener(this);
        frame.add(cancel);
        confirm = new JButton("Confirm");
        confirm.setBounds(200,300,50,20);
        confirm.addActionListener(this);
        confirm.setVisible(false);
        frame.add(confirm);
    }
    
    private void display(){
        for(Prescription pres : info.getPrescriptions()){
            if(Integer.toString(pres.getID()).equals(ID.getText())){
                User patient = info.searchUsers(pres.getPatient());
                User doctor = info.searchUsers(pres.getPatient());
                pLabel.setText("patient");
                pName.setText(patient.getFirstName() + " " + patient.getLastName());
                pAddress.setText(patient.getAdress());
                pSex.setText(patient.getGender());
                pAge.setText(Integer.toString(patient.getAge()));
                dLabel.setText("doctor");
                dName.setText(doctor.getFirstName() + " " + doctor.getLastName());
                dAddress.setText(doctor.getAdress());
                confirm.setVisible(true);
            }
        } 
    }
    @Override
    protected void action(ActionEvent ae){
        if(ae.getSource() == fill){
            for(Prescription pres : info.getPrescriptions()){
                if(Integer.toString(pres.getID()).equals(ID.getText())){
                    display();
                }
            } 
        }
        else if(ae.getSource() == confirm){
            for(Prescription pres : info.getPrescriptions()){
                if(Integer.toString(pres.getID()).equals(ID.getText())){
                    info.lowerMeds(pres.getMedicine(),pres.getDose());
                    info.removePrescription(pres.getID());
                }
            } 
            parent.closeChild();
            frame.setVisible(false);
        }
        else if(ae.getSource() == cancel){
            parent.closeChild();
            frame.setVisible(false);
        }
    }
}
