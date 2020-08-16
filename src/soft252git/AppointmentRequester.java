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
public class AppointmentRequester extends Page{
    JLabel minHour, minDay, minMonth, minYear, maxHour, maxDay, maxMonth, maxYear;
    JTextField doctor;
    int[] minValue = {0,0,0,2000};
    int[] maxValue = {1,1,1,2000};
    int dID,pID;
    JButton publish, cancel, upMinHour, upMinDay, upMinMonth, upMinYear, upMaxHour, upMaxDay, upMaxMonth, upMaxYear, downMinHour, downMinDay, downMinMonth, downMinYear, downMaxHour, downMaxDay, downMaxMonth, downMaxYear;
    JLabel instruction;
    AppointmentRequester(Data database,Page origin,User accessor){
        super("Make appointment",database,origin,accessor);
        doctor = new JTextField();
        doctor.setBounds(150, 50, 100, 20);
        frame.add(doctor);
        
        upMinHour = new JButton("^");
        upMinHour.addActionListener(this);
        upMinHour.setBounds(50, 70, 20, 20);
        frame.add(upMinHour);
        minHour = new JLabel();
        minHour.setBounds(50, 100, 50, 20);
        frame.add(minHour);
        downMinHour = new JButton("v");
        downMinHour.setBounds(50, 130, 20, 20);
        downMinHour.addActionListener(this);
        frame.add(downMinHour);
        
        upMinDay = new JButton("^");
        upMinDay.addActionListener(this);
        upMinDay.setBounds(100, 70, 20, 20);
        frame.add(upMinDay);
        minDay = new JLabel();
        minDay.setBounds(100, 100, 50, 20);
        frame.add(minDay);
        downMinDay = new JButton("v");
        downMinDay.addActionListener(this);
        downMinDay.setBounds(100, 130, 20, 20);
        frame.add(downMinDay);
        
        upMinMonth = new JButton("^");
        upMinMonth.addActionListener(this);
        upMinMonth.setBounds(150, 70, 20, 20);
        frame.add(upMinMonth);
        minMonth = new JLabel();
        minMonth.setBounds(150, 100, 100, 20);
        frame.add(minMonth);
        downMinMonth = new JButton("v");
        downMinMonth.addActionListener(this);
        downMinMonth.setBounds(150, 130, 20, 20);
        frame.add(downMinMonth);
        
        upMinYear = new JButton("^");
        upMinYear.addActionListener(this);
        upMinYear.setBounds(250, 70, 20, 20);
        frame.add(upMinYear);
        minYear = new JLabel();
        minYear.setBounds(250, 100, 150, 20);
        frame.add(minYear);
        downMinYear = new JButton("v");
        downMinYear.addActionListener(this);
        downMinYear.setBounds(250, 130, 20, 20);
        frame.add(downMinYear);
        
        upMaxHour = new JButton("^");
        upMaxHour.addActionListener(this);
        upMaxHour.setBounds(50, 170, 20, 20);
        frame.add(upMaxHour);
        maxHour = new JLabel();
        maxHour.setBounds(50, 200, 50, 20);
        frame.add(maxHour);
        downMaxHour = new JButton("v");
        downMaxHour.setBounds(50, 230, 20, 20);
        downMaxHour.addActionListener(this);
        frame.add(downMaxHour);
        
        upMaxDay = new JButton("^");
        upMaxDay.addActionListener(this);
        upMaxDay.setBounds(100, 170, 20, 20);
        frame.add(upMaxDay);
        maxDay = new JLabel();
        maxDay.setBounds(100, 200, 50, 20);
        frame.add(maxDay);
        downMaxDay = new JButton("v");
        downMaxDay.addActionListener(this);
        downMaxDay.setBounds(100, 230, 20, 20);
        frame.add(downMaxDay);
        
        upMaxMonth = new JButton("^");
        upMaxMonth.addActionListener(this);
        upMaxMonth.setBounds(150, 170, 20, 20);
        frame.add(upMaxMonth);
        maxMonth = new JLabel();
        maxMonth.setBounds(150, 200, 100, 20);
        frame.add(maxMonth);
        downMaxMonth = new JButton("v");
        downMaxMonth.addActionListener(this);
        downMaxMonth.setBounds(150, 230, 20, 20);
        frame.add(downMaxMonth);
        
        upMaxYear = new JButton("^");
        upMaxYear.addActionListener(this);
        upMaxYear.setBounds(250, 170, 20, 20);
        frame.add(upMaxYear);
        maxYear = new JLabel();
        maxYear.setBounds(250, 200, 100, 20);
        frame.add(maxYear);
        downMaxYear = new JButton("v");
        downMaxYear.addActionListener(this);
        downMaxYear.setBounds(250, 230, 20, 20);
        frame.add(downMaxYear);
        
        publish = new JButton("Publish");
        publish.setBounds(150, 400, 50, 20);
        publish.addActionListener(this);
        frame.add(publish);
        cancel = new JButton("Cancel");
        cancel.setBounds(300, 400, 50, 20);
        cancel.addActionListener(this);
        frame.add(cancel);
        instruction = new JLabel("Enter the Doctors last name and your reveiw into the boxes provided");
        instruction.setBounds(150,300,200,20);
        frame.add(instruction);
        update();
    }
    
