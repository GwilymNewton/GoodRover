/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Engine.Interpretor;

import Engine.DataStructures.Action;
import Engine.DataStructures.Command;
import Engine.DataStructures.Item;
import Engine.DataStructures.Target;
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
public class InterpretorTest {
    
    public InterpretorTest() {
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
     * Test of searchForCommand method, of class Interpretor.
     */
    @Test
    public void testSearchForCommand() {
        System.out.println("searchForCommand");
        
        //Good data, Action Target
        String input = "Go West";
        Command expResult = new Command(Action.Go,Item.NullItem,Target.West);
        Command result = Interpretor.searchForCommand(input);
        assertEquals(expResult, result);
        
        //Good data, Action only
        input = " Inventory";
        expResult = new Command(Action.Inventory,Item.NullItem,Target.NullTarget);
        result = Interpretor.searchForCommand(input);
        assertEquals(expResult, result);

        //Good data, Action, Item
        input = "Drop Axe";
        expResult = new Command(Action.Drop,Item.Axe,Target.NullTarget);
        result = Interpretor.searchForCommand(input);
        assertEquals(expResult, result);
        
        //Good data, Action, Item, Target
        input = "Hit TestTarget with Axe";
        expResult = new Command(Action.Hit,Item.Axe,Target.TestTarget);
        result = Interpretor.searchForCommand(input);
        assertEquals(expResult, result);
       
    }
    
    
}
