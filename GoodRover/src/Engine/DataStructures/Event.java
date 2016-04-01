/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Engine.DataStructures;

import java.util.HashSet;

/**
 *
 * @author gwilymnewton
 */
public class Event {
 
    protected HashSet<Command> commands;
    protected State state = State.NullState;
    protected Flavor flavor;
    protected boolean verbose = false;

    public Event() {
        commands = new HashSet<>();
        flavor = new Flavor(); 
    }
    
    
    
    public boolean isTriggered(Command cmd)
    {
        for (Command c: commands)
        {
            if (c.equals(cmd))
            {
                return true;
            }
        }
        return false;
    }
    
    public boolean unfold(GameMap map, Inventory inventory, Location local, Command cmd)
    {
        return true;
    }
    
    public String getFlavor(Command cmd)
    {
        if (this.state ==  State.NullState)
        {
        return flavor.getFlavor(cmd.getAction());
        }
        else
        {
            return flavor.getFlavor(cmd.getAction(), state);
        }    
    }

    public boolean isVerbose() {
        return verbose;
    }
    
    
    
}
