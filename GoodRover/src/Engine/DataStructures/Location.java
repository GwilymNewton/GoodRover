/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Engine.DataStructures;

import Engine.Debug.Debugger;
import java.util.ArrayList;

/**
 *
 * @author gwilymnewton
 */
public class Location {
 
    protected String name="null location";
    protected ArrayList<InventoryItem> items;
    protected ArrayList<Event> events;
    protected ArrayList<PointOfIntrest> pois;
    protected Flavor flavor;
    
    
    
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
            case Look: return look(cmd,inventory);
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
    
    private boolean look(Command cmd, Inventory inventory)
    {
        Debugger.debug(5, "Builing \"Look\" output in "+this.getClass().getName());
        StringBuilder output = new StringBuilder();
        output.append(name);
        output.append("\n\n");
        output.append(flavor.getFlavor(Action.Look));
        
        cmd.setResult(output.toString());
        return true;
    }

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    

    
}
