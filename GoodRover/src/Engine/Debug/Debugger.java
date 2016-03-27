/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Engine.Debug;

/**
 *
 * @author gwilymnewton
 */
public class Debugger {

    /**
     * 0= nothing 
     * 5 = everything
     */
    public static int debug_level =0;  
//
    
    /**
     *
     * @param level Level of debuging at which to show this data
     * @param text  What to output
     */
    public static void debug(int level, String text)
{
    if (level <= debug_level)
    {
        System.out.println(text);
    }
}

    /**
     *
     * @param debug_level The system wide level of debug output.
     */
    public static void setDebug_level(int debug_level) {
        Debugger.debug_level = debug_level;
    }
    
    

    
}
