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
public class UserTest {
    
    public UserTest() {
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
     * Test of getFirstName method, of class User.
     */
    @Test
    public void testGetFirstName() {
        System.out.println("getFirstName");
        User instance = new User("0","0","0","0","0","0","0","0");
        String expResult = "0";
        String result = instance.getFirstName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getLastName method, of class User.
     */
    @Test
    public void testGetLastName() {
        System.out.println("getLastName");
        User instance = new User("0","0","0","0","0","0","0","0");
        String expResult = "0";
        String result = instance.getLastName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getType method, of class User.
     */
    @Test
    public void testGetType() {
        System.out.println("getType");
        User instance = new User("0","0","0","0","0","0","0","0");
        String expResult = "0";
        String result = instance.getType();
        assertEquals(expResult, result);
    }

    /**
     * Test of getID method, of class User.
     */
    @Test
    public void testGetID() {
        System.out.println("getID");
        User instance = new User("0","0","0","0","0","0","0","0");
        int expResult = 0;
        int result = instance.getID();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPassWord method, of class User.
     */
    @Test
    public void testGetPassWord() {
        System.out.println("getPassWord");
        User instance = new User("0","0","0","0","0","0","0","0");
        String expResult = "0";
        String result = instance.getPassWord();
        assertEquals(expResult, result);
    }

    /**
     * Test of getAdress method, of class User.
     */
    @Test
    public void testGetAdress() {
        System.out.println("getAdress");
        User instance = new User("0","0","0","0","0","0","0","0");
        String expResult = "0";
        String result = instance.getAdress();
        assertEquals(expResult, result);
    }

    /**
     * Test of getAge method, of class User.
     */
    @Test
    public void testGetAge() {
        System.out.println("getAge");
        User instance = new User("0","0","0","0","0","0","0","0");
        int expResult = 0;
        int result = instance.getAge();
        assertEquals(expResult, result);
    }

    /**
     * Test of getGender method, of class User.
     */
    @Test
    public void testGetGender() {
        System.out.println("getGender");
        User instance = new User("0","0","0","0","0","0","0","0");
        String expResult = "0";
        String result = instance.getGender();
        assertEquals(expResult, result);
    }
    
}
