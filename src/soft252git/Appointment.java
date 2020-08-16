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
public class Appointment {
    int y,m,d,h,p,doc;
    Appointment(String patient, String doctor, String year, String month, String day, String hour){
        p = Integer.parseInt(patient);
        doc = Integer.parseInt(doctor);
        y = Integer.parseInt(year);
        m = Integer.parseInt(month);
        d = Integer.parseInt(day);
        h = Integer.parseInt(hour);
    }
    
    public int[] getTime(){
        int[] output = {y,m,d,h};
        return output;
    }
    
    public int getPatient(){
        return p;
    }
    
    public int getDoctor(){
        return doc;
    }
}
