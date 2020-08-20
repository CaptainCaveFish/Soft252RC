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
    JButton Publish,cancel;
    JLabel instructions;
    MedicineRequestWindow(Data database,User accessor,Page origin){
        super("Request new medication",database,origin,accessor);
        med = new JTextField();
        med.setBounds(200, 100, 100, 20);
        frame.add(med);
        Publish = new JButton("Request");
        Publish.addActionListener(this);
        Publish.setBounds(100, 300, 50, 20);
        frame.add(Publish);
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
        if(ae.getSource() == Publish){
            Request[] requests = info.getRequests();
            if(requests.length > 0){
                int newId = info.getRequests()[info.getRequests().length - 1].getRequestID() + 1;
                String medicine = med.getText();
                Request request = new Request(Integer.toString(user.getID()),"m",medicine,Integer.toString(newId));
                info.addRequest(request);
                parent.closeChild();
                frame.setVisible(false);
            }
            else{
                int newId = 0;
                String medicine = med.getText();
                Request request = new Request(Integer.toString(user.getID()),"m",medicine,Integer.toString(newId));
                info.addRequest(request);
                parent.closeChild();
                frame.setVisible(false);
            }
        }
        else if(ae.getSource() == cancel){
            parent.closeChild();
            frame.setVisible(false);
        }
    }
}
