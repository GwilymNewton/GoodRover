/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Engine.Interpretor;

import Engine.Data.Action;
import Engine.Data.Item;
import Engine.Data.Target;

/**
 *
 * @author gwilymnewton
 */
public class Interpretor {
    
    eq
public static Action isAction(String text) 
{
  if (text != null) 
  {
    for (Action a: Action.values()) 
    {
      if (text.equalsIgnoreCase(a.toString())) 
      {
        return a;
      }
    }
  }
  return null;
}

public static Item isItem(String text) 
{
  if (text != null) 
  {
    for (Item i: Item.values()) 
    {
      if (text.equalsIgnoreCase(i.toString())) 
      {
        return i;
      }
    }
  }
  return null;
}
    
public static Target isTarget(String text) 
{
  if (text != null) 
  {
    for (Target t: Target.values()) 
    {
      if (text.equalsIgnoreCase(t.toString())) 
      {
        return t;
      }
    }
  }
  return null;
}    
    
}
