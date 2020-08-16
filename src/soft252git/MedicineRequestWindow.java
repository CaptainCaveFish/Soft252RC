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
public class MedicineRequestWindow extends Page{
    JTextField med;
    JButton request,cancel;
    JLabel instructions;
    MedicineRequestWindow(Data database,User accessor,Page origin){
        super("Request new medication",database,origin,accessor);
        med = new JTextField();
        med.setBounds(200, 100, 100, 20);
        frame.add(med);
        request = new JButton("Request");
        request.addActionListener(this);
        request.setBounds(100, 300, 50, 20);
        frame.add(request);
        cancel = new JButton("Cancel");
        cancel.addActionListener(this);
        cancel.setBounds(300,300,50,20);
        frame.add(cancel);
        instructions = new JLabel("Enter the name of the medication you wish to request");
        instructions.setBounds(200, 200, 100, 20);
        frame.add(cancel);
    }
    @Override
    protected void action(ActionEvent ae){
        if(ae.getSource() == request){
            int newId = info.getRequests()[info.getRequests().length - 1].getRequestID() + 1;
            String medicine = med.getText();
            Request request = new Request(Integer.toString(user.getID()),"m",medicine,Integer.toString(newId));
            info.addRequest(request);
            parent.closeChild();
            frame.setVisible(false);
        }
        else if(ae.getSource() == cancel){
            parent.closeChild();
            frame.setVisible(false);
        }
    }
}
