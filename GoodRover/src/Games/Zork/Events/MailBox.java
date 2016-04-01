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
import Games.Zork.Items.Leaflet;

/**
 *
 * @author gwilymnewton
 */
public class MailBox extends Event {

    public MailBox() 
    {
        this.command = new Command(Action.Open, Item.NullItem, Target.Mailbox);
        this.state = State.Closed;
        this.flavor = new Flavor();
        this.flavor.setFlavor(Action.Look,State.Closed, "There is a small mailbox here.");
        this.flavor.setFlavor(Action.Look,State.OpenContainsLeaflet, "The mailbox contains:\n" +" A small leaflet");
        this.flavor.setFlavor(Action.Look,State.Open, "There is a small mailbox here.");
        this.verbose = true;
    }

    @Override
    public boolean unfold(GameMap map, Inventory inventory, Location local, Command cmd) {
        //mailbox has been opened.
        if (this.state.equals(State.Closed))
        {
        this.state = State.OpenContainsLeaflet;
        local.addItem(new Leaflet());
        cmd.setResult("You open the mailbox, revealing a small leaflet.");
        return true;
        }
        else
        {
            cmd.setResult("That's already open.");
            return false;
        }
    }

    
    
}
