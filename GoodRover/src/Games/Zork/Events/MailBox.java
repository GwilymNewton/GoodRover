/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Games.Zork.Events;

import Engine.DataStructures.Action;
import Engine.DataStructures.Command;
import Engine.DataStructures.Event;
import Engine.DataStructures.Flavor;
import Engine.DataStructures.GameMap;
import Engine.DataStructures.Inventory;
import Engine.DataStructures.Item;
import Engine.DataStructures.Location;
import Engine.DataStructures.State;
import Engine.DataStructures.Target;
import Engine.Debug.Debugger;
import Games.Zork.Items.Leaflet;

/**
 *
 * @author gwilymnewton
 */
public class MailBox extends Event {
    
    Leaflet leaflet = new Leaflet();

    public MailBox() 
    {
        this.commands.add(new Command(Action.Open, Item.NullItem, Target.Mailbox));
        this.commands.add(new Command(Action.Close, Item.NullItem, Target.Mailbox));
        this.commands.add(new Command(Action.Pickup, Item.leaflet, Target.NullTarget));
        this.state = State.ClosedContainsLeaflet;
        this.flavor = new Flavor();
        this.flavor.setFlavor(Action.Look,State.ClosedContainsLeaflet, "There is a small mailbox here.");
        this.flavor.setFlavor(Action.Look,State.Closed, "There is a small mailbox here.");
        this.flavor.setFlavor(Action.Look,State.OpenContainsLeaflet, "The mailbox contains:\n" +" A small leaflet");
        this.flavor.setFlavor(Action.Look,State.Open, "There is a small mailbox here.");
        this.verbose = true;
    }

    @Override
    public boolean unfold(GameMap map, Inventory inventory, Location local, Command cmd) 
    {
        Debugger.debug(5, "Unfolding Mailbox, Action="+cmd.getAction()+" State="+this.state);
    switch (cmd.getAction())
    {
        case Open: return unfoldOpen(map,inventory,local,cmd);
        case Pickup: return unfoldPickup(map,inventory,local,cmd);
        case Close: return unfoldClose(map,inventory,local,cmd);
        default :  return false;       
    }
    }

    private boolean unfoldOpen(GameMap map, Inventory inventory, Location local, Command cmd) {
            //mailbox has been opened.
        if (this.state.equals(State.ClosedContainsLeaflet))
        {
        this.state = State.OpenContainsLeaflet;
        local.addItem(leaflet);
        cmd.setResult("You open the mailbox, revealing a small leaflet.");
        return true;
        }
        else if (this.state.equals(State.Closed))
        {
            this.state = State.Open;
            cmd.setResult("You open the mailbox.");
            return true;    
        }
        else
        {
            cmd.setResult("That's already open.");
            return false;
        }
    }

    private boolean unfoldClose(GameMap map, Inventory inventory, Location local, Command cmd) {
        if (this.state.equals(State.Open))
        {
        this.state =  State.Closed;
        cmd.setResult("You close the mailbox.");
        return true;
        }
        else if (this.state.equals(State.OpenContainsLeaflet))
        {
        this.state =  State.ClosedContainsLeaflet;
        local.removeItem(leaflet);
        cmd.setResult("You close the mailbox.");
        return true;
        }   
        
        else
        {
            cmd.setResult("That's already closed.");
            return false;
        }
    }

    private boolean unfoldPickup(GameMap map, Inventory inventory, Location local, Command cmd) 
    {
        if (this.state.equals(State.OpenContainsLeaflet))
        {
            this.state= State.Open;
            return true;
        }
        else
        {
            Debugger.debug(3, "leaflet removed, when mailbox closed. Code buggy");
            return false;
        }
    }

    
    
}
