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
public class AppointmentMaker extends Page{
    JButton cancelButton;
    JPanel panel1,panel2;
    Integer[][] ts;
    Appointment[] appointments;
    JButton[] selects;
    Integer index;
    String[] startAndend; 
    String doctor;
    int patient;
    AppointmentMaker(Data database,User accessor,Page origin,Request request){
        super("New Appointment",database,origin,accessor);
        String[] t = request.getDetails().split("@");
        doctor = request.getDetails().split("@")[1];
        patient = request.getUserID();
        startAndend = t[0].split("-");
        appointments = fetchAppointments(startAndend[0],startAndend[1]);
        ts = fetchTimes(appointments,startAndend[0],startAndend[1]);
        cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(this);
        panel1 = new JPanel(new GridLayout(0,5));
        panel1.add(cancelButton);
        frame.add(panel1,BorderLayout.SOUTH);

        panel2 = new JPanel(new GridLayout(0,5));
        selects = new JButton[0];
        
        for(Integer[] time : ts){
            for(Integer item : time){
                panel2.add(new JLabel(Integer.toString(item)));
            }
            JButton selectButton = new JButton("Select");
            selects = addB(selects,selectButton);
            selectButton.addActionListener(this);
            panel2.add(selectButton);
        }
        frame.add(panel2);
    }
    
    private Integer[] toInt(String input){
        String[] parts = input.split(",");
        Integer[] output = new Integer[parts.length];
        for(int i = 0; i < parts.length; i++){
            output[i] = Integer.parseInt(parts[i]);
        }
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
    
    private Appointment[] addS(Appointment[] list, Appointment subject){
        Appointment[] output = new Appointment[list.length + 1];
        int place = 0;
        for (Appointment item : list){
            output[place] = item;
            place += 1;
        }
        output[place] = subject;
        return output;
    }
    
    private Integer[][] addT(Integer[][] list, Integer[] subject){
        Integer[][] output = new Integer[list.length + 1][4];
        int place = 0;
        for(Integer[] time : list){
            output[place] = time;
            place += 1;
        }
        output[place] = subject;
        return output;
    }
    
    private boolean compInt(Integer[] base, int[] subject){
        boolean output = true;
        for(int i = 0; i < base.length; i++){
            if(base[i]>subject[i]){
                output = false;
            }
        }
        return output;
    }
    
    private Appointment[] fetchAppointments(String minTime,String maxTime){
        Appointment[] output = {};
        Integer[] min = toInt(minTime) ,max = toInt(maxTime);
        for(Appointment entry : info.getAppointments()){
            int[] time = entry.getTime();
            if (entry.getDoctor() == Integer.parseInt(doctor) && compInt(min,time) == false && compInt(max,time) == true){
                output = addS(output,entry);
            }
        }
        return output;
    }
    
    private int diff(Integer[] min, Integer[] max){
        int output = 0;
        output += (max[0] - min[0])*2;
        output += (max[1] - min[1])*48;
        output += (max[2] - min[2])*1440;
        output += (max[3] - min[3])*17280;
        return output;
    }
    
        
    private Integer[][] fetchTimes(Appointment[] priors, String minTime, String maxTime){
        Integer[][] output = {};
        Integer[] min = toInt(minTime) ,max = toInt(maxTime),current = min;
        boolean unbooked;
        for(int i = 0; i <= diff(min,max); i++){
            unbooked = true;
            for(Appointment prior : priors){
                int[] time = prior.getTime();
                if(time[0] == current[0] && time[1] == current[1] && time[2] == current[2] && time[3] != current[3]){
                    unbooked = false;
                }
            }
            if(unbooked){
                output = addT(output,current);
            }
            current[3] += 1;
            if(current[3] >= 48){
                current[3] = 0;
                current[2] += 1;
            }
            if(current[2] >= 30){
                current[2] = 0;
                current[1] += 1;
            }
            if(current[1] >= 12){
                current[1] = 0;
                current[0] += 1;
            }
        }
        return output;
    }
    
    @Override
    protected void action(ActionEvent ae){
        index = 0;
        for(JButton sButton : selects){
            index += 1;
            if(ae.getSource() == sButton){
                Integer[] newTime = ts[index];
                Appointment newAppointment = new Appointment(Integer.toString(patient),doctor,Integer.toString(newTime[0]),Integer.toString(newTime[1]),Integer.toString(newTime[2]),Integer.toString(newTime[3]));
                info.addAppointment(newAppointment);
            }
        }
    }
}
