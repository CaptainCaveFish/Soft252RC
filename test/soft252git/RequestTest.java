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
public class RequestTest {
    
    public RequestTest() {
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
     * Test of getUserID method, of class Request.
     */
    @Test
    public void testGetUserID() {
        System.out.println("getUserID");
        Request instance = new Request("0","0","0","0");
        int expResult = 0;
        int result = instance.getUserID();
        assertEquals(expResult, result);
    }

    /**
     * Test of getType method, of class Request.
     */
    @Test
    public void testGetType() {
        System.out.println("getType");
        Request instance = new Request("0","0","0","0");
        String expResult = "0";
        String result = instance.getType();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDetails method, of class Request.
     */
    @Test
    public void testGetDetails() {
        System.out.println("getDetails");
        Request instance = new Request("0","0","0","0");
        String expResult = "0";
        String result = instance.getDetails();
        assertEquals(expResult, result);
    }

    /**
     * Test of getRequestID method, of class Request.
     */
    @Test
    public void testGetRequestID() {
        System.out.println("getRequestID");
        Request instance = new Request("0","0","0","0");
        int expResult = 0;
        int result = instance.getRequestID();
        assertEquals(expResult, result);
    }
    
}
