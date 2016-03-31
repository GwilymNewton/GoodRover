/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Engine;

import Engine.DataStructures.Command;
import Engine.DataStructures.Game.Game;
import Engine.DataStructures.GameMap;
import Engine.DataStructures.GameState;
import Engine.DataStructures.Inventory;
import Engine.Debug.Debugger;
import Engine.Interpretor.ConsoleIO;
import Engine.Interpretor.Interpretor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gwilymnewton
 */
public class Engine {
    GameState state;
    ConsoleIO console;
    
    
    public Engine(Game game) {

            GameState loaded_state = game.getInitState();
            
            if (loaded_state !=null)
            {
               Debugger.debug(1, "Load sucessful");
               this.state= loaded_state;
            }
            else
            {
                 Debugger.debug(1, "Loading failed");
            }
            

        console = ConsoleIO.getConsoleIO();
    }
    
   public void start()
   {
       
       while(true)
       {
       Debugger.debug(2, "Fetching a new command");    
       String input = console.getInput();
       Command cmd =Interpretor.searchForCommand(input);
       Debugger.debug(2, "New command interperated as "+cmd);
       Debugger.debug(2, "Processing Command");
       processCommand(cmd);
       //TODO check command has not failed
       Debugger.debug(2, "Result ="+cmd.getResult());
       console.outputText(cmd.getResult());       
       }    
   }
            
    private boolean processCommand(Command cmd)
    {
        {
         switch (cmd.getAction()) 
         {
            //untilty commands save exit etc....
             case Test_Util: return utilityCommand(cmd);
            //inventory commands Use, eat etc....
             case Test_Inventory: return inventoryCommand(cmd); 
             case Inventory: return inventoryCommand(cmd); 
            // default to location  
             default: return state.getCurrentLocation().ProcessCommand(cmd, state.getGame_map(), state.getInventory());
         }    
        }  
    }
    
    private boolean utilityCommand(Command cmd)
    {
        return true;
    }
    
    private boolean inventoryCommand(Command cmd)
    {
    Debugger.debug(2, "Processing as Inventory Command");
    switch (cmd.getAction()) 
         {
             case Inventory: return state.getInventory().ProcessInventoryCommand(cmd);
             default: return false;
         }
    }
}
