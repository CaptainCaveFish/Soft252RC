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
public class Medicine {
    String m;
    int s;
    Medicine(String med, int supply){
        m = med;
        s = supply;
    }
    
    public String getMed(){
        return m;
    }
    public int getSupply(){
        return s;
    }
    public void setSupply(int value){
        s = value;
    }
}
