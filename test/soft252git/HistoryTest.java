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
public class HistoryTest {
    
    public HistoryTest() {
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
     * Test of getPatientID method, of class History.
     */
    @Test
    public void testGetPatientID() {
        System.out.println("getPatientID");
        History instance = new History("0","0","0");
        int expResult = 0;
        int result = instance.getPatientID();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDoctorID method, of class History.
     */
    @Test
    public void testGetDoctorID() {
        System.out.println("getDoctorID");
        History instance = new History("0","0","0");
        int expResult = 0;
        int result = instance.getDoctorID();
        assertEquals(expResult, result);
    }

    /**
     * Test of getNote method, of class History.
     */
    @Test
    public void testGetNote() {
        System.out.println("getNote");
        History instance = new History("0","0","0");
        String expResult = "0";
        String result = instance.getNote();
        assertEquals(expResult, result);
    }
    
}
