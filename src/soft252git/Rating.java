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
public class Rating {
    int w,s;
    String c;
    Rating(String writerID, String subjectID, String comment){
        w = Integer.parseInt(writerID);
        s = Integer.parseInt(subjectID);
        c = comment;
    }
    
    public int getWriter(){
        return w;
    }
    public int getSubject(){
        return s;
    }
    public String getComment(){
        return c;
    }
}
