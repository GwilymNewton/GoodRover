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
public class Command {
    Action action = Action.NullAction;
    Item item = Item.NullItem;
    Target target = Target.NullTarget;
    String result = "";

    public Command(Action action, Item item, Target target) {
        this.action = action;
        this.item = item;
        this.target = target;
    }

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Target getTarget() {
        return target;
    }

    public void setTarget(Target target) {
        this.target = target;
    }

    @Override
    public String toString() {
        return "Action=" +action.toString()+" Item=" +item.toString()+ " Target= " +target.toString();
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Command other = (Command) obj;
        if (this.action != other.action) {
            return false;
        }
        if (this.item != other.item) {
            return false;
        }
        if (this.target != other.target) {
            return false;
        }
        return true;
    }
    
    
    
}
