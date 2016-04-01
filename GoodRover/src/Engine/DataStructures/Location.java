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
    protected ArrayList<InventoryItem> items; //what you can take with you
    protected ArrayList<Event> events; //what you can interact with
    protected ArrayList<PointOfIntrest> pois; //what you can look at but not touch
    protected Flavor flavor; // general flavor text of location
    
    
    
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
        for (Event e : events)
        {
            if (e.isTriggered(cmd))
            {
                Debugger.debug(4, "Event "+e.getClass().getName()+" Tiggered");
                return e.unfold(map, inventory, this, cmd);
            }
        }
        return false;
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
        output.append("\n");
        System.out.println(events);
        for (Event e : events)
        {
            if (e.verbose)
            {
                output.append(e.getFlavor(cmd));
                output.append("\n");
            }
        }
        
        cmd.setResult(output.toString());
        return true;
    }

   public void addItem(InventoryItem item)
   {
       this.items.add(item);
   }
    
    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    

    
}
