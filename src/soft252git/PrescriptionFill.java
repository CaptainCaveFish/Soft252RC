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
    JButton fill,cancel;
    JTextField ID;
    JLabel instructions;
    PrescriptionFill(Data database,User accessor,Page origin){
        super("Fill Prescription",database,origin,accessor);
        ID = new JTextField();
        ID.setBounds(200, 200,100, 20);
        frame.add(ID);
        instructions = new JLabel("Enter the ID number of the prescription:");
        instructions.setBounds(100,100,300,20);
        frame.add(instructions);
        fill = new JButton("Fill");
        fill.setBounds(100,200,50,20);
        fill.addActionListener(this);
        frame.add(fill);
        cancel = new JButton("Cancel");
        cancel.setBounds(300,200,50,20);
        cancel.addActionListener(this);
        frame.add(cancel);
    }
    @Override
    protected void action(ActionEvent ae){
        if(ae.getSource() == fill){
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
