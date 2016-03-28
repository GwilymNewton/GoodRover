/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Engine.Data;

/**
 *
 * @author gwilymnewton
 */
public class GameMap {
            private int height = 64; //default 
            private int width = 64; //default 
            private Location[][] game_map = new Location[height][width];
            private int locationX = 0;
            private int locationY =0;

    public GameMap() 
    {
    }

    public GameMap(int height, int width) 
    {
        this.height = height;
        this.width = width ;  
        game_map = new Location[height][width];
    }
    
    public void SetLocation(Location local, int x, int y)
    {
     if (x>0 && x<width)
     {
         //throw out of bounds exception
     }
     if (y>0 && y<height)
     {
         //throw out of bounds exception
     }
     if (local != null)
     {
         // throw null pointer exception
     }
     
     game_map[x][y] = local;
     
    }
            
    public int[] getCurrentXY ()
    {
    int[] xy = {locationX,locationY}  ;
    return xy;
    }
    
    public Location getCurrentLocation ()
    {
    return game_map[locationX][locationY];    
    }
}