    private String[] fetchTime(int[] date){
        String[] output = new String[4];
        String hour = Integer.toString(date[0]/2) + ":" + Integer.toString((date[0]%2)*30);
        output[0] = hour;
        String day;
        if(date[1] == 0){
            day = "1st";
        }
        else if(date[1] == 1){
            day = "2nd";
        }
        else if(date[1] == 2){
            day = "3rd";
        }
        else{
            day = Integer.toString(date[1]) + "th";
        }
        output[1] = day;
        String month;
        if(date[2] == 0){
            month = "January";
        }
        else if(date[2] == 1){
            month = "Feburary";
        }
        else if(date[2] == 2){
            month = "March";
        }
        else if(date[2] == 3){
            month = "April";
        }
        else if(date[2] == 4){
            month = "May";
        }
        else if(date[2] == 5){
            month = "June";
        }
        else if(date[2] == 6){
            month = "July";
        }
        else if(date[2] == 7){
            month = "August";
        }
        else if(date[2] == 8){
            month = "September";
        }
        else if(date[2] == 9){
            month = "October";
        }
        else if(date[2] == 10){
            month = "November";
        }
        else{
            month = "December";
        }
        output[2] = month;
        output[3] = Integer.toString(date[3]);
        return output;
    }
    
    private void update(){
        if(minValue[0] > 47){
            minValue[0] = 0;
            minValue[1] += 1;
        }
        if(minValue[1] > 29){
            minValue[1] = 0;
            minValue[2] += 1;
        }
        if(minValue[2] > 11){
            minValue[2] = 0;
            minValue[3] += 1;
        }
        if(maxValue[0] > 47){
            maxValue[0] = 0;
            maxValue[1] += 1;
        }
        if(maxValue[1] > 6){
            maxValue[1] = 0;
            maxValue[2] += 1;
        }
        if(maxValue[2] > 11){
            maxValue[2] = 0;
            maxValue[3] += 1;
        }
        
        String[] minTime = fetchTime(minValue);
        String[] maxTime = fetchTime(maxValue);
        minHour.setText(minTime[0]);
        minDay.setText(minTime[1]);
        minMonth.setText(minTime[2]);
        minYear.setText(minTime[3]);
        maxHour.setText(maxTime[0]);
        maxDay.setText(maxTime[1]);
        maxMonth.setText(maxTime[2]);
        maxYear.setText(maxTime[3]);
    }
    
    private String intToString(int[] i){
        String output = "";
        for(int j : i){
            output += Integer.toString(j);
            output += "/";
        }
        return output;
    }
    
    @Override
    protected void action(ActionEvent ae){
        if (ae.getSource() == publish){
            if(user.getType().equals("d")){
                dID = user.getID();
                pID = info.searchUsers(doctor.getText()).getID();
            }
            else if(user.getType().equals("p")){
                dID = info.searchUsers(doctor.getText()).getID();
                pID = user.getID();
            }
            int IDnumber = info.getRequests()[info.getRequests().length - 1].getRequestID() + 1;
                String details = intToString(minValue) + "-" + intToString(maxValue) +  "*" + Integer.toString(dID);
                info.addRequest(new Request(Integer.toString(pID),"a",details,Integer.toString(IDnumber)));
                parent.closeChild();
                frame.setVisible(false);
        }
        else if(ae.getSource() == cancel){
           parent.closeChild();
           frame.setVisible(false);
        }
        else if(ae.getSource() == upMinHour){
            minValue[0] += 1;
            update();
        }
        else if(ae.getSource() == upMinDay){
            minValue[1] += 1;
            update();
        }
        else if(ae.getSource() == upMinMonth){
            minValue[2] += 1;
            update();
        }
        else if(ae.getSource() == upMinYear){
            minValue[3] += 1;
            update();
        }
        else if(ae.getSource() == downMinHour){
            if(minValue[0] > 0){
                minValue[0] -= 1;
                update();
            }
        }
        else if(ae.getSource() == downMinDay){
            if(minValue[1] > 0){
            minValue[1] -= 1;
            update();
            }
        }
        else if(ae.getSource() == downMinMonth){
            if(minValue[2] > 0){
            minValue[2] -= 1;
            update();
            }
        }
        else if(ae.getSource() == downMinYear){
            if(minValue[3] > 0){
            minValue[3] -= 1;
            update();
            }
        }
        else if(ae.getSource() == upMaxHour){
            maxValue[0] += 1;
            update();
        }
        else if(ae.getSource() == upMaxDay){
            maxValue[1] += 1;
            update();
        }
        else if(ae.getSource() == upMaxMonth){
            maxValue[2] += 1;
            update();
        }
        else if(ae.getSource() == upMaxYear){
            maxValue[3] += 1;
            update();
        }
        else if(ae.getSource() == downMaxHour){
            if(maxValue[0] > 0){
                maxValue[0] -= 1;
                update();
            }
        }
        else if(ae.getSource() == downMaxDay){
            if(maxValue[1] > 0){
            maxValue[1] -= 1;
            update();
            }
        }
        else if(ae.getSource() == downMaxMonth){
            if(maxValue[2] > 0){
            maxValue[2] -= 1;
            update();
            }
        }
        else if(ae.getSource() == downMaxYear){
            if(maxValue[3] > 0){
            maxValue[3] -= 1;
            update();
            }
        }
    }
}
