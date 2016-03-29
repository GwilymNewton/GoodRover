/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Engine.DataStructures;

import Engine.SaveLoad.Settings;

/**
 *
 * @author gwilymnewton
 */
public class GameState {
    private GameMap game_map;
    private Inventory inventory;

    public GameState(GameMap game_map) {
        this.game_map = game_map;
        
        int inventory_size = Settings.GetSettingInt("inventory_size");
        if (inventory_size >0)
        {
            inventory = new Inventory(inventory_size);
        }
        else
        {
            //TODO: throw
        }
        
    }
    
    
    
}
