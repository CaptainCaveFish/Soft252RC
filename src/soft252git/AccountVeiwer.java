/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soft252git;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 *
 * @author dillonlaskey
 */
public class AccountVeiwer extends Page{
    private JButton Cancel;
    private JButton[] buttons;
    private JPanel panel1,panel2;
    private User[] users;
    AccountVeiwer(Data database,Page origin,User accessor){
        super("Staff accounts",database,origin,accessor);
        fetchUsers();
        panel1 = new JPanel();
        panel2 = new JPanel();
        Cancel = new JButton("Cancel");
        Cancel.addActionListener(this);
        frame.add(panel1);
        frame.add(panel2);
        frame.add(Cancel);
        update();
    }
    
    private void fetchUsers(){
        users = new User[0];
        User[] allUsers = info.getUsers();
        for(User entry : allUsers){
            if(entry.getType().equals("d")){
                users = addU(users,entry);
            }
            if(entry.getType().equals("s")){
                users = addU(users,entry);
            }
        }
    }
    
    private User[] addU(User[] list, User subject){
        User[] output = new User[list.length + 1];
        int place = 0;
        for (User item : list){
            output[place] = item;
            place += 1;
        }
        output[place] = subject;
        return output;
    }
    
    private JButton[] addB(JButton[] list, JButton subject){
        JButton[] output = new JButton[list.length + 1];
        int place = 0;
        for (JButton item : list){
            output[place] = item;
            place += 1;
        }
        output[place] = subject;
        return output;
    }
    
    private void update(){
        int Y = 20;
        frame.remove(panel1);
        frame.remove(panel2);
        frame.remove(Cancel);
        buttons = new JButton[0];
        panel1 = new JPanel(new GridLayout(0,1));
        panel1.setBounds(150, 150, 100,0);
        panel2 = new JPanel(new GridLayout(0,1));
        panel2.setBounds(300, 150, 100,0);
        frame.setSize(500, 500);
        for(User u : users){
            JLabel label = new JLabel(u.getFirstName() + " " + u.getLastName());
            panel1.add(label);
            panel1.setBounds(200, 100, 100, 0+Y);
            JButton button = new JButton("Delete");
            button.addActionListener(this);
            buttons = addB(buttons,button);
            panel2.add(button);
            panel2.setBounds(300, 100, 100, 0+Y);
            Y += 20;
        }
        Cancel = new JButton("Cancel");
        Cancel.addActionListener(this);
        Cancel.setBounds(230, 350 + Y, 100, 20);
        frame.add(Cancel);
        frame.add(panel1);
        frame.add(panel2);
        frame.setSize(500, 500+Y);
        frame.revalidate();
        frame.repaint();
    }
    
    @Override
    protected void action(ActionEvent ae){
        if (ae.getSource() == Cancel){
            parent.closeChild();
            frame.setVisible(false);
        }
        int index = 0; 
        for(JButton button : buttons){
            if(ae.getSource() == button){
                info.removeUser(users[index].getID());
                fetchUsers();
                update();
            }
            index += 1;
        }
    }
}
