/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package goodrover;

import Engine.DataStructures.Command;
import Engine.DataStructures.Game;
import Engine.Interpretor.ConsoleIO;
import Engine.Debug.Debugger;
import Engine.Engine;
import Engine.Interpretor.Interpretor;
import Games.Zork.Zork;

/**
 *
 * @author gwilymnewton
 */
public class GoodRover {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        //Fast and nasty need to make an actual Param Util later
        if (args!=null & args.length>=1)
        {
            Debugger.setDebug_level(Integer.parseInt(args[0]));
        }
        
        
        
        Engine engine = new Engine(new Zork());
        
        engine.start();
        
        ConsoleIO console= ConsoleIO.getConsoleIO();
       
       while(true)
       {
       String input = console.getInput();
       Command cmd =Interpretor.searchForCommand(input);
       System.out.println(cmd);
       }
       
    }
    
}
