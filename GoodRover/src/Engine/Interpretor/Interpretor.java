/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Engine.Interpretor;

import Engine.Data.Action;
import Engine.Data.Command;
import Engine.Data.Item;
import Engine.Data.Target;
import static Engine.Debug.Debugger.debug;
import java.util.regex.PatternSyntaxException;

/**
 *
 * @author gwilymnewton
 */
public class Interpretor {
    
    
public static Command searchForCommand(String input)
{
    String[] wordArray = new String[20]; //Array to hold input text, 20 word 
    //limit need to make sure this is caught
    Command cmd = new Command(Action.NullAction, Item.NullItem, Target.NullTarget);
    debug(1,"New command, raw text = '"+input+"'");
    try 
    {
        wordArray = input.split("\\s+");
    } 
    catch (PatternSyntaxException ex) 
    {
    }

    if (wordArray != null)
    {
        for (String word : wordArray)
        {
         debug(2,"Searching for match on word = '"+word+"'");    
            Action a = isAction(word); // Attempts to match the word to an Action
            Item i = isItem(word);// Attempts to match the word to an Item
            Target t = isTarget(word); // Attempts to match the word to an Target      
            // This crazy expression says a word is either a Action, a Target or and Item, but never more than one.
            boolean word_valid = ((a !=null) && (i==null) && t == null) || 
                            ((i !=null) && (a==null) && t == null) || 
                            ((t !=null) && (a==null) && i == null);
            if (word_valid)
            {
                if (a!=null && cmd.getAction().equals(Action.NullAction))
                {
                    //Action is empty and we have a replacement
                    debug(2,"Setting Action to "+a.toString());
                    cmd.setAction(a);
                }
                else if(i!=null && cmd.getItem().equals(Item.NullItem))
                {
                    // It was an Item instead, and the cmd item is empty
                    debug(2,"Setting Item to "+i.toString());
                    cmd.setItem(i);
                }
                else if(t!=null && cmd.getTarget().equals(Target.NullTarget))
                {
                    // It was an Target instead, and the cmd item is empty
                    debug(2,"Setting Target to "+t.toString());
                    cmd.setTarget(t);
                }
                else
                {
                    debug(1,"Encondered CmdOverrideException on word "+word);
                    // If we got here, we had an Action/Item/Target, but the command already contained one
                    // i.e Go hit troll with axe 
                    //Time to throw an exception
                }
            }
            else if(a==null && i==null && t==null)
            {
              //useless word
              debug(2,"'"+word+"' is semanticly null");   
            }
            else
            {
                debug(1,"Encondered DuelMeaningException on word "+word);
                //If we got in here the word was registered as a both an Action/Item/Target. 
                //This is our bad, spank the writers
                //throw double meaning excption
            }
        }
    }
    return cmd;
}
    
private static Action isAction(String text) 
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

private static Item isItem(String text) 
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
    
private static Target isTarget(String text) 
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
