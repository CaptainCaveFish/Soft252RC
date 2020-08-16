/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soft252git;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 *
 * @author dillonlaskey
 */
public class Soft252Git {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Data database = new Data();
        Pagemanager top = new Pagemanager(database);
    }
    
    
}