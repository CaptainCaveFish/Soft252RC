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
public class History {
    int p,d;
    String n;
    History(String patientID, String doctorID, String note){
        p = Integer.parseInt(patientID);
        d = Integer.parseInt(doctorID);
        n = note;
    }
    
    public int getPatientID(){
        return p;
    }
    public int getDoctorID(){
        return d;
    }
    public String getNote(){
        return n;
    }
}
