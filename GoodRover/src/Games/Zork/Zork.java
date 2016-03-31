/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Games.Zork;

import static Engine.DataStructures.Action.Inventory;
import Engine.DataStructures.Game.Game;
import Engine.DataStructures.GameMap;
import Engine.DataStructures.GameState;
import Engine.DataStructures.Inventory;
import Engine.DataStructures.InventoryItem;
import Engine.DataStructures.Item;
import Games.Zork.Locations.WestofHouse;

/**
 *
 * @author gwilymnewton
 */
public  class Zork implements Game{

    private static int mapX=64;// in the real file we should load thesse
    private static int mapY=64;// in the real file we should load thesse
    private static int inventory_size=10;
   
    @Override
    public GameState getInitState() {
        
        return initState();
    }
    
    private static GameState initState()
    {
    GameMap map = initMap();   
    Inventory start_in = initInventory();
    GameState state = new GameState(map, start_in);
    return state;
    }
    
    private static  GameMap initMap()
    {
    GameMap map = new GameMap(mapX,mapY);
    map.setXY(31, 31);
    map.SetLocation(new WestofHouse(), 31, 31);
    
    return  map;
    }
    
    private static Inventory initInventory()
    {
    Inventory inventory = new Inventory(inventory_size);    
    inventory.AddItemtoInventory(new InventoryItem(Item.Whisle));
    return inventory;
    }
    
}
