/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Engine.DataStructures;

import Engine.DataStructures.ItemState;

/**
 *
 * @author gwilymnewton
 */
public class InventoryItem implements Examinable {
    
    protected Item name; // The Item this coridpondes too
    protected State state = State.NullState;
    protected Flavor flavor;
    
    public InventoryItem(Item name) {
        this.name = name;
    }

    public boolean checkItem(Item item)
    {
        return item.equals(this.name);
    }

    public Item getName() {
        return name;
    }

    public State getState() {
        return state;
    }

    
    
    
    @Override
    public String Examine() 
    {

        if (this.state ==  State.NullState)
        {
        return flavor.getFlavor(Action.Examine);
        }
        else
        {
            return flavor.getFlavor(Action.Examine, state);
        }    
    }
    
}
