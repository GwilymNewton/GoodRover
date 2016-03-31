/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Engine.DataStructures;

import java.util.ArrayList;

/**
 *
 * @author gwilymnewton
 */
public class Location {
 
    String name="null location";
    ArrayList<InventoryItem> items;
    ArrayList<Event> events;
    ArrayList<PointOfIntrest> pois;
    
    public void enter()
    {
        
    }
    
    public void exit()
    {
        
    }
    
    public boolean ProcessCommand(Command cmd, GameMap map, Inventory inventory)
    {
     switch (cmd.getAction()) 
     {
            case Go :return Go(cmd, map);
            case Pickup: return pickup(cmd, inventory);
            case Drop:  return drop(cmd, inventory); 
            default: return event(cmd, map, inventory);
     }    
    }
    
    private boolean Go(Command cmd, GameMap map)
    {
    
    return true; 
    }
    
    private boolean pickup(Command cmd, Inventory inventory)
    {
    
    return true;    
    }
    
    private boolean drop(Command cmd, Inventory inventory)
    {
    return true;    
    }
    
    private boolean event(Command cmd, GameMap map, Inventory inventory)
    {
        return true;
    }
    
    private boolean examine(Command cmd)
    {
        return true;
    }

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    

    
}
