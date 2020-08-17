/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soft252git;

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
public class AppointmentTest {
    
    
    public AppointmentTest() {
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

    /**
     * Test of getTime method, of class Appointment.
     */
    @Test
    public void testGetTime() {
        System.out.println("getTime");
        Appointment instance = new Appointment("1","1","1","1","1","1");
        int[] expResult = {1,1,1,1};
        int[] result = instance.getTime();
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of getPatient method, of class Appointment.
     */
    @Test
    public void testGetPatient() {
        System.out.println("getPatient");
        Appointment instance = new Appointment("1","1","1","1","1","1");
        int expResult = 1;
        int result = instance.getPatient();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDoctor method, of class Appointment.
     */
    @Test
    public void testGetDoctor() {
        System.out.println("getDoctor");
        Appointment instance = new Appointment("1","1","1","1","1","1");
        int expResult = 1;
        int result = instance.getDoctor();
        assertEquals(expResult, result);
    }
    
}
