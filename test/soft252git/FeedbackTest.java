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
public class FeedbackTest {
    
    public FeedbackTest() {
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
     * Test of getAdmin method, of class Feedback.
     */
    @Test
    public void testGetAdmin() {
        System.out.println("getAdmin");
        Feedback instance = new Feedback("0","0","0");
        int expResult = 0;
        int result = instance.getAdmin();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDoctor method, of class Feedback.
     */
    @Test
    public void testGetDoctor() {
        System.out.println("getDoctor");
        Feedback instance = new Feedback("0","0","0");
        int expResult = 0;
        int result = instance.getDoctor();
        assertEquals(expResult, result);
    }

    /**
     * Test of getNote method, of class Feedback.
     */
    @Test
    public void testGetNote() {
        System.out.println("getNote");
        Feedback instance = new Feedback("0","0","0");
        String expResult = "0";
        String result = instance.getNote();
        assertEquals(expResult, result);
    }
    
}
