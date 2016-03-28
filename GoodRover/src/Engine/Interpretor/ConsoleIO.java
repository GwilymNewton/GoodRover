/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Engine.Interpretor;

import java.io.Console;
import java.util.Scanner;

/**
 *
 * @author gwilymnewton
 */
public class ConsoleIO {
    
    private static final ConsoleIO instance = new ConsoleIO();

    private ConsoleIO() {
    }
            
   public static ConsoleIO getConsoleIO()
   {
       return instance;
   }

   public void outputText(String text)
   {
   System.out.print(text);
   }
 
   public String getInput()
   {
        Scanner scanner = new Scanner(System.in);
        System.out.print(">");
        return Sanitize(scanner.nextLine());
   }

   private String Sanitize(String str)
   {
   String output = str.replaceAll("[^a-zA-Z ]", "");
   output = output.toLowerCase();
   return output;
   }

}
