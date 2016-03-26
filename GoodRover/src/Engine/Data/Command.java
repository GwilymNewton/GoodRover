/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Engine.Data;

/**
 *
 * @author gwilymnewton
 */
public class Command {
    Action action = Action.NullAction;
    Item item = Item.NullItem;
    Target target = Target.NullTarget;

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
    
    
}
