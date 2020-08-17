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
public class DataTest {
    
    public DataTest() {
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
    public void testAddUser() {
        System.out.println("addUser");
        User user = new User("0","0","0","0","0","0","0","0");
        Data instance = new Data();
        instance.addUser(user);
    }

    /**
     * Test of addRequest method, of class Data.
     */
    @Test
    public void testAddRequest() {
        System.out.println("addRequest");
        Request request = new Request("0","0,0,0,0-0,0,0,0@0","0","0");
        Data instance = new Data();
        instance.addRequest(request);
    }

    /**
     * Test of addRating method, of class Data.
     */
    @Test
    public void testAddRating() {
        System.out.println("addRating");
        Rating rating = new Rating("0","0","0");
        Data instance = new Data();
        instance.addRating(rating);
    }

    /**
     * Test of addAppointment method, of class Data.
     */
    @Test
    public void testAddAppointment() {
        System.out.println("addAppointment");
        Appointment appointment = new Appointment("0","0","0","0","0","0");
        Data instance = new Data();
        instance.addAppointment(appointment);
    }

    /**
     * Test of addPatientHistory method, of class Data.
     */
    @Test
    public void testAddPatientHistory() {
        System.out.println("addPatientHistory");
        History history = new History("0","0","0");
        Data instance = new Data();
        instance.addPatientHistory(history);
    }

    /**
     * Test of addPrescription method, of class Data.
     */
    @Test
    public void testAddPrescription() {
        System.out.println("addPrescription");
        Prescription prescription = new Prescription("0","0","0","0");
        Data instance = new Data();
        instance.addPrescription(prescription);
    }

    /**
     * Test of addMedStocks method, of class Data.
     */
    @Test
    public void testAddMedStocks() {
        System.out.println("addMedStocks");
        Medicine medicine = new Medicine("0",0);
        Data instance = new Data();
        instance.addMedStocks(medicine);
    }

    /**
     * Test of addFeedback method, of class Data.
     */
    @Test
    public void testAddFeedback() {
        System.out.println("addFeedback");
        Feedback feedback = new Feedback("0","0","0");
        Data instance = new Data();
        instance.addFeedback(feedback);
    }

    /**
     * Test of removeUser method, of class Data.
     */
    @Test
    public void testRemoveUser() {
        System.out.println("removeUser");
        int target = 0;
        Data instance = new Data();
        instance.removeUser(target);
    }

    /**
     * Test of removeRequest method, of class Data.
     */
    @Test
    public void testRemoveRequest() {
        System.out.println("removeRequest");
        int target = 0;
        Data instance = new Data();
        instance.addRequest(new Request("0","0","1,1,1,1-1,1,1,1@1","0"));
        instance.removeRequest(target);
    }

    /**
     * Test of removePrescription method, of class Data.
     */
    @Test
    public void testRemovePrescription() {
        System.out.println("removePrescription");
        int target = 0;
        Data instance = new Data();
        instance.addPrescription(new Prescription("0","0","0","0"));
        instance.removePrescription(target);
    }

    /**
     * Test of searchUsers method, of class Data.
     */
    @Test
    public void testSearchUsers_int() {
        System.out.println("searchUsers");
        int target = 0;
        Data instance = new Data();
        String expResult = "John";
        User result = instance.searchUsers(target);
        assertEquals(expResult, result.getFirstName());
    }

    /**
     * Test of searchUsers method, of class Data.
     */
    @Test
    public void testSearchUsers_String() {
        System.out.println("searchUsers");
        String target = "Doe";
        Data instance = new Data();
        String expResult = "John";
        User result = instance.searchUsers(target);
        assertEquals(expResult, result.getFirstName());
    }

    /**
     * Test of lowerMeds method, of class Data.
     */
    @Test
    public void testLowerMeds() {
        System.out.println("lowerMeds");
        String med = "Test";
        int amount = 1;
        Data instance = new Data();
        instance.lowerMeds(med, amount);
    }

    /**
     * Test of raiseMeds method, of class Data.
     */
    @Test
    public void testRaiseMeds() {
        System.out.println("raiseMeds");
        String med = "Test";
        int amount = 1;
        Data instance = new Data();
        instance.raiseMeds(med, amount);
    }
    
}
