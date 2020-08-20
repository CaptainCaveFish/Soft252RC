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
public class Prescription {
    int p,d,id,doc;
    String m;
    Prescription(String prescriptionID, String patientID, String medicine, String dose, String docID){
        id = Integer.parseInt(prescriptionID);
        p = Integer.parseInt(patientID);
        m = medicine;
        d = Integer.parseInt(dose);
        doc = Integer.parseInt(docID);
    }
    
    public int getID(){
        return id;
    }
    public int getPatient(){
        return p;
    }
    public int getDoctor(){
        return doc;
    }
    public int getDose(){
        return d;
    }
    public String getMedicine(){
        return m;
    }
}
