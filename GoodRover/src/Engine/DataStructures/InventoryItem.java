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
public class InventoryItem implements Examinable {
    
    Item name; // The Item this coridpondes too

    public InventoryItem(Item name) {
        this.name = name;
    }

    @Override
    public String Examine() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
