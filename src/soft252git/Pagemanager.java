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
public class Pagemanager{
    Data info;
    User user;
    Page child;
    Pagemanager(Data database){
       info = database;
       child = new Login(database,this);
    }
    
    public void setUser(User u){
        user = u;
        if (user.getType().equals("a")){
            child = new Adminhome(info,user,this);
        }
        else if (user.getType().equals("p")){
            child = new Patienthome(info,user,this);
        }
        else if (user.getType().equals("d")){
            child = new Doctorhome(info,user,this);
        }
        else if (user.getType().equals("s")){
            child = new SecretaryHome(info,user,this);
        }
        else{
            System.out.println("User data has been corrupted");
        }
    }
}
