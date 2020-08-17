/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soft252git;

import java.awt.event.ActionEvent;
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
public class AccountVeiwerTest {
   
    
    public AccountVeiwerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        
        
    }
    
    @Test
    public void testconstructor(){
        Data data = new Data();
        AccountVeiwer subject = new AccountVeiwer(data,null,null);
        assertNotNull(subject);
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

    
}
