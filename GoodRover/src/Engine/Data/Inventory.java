/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Engine.Data;

import Engine.Debug.Debugger;
import static Engine.Debug.Debugger.debug;
import java.util.Arrays;

/**
 *
 * @author gwilymnewton
 */
public class Inventory {

private Item[] item_list;
int head;

    /**
     *
     * @param size
     */
    public Inventory(int size) {
        
        Debugger.debug(3, "Setting up Invetory, size ="+size+" head="+head);
        this.item_list = new Item[size];
        Arrays.fill(item_list, Item.NullItem);
        head =-1;
    }

    /**
     *
     * @param item Item to all
     * @return True if item was added, false if the add failed.
     */
    public boolean AddItemtoInventory(Item item)
    {
        Debugger.debug(3, "Adding "+item +" to inventory, head="+head);
        //checks if full size 5 01234 l-1 =4
        if (head <  (item_list.length-1) )
        {
            item_list[++head]= item; 
            Debugger.debug(5, "Added "+item +" to inventory, head="+head);
            return true;
        }
        else
        {
            Debugger.debug(5, "Failed to add "+item +"to inventory, head="+head);
            return false;
        }
    }
    
    /**
     *
     * @param item Item to be removed
     * @return NullItem if item not found, else returns item
     */
    public Item RemoveItemFromInventory(Item item)
    {
        //1) find item
        Debugger.debug(3, "Removeing "+item +" from inventory, head="+head);
        Debugger.debug(4, "Removeing "+item +" from inventory, list="+this.toString());
        int location =-1;
        for (int i=0; i<= head ; i++)
        {
           if (item_list[i].equals(item))
           {
               //found
               location =i;
               Debugger.debug(5, "Removeing "+item +" found at location="+location);
           }
        }
        if (location==-1)
        {
            //we did not find the item
            return Item.NullItem;
        }
        //2) Remove Item & shuffle inventory
        for (int j=location; j<head;j++)
        {
        item_list[j]=item_list[j+1];    
        }
        //3) update head
        item_list[head--]=Item.NullItem;
        return item;
    }
    
    public boolean InventoryFull()
    {
        return (head == (item_list.length-1)); 
    }
    
    public int InventoryUsed()
    {
        return (head+1);
    }
    
    public Item[] GetItems()
    {
        if (head !=0)
        {
            return Arrays.copyOfRange(item_list, 0, head+1);
        }
        else
        {
            return null;
        }
    }
    
    @Override
    public String toString() {
        return Arrays.toString(item_list);
    }
    
    


    
}
