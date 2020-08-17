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
public class RatingTest {
    
    public RatingTest() {
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
     * Test of getWriter method, of class Rating.
     */
    @Test
    public void testGetWriter() {
        System.out.println("getWriter");
        Rating instance = new Rating("0","0","0");
        int expResult = 0;
        int result = instance.getWriter();
        assertEquals(expResult, result);
    }

    /**
     * Test of getSubject method, of class Rating.
     */
    @Test
    public void testGetSubject() {
        System.out.println("getSubject");
        Rating instance = new Rating("0","0","0");
        int expResult = 0;
        int result = instance.getSubject();
        assertEquals(expResult, result);
    }

    /**
     * Test of getComment method, of class Rating.
     */
    @Test
    public void testGetComment() {
        System.out.println("getComment");
        Rating instance = new Rating("0","0","0");
        String expResult = "0";
        String result = instance.getComment();
        assertEquals(expResult, result);
    }
    
}
