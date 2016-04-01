/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Games.Zork.Items;

import Engine.DataStructures.Action;
import Engine.DataStructures.Flavor;
import Engine.DataStructures.InventoryItem;
import Engine.DataStructures.Item;
import Engine.DataStructures.State;

/**
 *
 * @author gwilymnewton
 */
public class Leaflet  extends InventoryItem{
    
    public Leaflet() {
        super(Item.leaflet);
        this.flavor = new Flavor();
        this.flavor.setFlavor(Action.Examine,State.NullState, 
                "                          WELCOME TO ZORK\n" +
"\n" +
"    ZORK is a game of adventure, danger, and low cunning.  In it you will explore some of the most amazing territory ever seen by mortal man.  Hardened adventurers have run screaming from the terrors contained within!\n" +
"\n" +
"    In ZORK the intrepid explorer delves into the forgotten secrets of a lost labyrinth deep in the bowels of the earth, searching for vast treasures long hidden from prying eyes, treasures guarded by fearsome monsters and diabolical traps!\n" +
"\n" +
"    No PDP-10 should be without one!\n" +
"\n" +
"    ZORK was created at the MIT Laboratory for Computer Science, by Tim Anderson, Marc Blank, Bruce Daniels, and Dave Lebling.  It was inspired by the ADVENTURE game of Crowther and Woods, and the long tradition of fantasy and science fiction adventure.  ZORK was originally written in MDL (alias MUDDLE).  The current version was recreated in java by Gwilym Newton\n" +
"\n" +
"    On-line information may be available using the HELP and INFO commands (most systems).\n" +
"\n" +
"    Direct inquiries, comments, etc. by Net mail to erd@infinet.com.\n" +
"\n" +
"    (c) Copyright 1978,1979 Massachusetts Institute of Technology. \n" +
"                     All rights reserved.");
    }
    
}
