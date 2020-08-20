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
public class PrescriptionTest {
    
    public PrescriptionTest() {
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
     * Test of getID method, of class Prescription.
     */
    @Test
    public void testGetID() {
        System.out.println("getID");
        Prescription instance = new Prescription("0","0","0","0","0");
        int expResult = 0;
        int result = instance.getID();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPatient method, of class Prescription.
     */
    @Test
    public void testGetPatient() {
        System.out.println("getPatient");
        Prescription instance = new Prescription("0","0","0","0","0");
        int expResult = 0;
        int result = instance.getPatient();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDose method, of class Prescription.
     */
    @Test
    public void testGetDose() {
        System.out.println("getDose");
        Prescription instance = new Prescription("0","0","0","0","0");
        int expResult = 0;
        int result = instance.getDose();
        assertEquals(expResult, result);
    }

    /**
     * Test of getMedicine method, of class Prescription.
     */
    @Test
    public void testGetMedicine() {
        System.out.println("getMedicine");
        Prescription instance = new Prescription("0","0","0","0","0");
        String expResult = "0";
        String result = instance.getMedicine();
        assertEquals(expResult, result);
    }
    
}
