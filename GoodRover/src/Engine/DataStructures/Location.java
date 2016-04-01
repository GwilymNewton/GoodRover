/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Engine.DataStructures;

import Engine.Debug.Debugger;
import java.util.ArrayList;
import java.util.Iterator;

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
        //check for events fist
        boolean rtn = event(cmd, map, inventory);
     switch (cmd.getAction()) 
     {
            case Go :return Go(cmd, map);
            case Pickup: return pickup(cmd, inventory);
            case Drop:  return drop(cmd, inventory); 
            case Look: return look(cmd,inventory);
            default: return rtn;
     }    
    }
    
    private boolean Go(Command cmd, GameMap map)
    {
    
    return true; 
    }
    
    private boolean pickup(Command cmd, Inventory inventory)
    {
        Debugger.debug(4, "Processing picup Command");    
        if ((cmd.action.equals(Action.Pickup))
                &&!(cmd.getItem().equals(Item.NullItem))
                )
        {
            Debugger.debug(5, "Action, and Item AOK, seaching for item");
            Iterator<InventoryItem> iter = items.iterator();
            while(iter.hasNext())
            {
               InventoryItem item = iter.next();
               if (item.getName().equals(cmd.getItem()))
               {
                   Debugger.debug(5, "Item Found");
                   iter.remove();
                   inventory.AddItemtoInventory(item);
                   cmd.setResult("Taken.");
                   return true;
               }
            }
            Debugger.debug(4, "Item not found");
            cmd.setResult("You can't see any such thing.");
            return false;
        }
        else
        {
            
            //TODO deal with failure
        }
    
    
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
   
    public void removeItem(InventoryItem item)
   {
       this.items.remove(item);
   }
    
    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    

    
}
