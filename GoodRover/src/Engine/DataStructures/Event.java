/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Engine.DataStructures;

/**
 *
 * @author gwilymnewton
 */
public class Event {
 
    protected Command command;
    protected State state = State.NullState;
    protected Flavor flavor;
    protected boolean verbose = false;
    
    
    public boolean isTriggered(Command cmd)
    {
    return (cmd.equals(this.command));
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
