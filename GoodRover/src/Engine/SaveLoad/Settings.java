/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Engine.SaveLoad;

import java.util.HashMap;

/**
 *
 * @author gwilymnewton
 */
public abstract class Settings {
    //First pass, this should be coded to a write though hashmap when I have time
    
    private static HashMap<String,String> settings =new HashMap<String,String>() {{
    put("inventory_size","10");
    put("debug_level","5");  
    }};

    /**
     *
     * @param attribute name of the attribute required
     * @return value if found, else null
     */
public static String GetSettingString(String attribute)
{
    if (settings.keySet().contains(attribute))
    {
        return settings.get(attribute);
    }
    else
    {
        return null;
    }
}

public static int GetSettingInt(String attribute)
{
    if (settings.keySet().contains(attribute))
    {
        return Integer.valueOf(settings.get(attribute));
    }
    else
    {
        // Not a great plan, maybe throw an exception instead?
        return Integer.MIN_VALUE;
    }
}



}
