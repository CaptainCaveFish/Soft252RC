/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soft252git;

import java.awt.event.ActionEvent;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author dillonlaskey
 */
public class AppointmentMakerTest {
    
    public AppointmentMakerTest() {
    }
    
    @Test
    public void testconstructor(){
        Data data = new Data();
        Request request = new Request("1",null,"1,1,1,1-1,1,1,1@11","1");
        AppointmentMaker subject = new AppointmentMaker(data,null,null,request);
        assertNotNull(subject);
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
}
