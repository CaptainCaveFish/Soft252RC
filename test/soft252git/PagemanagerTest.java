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
public class PagemanagerTest {
    
    public PagemanagerTest() {
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
    
     @Test
    public void testconstructor(){
        Data data = new Data();
        Pagemanager subject = new Pagemanager(data);
        assertNotNull(subject);
    }
    /**
     * Test of setUser method, of class Pagemanager.
     */
    @Test
    public void testSetUser() {
        System.out.println("setUser");
        User u = new User("0","0","0","0","0","0","0","0");
        Data data = new Data();
        Pagemanager instance = new Pagemanager(data);
        instance.setUser(u);
        // Expected output in Console:"User data has been corrupted"
    }
    
}
