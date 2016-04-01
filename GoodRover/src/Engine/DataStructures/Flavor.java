/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Engine.DataStructures;

import Engine.Debug.Debugger;
import java.util.HashMap;

/**
 *
 * @author gwilymnewton
 */
public class Flavor {
    
    HashMap<FlavorKey,String> flavor_map;

    public Flavor() {
        flavor_map = new HashMap<>();
    }
    
public String getFlavor(Action a)
{
    FlavorKey key = new FlavorKey(a,State.NullState);
    Debugger.debug(5, "Getting Flavor with key "+key);
    return flavor_map.get(key);
}

public String setFlavor(Action a,String s)
{
    FlavorKey key = new FlavorKey(a,State.NullState);
    Debugger.debug(5, "Setting Flavor with key "+key);
    return flavor_map.put(key, s);
}

public String getFlavor(Action a,State s)
{
    FlavorKey key = new FlavorKey(a,s);
    return flavor_map.get(key);
}

public String setFlavor(Action a,State str,String s)
{
    FlavorKey key = new FlavorKey(a,str);
    
    return flavor_map.put(key, s);
}
    
}
