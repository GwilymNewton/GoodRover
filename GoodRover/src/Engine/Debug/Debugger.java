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

public static final int debug_level =5;  
//0= nothing 5 = evethingthing
    
public static void debug(int level, String text)
{
    if (level <= debug_level)
    {
        System.out.println(text);
    }
}

    
}
