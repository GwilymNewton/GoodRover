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
public class FlavorKey {
    
    private Action act;
    private State state;

    public FlavorKey(Action act, State state) {
        this.act = act;
        this.state = state;
    }

    public Action getAct() {
        return act;
    }

    public void setAct(Action act) {
        this.act = act;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    @Override
    public boolean equals(Object obj) {
        if (!obj.getClass().equals(this.getClass()))
        {
            return false;
        }
        FlavorKey other = (FlavorKey)obj;
        if (!other.getAct().equals(this.getAct()))
        {
            return false;
        }
        if (!other.getState().equals(this.getState()))
        {
            return false;
        }
        
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 1;
    hash = hash * 31 + (this.act == null ? 0 : this.act.hashCode());
    hash = hash * 31 + (this.state == null ? 0 : this.state.hashCode());
    
    return hash;
    }

    
    
    
}
