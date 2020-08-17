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
public class SecretaryHome extends Page{
    JButton fillButton,stocksButton;
    JPanel panel1,panel2,panel3;
    Request[] requests;
    JButton[] approves,denys;
    Integer index;
    SecretaryHome(Data database,User accessor,Pagemanager origin){
        super("Home",database,null,accessor);
        requests = info.getRequests();
        fillButton = new JButton("Fill prescription");
        fillButton.addActionListener(this);
        frame.add(fillButton);
        stocksButton = new JButton("Manage medicine stocks");
        stocksButton.addActionListener(this);
        frame.add(stocksButton);
        panel1 = new JPanel();
        frame.add(panel1);
        panel2 = new JPanel(); 
        frame.add(panel2);
        panel3 = new JPanel(); 
        frame.add(panel3);
        update();
        
        
    }
    private void update(){
        int Y = 20;
        requests = info.getRequests();
        frame.remove(panel1);
        frame.remove(panel2);
        frame.remove(panel3);
        frame.remove(fillButton);
        frame.remove(stocksButton);
        panel1 = new JPanel(new GridLayout(0,1));
        panel2 = new JPanel(new GridLayout(0,1));
        panel3 = new JPanel(new GridLayout(0,1));
        approves = new JButton[0];
        denys = new JButton[0];
        for(Request request : requests){
            String name;
            try{
                User u = info.searchUsers(request.getUserID());
                name = u.getFirstName() + " " + u.getLastName();
            }
            catch(Exception e){
                name = "New User";
            }
            panel1.add(new JLabel(name + " " + request.getType()));
            JButton accept = new JButton("Accept");
            accept.addActionListener(this);
            approves = addB(approves,accept);
            panel2.add(accept);
            JButton deny = new JButton("Deny");
            deny.addActionListener(this);
            denys = addB(denys,deny);
            panel3.add(deny);
            Y += 20;
        }
        panel1.setBounds(50, 50, 150, Y);
        panel2.setBounds(200, 50, 100, Y);
        panel3.setBounds(300, 50, 100, Y);
        fillButton = new JButton("Fill prescription");
        fillButton.addActionListener(this);
        fillButton.setBounds(100, 450 + Y, 150, 20);
        frame.add(fillButton);
        stocksButton = new JButton("Manage medicine stocks");
        stocksButton.addActionListener(this);
        stocksButton.setBounds(300, 450 + Y, 150, 20);
        frame.add(stocksButton);
        frame.add(panel1);
        frame.add(panel2);
        frame.add(panel3);
        frame.setSize(500, 500+Y);
        frame.revalidate();
        frame.repaint();
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
    
    @Override
    protected void action(ActionEvent ae){
        index = 0;
        for(JButton aButton : approves){
            if(ae.getSource() == aButton){
                if(requests[index].getType().equals("c")){
                    String[] userData = requests[index].getDetails().split("-");
                    info.addUser(new User(userData[0],userData[1],userData[2],userData[3],userData[4],userData[5],userData[6],userData[7]));
                    info.removeRequest(requests[index].getRequestID());
                    update();
                }
                else if(requests[index].getType().equals("a")){
                    child = new AppointmentMaker(info,user,this,requests[index]);
                    info.removeRequest(requests[index].getRequestID());
                    update();
                }
                else if(requests[index].getType().equals("t")){
                    info.removeUser(requests[index].getUserID());
                    info.removeRequest(requests[index].getRequestID());
                    update();
                }
                else if(requests[index].getType().equals("m")){
                    Medicine newMed = new Medicine(requests[index].getDetails(),0); 
                    info.addMedStocks(newMed);
                    info.removeRequest(requests[index].getRequestID());
                    update();
                }
                
            }
            index += 1;
        }
        index = 0;
        for(JButton dButton : denys){
            index += 1;
            if(ae.getSource() == dButton){
                info.removeRequest(requests[index].getRequestID());
            }
        }
        if(ae.getSource() == fillButton){
            child = new PrescriptionFill(info,user,this);
        }
        else if(ae.getSource() == stocksButton){
            child = new MedStockVeiwer(info,user,this);
        }
    }
}
