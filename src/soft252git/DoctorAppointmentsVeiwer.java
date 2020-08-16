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
public class DoctorAppointmentsVeiwer extends Page{
    JButton makeAppointment, back;
    Appointment[] appointments;
    Integer index, max;
    DoctorAppointmentsVeiwer(Data database,Page origin,User accessor){
        super("Appointments",database,origin,accessor);
        appointments = new Appointment[0];
        fetchAppointments();
        back = new JButton("Back");
        back.addActionListener(this);
        frame.add(back);
        makeAppointment = new JButton("Book");
        makeAppointment.addActionListener(this);
        frame.add(makeAppointment);
        update();
    }
    
    private void fetchAppointments(){
        for(Appointment appointment: info.getAppointments()){
            if (appointment.getDoctor() == user.getID()){
                appointments = add(appointments,appointment);
            } 
        }
    }
    
    private String fetchTime(int[] date){
        String output;
        String hour = Integer.toString(date[3]/2) + ":" + Integer.toString((date[3]%2)*30);
        output = hour + " ";
        String day;
        if(date[2] == 0){
            day = "1st";
        }
        if(date[2] == 1){
            day = "2nd";
        }
        if(date[2] == 2){
            day = "3rd";
        }
        else{
            day = Integer.toString(date[2]) + "th";
        }
        output = output + day + " ";
        String month;
        if(date[1] == 0){
            month = "January";
        }
        else if(date[1] == 1){
            month = "Feburary";
        }
        else if(date[1] == 2){
            month = "March";
        }
        else if(date[1] == 3){
            month = "April";
        }
        else if(date[1] == 4){
            month = "May";
        }
        else if(date[1] == 5){
            month = "June";
        }
        else if(date[1] == 6){
            month = "July";
        }
        else if(date[1] == 7){
            month = "August";
        }
        else if(date[1] == 8){
            month = "September";
        }
        else if(date[1] == 9){
            month = "October";
        }
        else if(date[1] == 10){
            month = "November";
        }
        else{
            month = "December";
        }
        output = output + month + " ";
        output = output + Integer.toString(date[0]);
        return output;
    }
    
    
    protected void update(){
        int Y = 50;
        for(Appointment a : appointments){
            User patient = info.searchUsers(a.getPatient());
            JLabel label = new JLabel(patient.getFirstName() + " " + patient.getLastName() + " " + fetchTime(a.getTime()));
            label.setBounds(Y, 50, 400, 20);
            frame.add(label);
            frame.setSize(500,frame.getSize().height+30);
            Y += 30;
        }
        makeAppointment.setBounds(200, 260 + Y, 50, 20);
        back.setBounds(300,260 + Y,50,20);
        frame.revalidate();
        frame.repaint();
    }
    
    private Appointment[] add(Appointment[] list, Appointment subject){
        Appointment[] output = new Appointment[list.length + 1];
        int index = 0;
        for (Appointment line : list){
            output[index] = line;
            index += 1;
        }
        output[index] = subject;
        return output;
    }
    
    @Override
    protected void action(ActionEvent ae){
        if(ae.getSource() == makeAppointment){
            child = new AppointmentRequester(info,this,user);
        }
        if(ae.getSource() == back){
            parent.closeChild();
            frame.setVisible(false);
        }
    }
}
