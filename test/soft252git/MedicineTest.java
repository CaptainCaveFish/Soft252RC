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
public class MedicineTest {
    
    public MedicineTest() {
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
     * Test of getMed method, of class Medicine.
     */
    @Test
    public void testGetMed() {
        System.out.println("getMed");
        Medicine instance = new Medicine("0",0);
        String expResult = "0";
        String result = instance.getMed();
        assertEquals(expResult, result);
    }

    /**
     * Test of getSupply method, of class Medicine.
     */
    @Test
    public void testGetSupply() {
        System.out.println("getSupply");
        Medicine instance = new Medicine("0",0);
        int expResult = 0;
        int result = instance.getSupply();
        assertEquals(expResult, result);
    }

    /**
     * Test of setSupply method, of class Medicine.
     */
    @Test
    public void testSetSupply() {
        System.out.println("setSupply");
        int value = 1;
        Medicine instance = new Medicine("0",0);
        instance.setSupply(value);
        assertEquals(1, instance.getSupply());
    }
    
}
