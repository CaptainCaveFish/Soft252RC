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
public class Feedback {
    int a,d;
    String n;
    Feedback(String adminID, String doctorID, String note){
        a = Integer.parseInt(adminID);
        d = Integer.parseInt(doctorID);
        n = note;
    }
    
    public int getAdmin(){
        return a;
    }
    public int getDoctor(){
        return d;
    }
    public String getNote(){
        return n;
    }
}
