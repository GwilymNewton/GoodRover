/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Engine.Data;

import java.util.Arrays;
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
public class InventoryTest {
    
    public InventoryTest() {
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
     * Test of AddItemtoInventory method, of class Inventory.
     */
    @Test
    public void testAddItemtoInventory() {
        System.out.println("AddItemtoInventory");
        //create inventory of size 5
        Inventory instance = new Inventory(5);
        
        // Add five axes, should work
        for (int i=0; i<5;i++)
        {
        boolean result = instance.AddItemtoInventory(Item.Axe);
        //check each add works
        assertTrue(result);
        }
        //check length & axes
        Item[] items = instance.GetItems();
        System.out.println("Instance: "+instance.toString());
        System.out.println("Items: "+Arrays.toString(items));
        //corrent length
         assertEquals(5,items.length);
        for (int i=0; i<5;i++)
        {
        assertEquals(items[i],Item.Axe);
        }
        
        //add a sixth, should fail
        boolean result = instance.AddItemtoInventory(Item.Axe);
        assertFalse(result);
    }

    /**
     * Test of RemoveItemFromInventory method, of class Inventory.
     */
    @Test
    public void testRemoveItemFromInventory() {
        System.out.println("RemoveItemFromInventory");
        //create inventory of size 5
        Inventory instance = new Inventory(5);
        
        // Add four axes, should work
        for (int i=0; i<4;i++)
        {
        boolean result = instance.AddItemtoInventory(Item.Axe);
        //check each add works
        assertTrue(result);
        }
        //Add a test item to search for.
        boolean result = instance.AddItemtoInventory(Item.Axe.TestItem);
        assertTrue(result);
        //remove it
        Item result_itm = instance.RemoveItemFromInventory(Item.TestItem);
        assertEquals(Item.TestItem,result_itm);      
        //try and remove it again
        result_itm = instance.RemoveItemFromInventory(Item.TestItem);
        assertEquals(Item.NullItem,result_itm); 
    }

    /**
     * Test of InventoryFull method, of class Inventory.
     */
    @Test
    public void testInventoryFull() {
        System.out.println("InventoryFull");
        Inventory instance = new Inventory(1);
        boolean result = instance.AddItemtoInventory(Item.Axe);
        assertTrue(instance.InventoryFull()); 
        
    }

    /**
     * Test of InventoryUsed method, of class Inventory.
     */
    @Test
    public void testInventoryUsed() {
        System.out.println("InventoryUsed");
        Inventory instance = new Inventory(2);
        assertEquals(0, instance.InventoryUsed()); 
        boolean result = instance.AddItemtoInventory(Item.Axe);
        assertEquals(1, instance.InventoryUsed());
        result = instance.AddItemtoInventory(Item.TestItem);
        assertEquals(2, instance.InventoryUsed());
        instance.RemoveItemFromInventory(Item.TestItem);
        assertEquals(1, instance.InventoryUsed());
        
    }

    /**
     * Test of GetItems method, of class Inventory.
     */
    @Test
    public void testGetItems() {
        System.out.println("GetItems");
        Inventory instance = new Inventory(2); 
        boolean result = instance.AddItemtoInventory(Item.Axe);
        result = instance.AddItemtoInventory(Item.TestItem);
        Item[] items =instance.GetItems();
        assertEquals(Item.Axe, items[0]);
        assertEquals(Item.TestItem, items[1]);
        assertEquals(2, items.length);
    }
    
}
