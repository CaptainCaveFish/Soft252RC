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
public class User {
    private String fn,ln,t,p,ad,g;
    private int id,ag;
    User(String firstName, String lastName,String address, String age, String gender, String type, String ID, String passWord){
        fn = firstName;
        ln = lastName;
        t = type;
        id = Integer.parseInt(ID);
        p = passWord;
        ad = address;
        ag = Integer.parseInt(age);
        g = gender;
    }
    
    public String getFirstName(){
        return fn;
    }
    public String getLastName(){
        return ln;
    }
    public String getType(){
        return t;
    }
    public int getID(){
        return id;
    }
    public String getPassWord(){
        return p;
    }
    public String getAdress(){
        return p;
    }
    public int getAge(){
        return ag;
    }
    public String getGender(){
        return g;
    }
}
