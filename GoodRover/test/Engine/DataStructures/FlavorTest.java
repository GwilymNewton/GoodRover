/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Engine.DataStructures;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author gwilymnewton
 */
public class FlavorTest {
    
    public FlavorTest() {
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
     * Test of getFlavor method, of class Flavor.
     */
    @Test
    public void testGetFlavor_Action() {
        System.out.println("getFlavor");
        Action a = Action.Go;
        Flavor instance = new Flavor();
        
        String expResult = "Go";
        instance.setFlavor(a, expResult);
        String result = instance.getFlavor(a);
        
        assertEquals(expResult, result);
    }

    /**
     * Test of setFlavor method, of class Flavor.
     */
    @Test
    public void testSetFlavor_Action_String() {
        System.out.println("setFlavor");
        Action a = Action.Go;
        String s = "Go";
        Flavor instance = new Flavor();
        String expResult = "Go";
        String result = instance.setFlavor(a, s);
        assertEquals(null, result);
        result = instance.setFlavor(a, s);
        assertEquals(expResult, result);
    }

    /**
     * Test of getFlavor method, of class Flavor.
     */
    @Test
    public void testGetFlavor_Action_State() {
      System.out.println("getFlavor");
        Action a = Action.Go;
        State s = State.Open;
        Flavor instance = new Flavor();
        
        String expResult = "Go";
        instance.setFlavor(a,s, expResult);
        String result = instance.getFlavor(a,s);
        
        assertEquals(expResult, result);
    }

    /**
     * Test of setFlavor method, of class Flavor.
     */
    @Test
    public void testSetFlavor_3args() {
        System.out.println("setFlavor");
        Action a = Action.Go;
        State s = State.Open;
        String str = "Go";
        Flavor instance = new Flavor();
        String expResult = "Go";
        String result = instance.setFlavor(a,s, str);
        assertEquals(null, result);
        result = instance.setFlavor(a,s, str);
        assertEquals(expResult, result);
    }
    
}
