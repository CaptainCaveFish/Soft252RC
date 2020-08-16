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
public class DoctorPrescriptionWriter extends Page{
    JTextField med,dose;
    JButton Publish, Cancel;
    JLabel instruction;
    User patient;
    DoctorPrescriptionWriter(Data database, User accessor, Page origin,User p){
        super("Prescription",database,origin,accessor);
        patient = p;
        med = new JTextField();
        med.setBounds(50, 200, 100, 20);
        frame.add(med);
        dose = new JTextField();
        dose.setBounds(200, 200, 100, 20);
        frame.add(dose);
        Publish = new JButton("Publish");
        Publish.addActionListener(this);
        Publish.setBounds(100, 300, 50, 20);
        frame.add(Publish);
        Cancel = new JButton("Cancel");
        Cancel.addActionListener(this);
        Cancel.setBounds(300, 300, 50, 20);
        frame.add(Cancel);
        instruction = new JLabel("Enter the medication and dosage of the prescription\nthen the patient you are prescribing:");
        instruction.setBounds(10, 50, 480, 20);
        frame.add(instruction);
    }
    
    @Override
    protected void action(ActionEvent ae){
        if(ae.getSource() == Publish){
            int newID;
            if(info.getPrescriptions().length > 0){
                newID = info.getPrescriptions()[info.getPrescriptions().length - 1].getID() + 1;
            }
            else
            {
                newID = 0;
            }
            String medication = med.getText();
            String dosage = dose.getText();
            String ID = Integer.toString(newID);
            String patientID = Integer.toString(patient.getID());
            info.addPrescription(new Prescription(ID,patientID,medication,dosage));
            parent.closeChild();
            frame.setVisible(false);
            
        }
        else if(ae.getSource() == Cancel){
            parent.closeChild();
            frame.setVisible(false);
        }
    }
}
