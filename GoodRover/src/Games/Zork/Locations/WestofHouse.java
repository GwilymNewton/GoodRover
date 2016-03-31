/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Games.Zork.Locations;

import Engine.DataStructures.Action;
import Engine.DataStructures.Flavor;
import Engine.DataStructures.Location;

/**
 *
 * @author gwilymnewton
 */
public class WestofHouse extends Location {

    public WestofHouse() {
        this.name = "West of House";
        initFlavor();        
    }
    
    private void initFlavor()
    {
    this.flavor = new Flavor();
    flavor.setFlavor(Action.Look, "This is an open field west of a white house, with a boarded front door.");
    }
    
    
}
