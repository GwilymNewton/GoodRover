/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Games.Zork.Locations;

import Engine.DataStructures.Action;
import Engine.DataStructures.Event;
import Engine.DataStructures.Flavor;
import Engine.DataStructures.Location;
import Games.Zork.Events.MailBox;
import java.util.ArrayList;

/**
 *
 * @author gwilymnewton
 */
public class WestofHouse extends Location {

    public WestofHouse() {
        this.name = "West of House";
        initItems();
        initFlavor();   
        initEvents();
    }
    
    private void initFlavor()
    {
    this.flavor = new Flavor();
    flavor.setFlavor(Action.Look, "This is an open field west of a white house, with a boarded front door.");
    }
    
    private void initEvents()
    {
        this.events = new ArrayList<>();
        events.add(new MailBox());
        
    }
    
    private void initItems()
    {
    this.items = new ArrayList<>();
    }
    
    
}
