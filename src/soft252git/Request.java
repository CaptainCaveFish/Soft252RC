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
public class Request {
    int u,id;
    String t,d;
    Request(String userId, String type, String details, String requestID){
        u = Integer.parseInt(userId);
        t = type;
        d = details;
        id = Integer.parseInt(requestID);
    }
    
    public int getUserID(){
        return u;
    }
    public String getType(){
        return t;
    }
    public String getDetails(){
        return d;
    }
    public int getRequestID(){
        return id;
    }
}
