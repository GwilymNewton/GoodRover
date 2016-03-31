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

    public GameState(GameMap game_map, Inventory inventory) {
        this.game_map = game_map;
        this.inventory = inventory;
        //sanity check these files
        
    }

    public GameMap getGame_map() {
        return game_map;
    }

    public Inventory getInventory() {
        return inventory;
    }
    
    public Location getCurrentLocation()
    {
        return game_map.getCurrentLocation();
    }
    
}
