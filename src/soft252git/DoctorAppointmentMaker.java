
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
public class DoctorAppointmentMaker extends Page{
    JLabel Hour, Day, Month, Year;
    JTextField firstname,lastname;
    int[] timeValue = {1,1,1,2000};
    int dID,pID;
    JButton publish, cancel, upHour, upDay, upMonth, upYear, downHour, downDay, downMonth, downYear;
    JLabel instruction;
    DoctorAppointmentMaker(Data database,Page origin,User accessor){
        super("Make appointment",database,origin,accessor);
        firstname = new JTextField();
        firstname.setBounds(150, 50, 100, 20);
        frame.add(firstname);
        lastname = new JTextField();
        lastname.setBounds(300, 50, 100, 20);
        frame.add(lastname);
        
        upHour = new JButton("^");
        upHour.addActionListener(this);
        upHour.setBounds(50, 170, 20, 20);
        frame.add(upHour);
        Hour = new JLabel("00:00");
        Hour.setBounds(50, 200, 50, 20);
        frame.add(Hour);
        downHour = new JButton("v");
        downHour.setBounds(50, 230, 20, 20);
        downHour.addActionListener(this);
        frame.add(downHour);
        
        upDay = new JButton("^");
        upDay.addActionListener(this);
        upDay.setBounds(100, 170, 20, 20);
        frame.add(upDay);
        Day = new JLabel("1st");
        Day.setBounds(100, 200, 50, 20);
        frame.add(Day);
        downDay = new JButton("v");
        downDay.addActionListener(this);
        downDay.setBounds(100, 230, 20, 20);
        frame.add(downDay);
        
        upMonth = new JButton("^");
        upMonth.addActionListener(this);
        upMonth.setBounds(150, 170, 20, 20);
        frame.add(upMonth);
        Month = new JLabel("Jan");
        Month.setBounds(150, 200, 100, 20);
        frame.add(Month);
        downMonth = new JButton("v");
        downMonth.addActionListener(this);
        downMonth.setBounds(150, 230, 20, 20);
        frame.add(downMonth);
        
        upYear = new JButton("^");
        upYear.addActionListener(this);
        upYear.setBounds(250, 170, 20, 20);
        frame.add(upYear);
        Year = new JLabel("2020");
        Year.setBounds(250, 200, 100, 20);
        frame.add(Year);
        downYear = new JButton("v");
        downYear.addActionListener(this);
        downYear.setBounds(250, 230, 20, 20);
        frame.add(downYear);
        
        publish = new JButton("Publish");
        publish.setBounds(150, 400, 50, 20);
        publish.addActionListener(this);
        frame.add(publish);
        cancel = new JButton("Cancel");
        cancel.setBounds(300, 400, 50, 20);
        cancel.addActionListener(this);
        frame.add(cancel);
        instruction = new JLabel("Enter the patients first and last name");
        instruction.setBounds(150,300,200,20);
        frame.add(instruction);
        update();
    }
    
    private String[] fetchTime(int[] date){
        String[] output = new String[4];
        String hour = Integer.toString(date[0]/2) + ":" + Integer.toString((date[0]%2)*30);
        output[0] = hour;
        String day;
        switch (date[1]) {
            case 0:
                day = "1st";
                break;
            case 1:
                day = "2nd";
                break;
            case 2:
                day = "3rd";
                break;
            default:
                day = Integer.toString(date[1]) + "th";
                break;
        }
        output[1] = day;
        String month;
        switch (date[2]) {
            case 0:
                month = "January";
                break;
            case 1:
                month = "Feburary";
                break;
            case 2:
                month = "March";
                break;
            case 3:
                month = "April";
                break;
            case 4:
                month = "May";
                break;
            case 5:
                month = "June";
                break;
            case 6:
                month = "July";
                break;
            case 7:
                month = "August";
                break;
            case 8:
                month = "September";
                break;
            case 9:
                month = "October";
                break;
            case 10:
                month = "November";
                break;
            default:
                month = "December";
                break;
        }
        output[2] = month;
        output[3] = Integer.toString(date[3]);
        return output;
    }
    
    private void update(){
        if(timeValue[0] > 47){
            timeValue[0] = 0;
            timeValue[1] += 1;
        }
        if(timeValue[1] > 6){
            timeValue[1] = 0;
            timeValue[2] += 1;
        }
        if(timeValue[2] > 11){
            timeValue[2] = 0;
            timeValue[3] += 1;
        }
        
        String[] time = fetchTime(timeValue);
        Hour.setText(time[0]);
        Day.setText(time[1]);
        Month.setText(time[2]);
        Year.setText(time[3]);
    }
    
    private String[] intToString(int[] array){
        String[] output = new String[4];
        for(int i = 0; i < 4; i++){
            output[i] = Integer.toString(array[i]);
        }
        return output;
    }
    
    @Override
    protected void action(ActionEvent ae){
        if (ae.getSource() == publish){
            dID = user.getID();
            pID = info.searchUsers(firstname.getText(),lastname.getText()).getID();
            String[] details = intToString(timeValue);
            info.addAppointment(new Appointment(Integer.toString(pID),Integer.toString(dID),details[3],details[2],details[1],details[0]));
            parent.closeChild();
            frame.setVisible(false);
        }
        else if(ae.getSource() == cancel){
           parent.closeChild();
           frame.setVisible(false);
        }
        else if(ae.getSource() == upHour){
            timeValue[0] += 1;
            update();
        }
        else if(ae.getSource() == upDay){
            timeValue[1] += 1;
            update();
        }
        else if(ae.getSource() == upMonth){
            timeValue[2] += 1;
            update();
        }
        else if(ae.getSource() == upYear){
            timeValue[3] += 1;
            update();
        }
        else if(ae.getSource() == downHour){
            if(timeValue[0] > 0){
                timeValue[0] -= 1;
                update();
            }
        }
        else if(ae.getSource() == downDay){
            if(timeValue[1] > 0){
            timeValue[1] -= 1;
            update();
            }
        }
        else if(ae.getSource() == downMonth){
            if(timeValue[2] > 0){
            timeValue[2] -= 1;
            update();
            }
        }
        else if(ae.getSource() == downYear){
            if(timeValue[3] > 0){
            timeValue[3] -= 1;
            update();
            }
        }
    }
}

