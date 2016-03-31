/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Engine.DataStructures;

import java.util.HashMap;

/**
 *
 * @author gwilymnewton
 */
public class Flavor {
    
    HashMap<Action,String> flavor_map;

    public Flavor() {
        flavor_map = new HashMap<>();
    }
    
public String getFlavor(Action a)
{
    return flavor_map.get(a);
}

public String setFlavor(Action a,String s)
{
    return flavor_map.put(a, s);
}
    
}
