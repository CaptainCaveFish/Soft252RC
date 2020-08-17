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
public class PageTest {
    
    public PageTest() {
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
     * Test of closeChild method, of class Page.
     */
    @Test
    public void testCloseChild() {
        System.out.println("closeChild");
        Page instance = new PageImpl();
        instance.closeChild();
    }

    /**
     * Test of setChild method, of class Page.
     */
    @Test
    public void testSetChild() {
        System.out.println("setChild");
        Page target = new PageImpl();
        Page instance = new PageImpl();
        instance.setChild(target);
    }

    public class PageImpl extends Page {

        public PageImpl() {
            super("", null, null, null);
        }
    }
    
}
