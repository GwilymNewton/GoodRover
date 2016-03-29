/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Engine.Data;

import Engine.DataStructures.Location;
import Engine.DataStructures.GameMap;
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
public class GameMapTest {
    
    public GameMapTest() {
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
     * Test of SetLocation method, of class GameMap.
     */
    @Test
    public void testSetLocation() {
        System.out.println("SetLocation");
        Location local = new Location();
        GameMap instance = new GameMap(10,10);
        assertTrue(instance.SetLocation(local, 0, 0));
        assertTrue(instance.SetLocation(local, 5, 5));
        assertTrue(instance.SetLocation(local, 9, 9));
        assertFalse(instance.SetLocation(local, 10, 10));
        assertFalse(instance.SetLocation(null, 0, 0));
    }

    /**
     * Test of getCurrentXY method, of class GameMap.
     */
    @Test
    public void testGetCurrentXY() {
        System.out.println("getCurrentXY");
        GameMap instance = new GameMap(10,10);
        instance.setXY(0, 0);
        assertArrayEquals(new int[]{0,0}, instance.getCurrentXY());
        instance.setXY(5, 5);
        assertArrayEquals(new int[]{5,5}, instance.getCurrentXY());
        instance.setXY(9, 9);
        assertArrayEquals(new int[]{9,9}, instance.getCurrentXY());
    }

    /**
     * Test of getCurrentLocation method, of class GameMap.
     */
    @Test
    public void testGetCurrentLocation() {
        System.out.println("getCurrentLocation");
        GameMap instance = new GameMap(10,10);
        Location expResult = null;
        instance.SetLocation(expResult, 5, 5);
        
        instance.setXY(5, 5);
        
        Location result = instance.getCurrentLocation();
        assertEquals(expResult, result);
    }

    /**
     * Test of setXY method, of class GameMap.
     */
    @Test
    public void testSetXY() {
        System.out.println("setXY");
        GameMap instance = new GameMap(10,10);
        instance.setXY(0, 0);
        assertArrayEquals(new int[]{0,0}, instance.getCurrentXY());
        instance.setXY(5, 5);
        assertArrayEquals(new int[]{5,5}, instance.getCurrentXY());
        instance.setXY(9, 9);
        assertArrayEquals(new int[]{9,9}, instance.getCurrentXY());
        
        Location local = new Location();
        instance.SetLocation(local, 4, 4);
        assertEquals(local,instance.setXY(4, 4));
        
        assertEquals(null,instance.setXY(10, 10));
        
    }
    
}
