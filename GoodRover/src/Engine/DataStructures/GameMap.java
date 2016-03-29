/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Engine.DataStructures;

/**
 *
 * @author gwilymnewton
 */
public class GameMap {
            private int heightY = 64; //default 
            private int widthX = 64; //default 
            private Location[][] game_map = new Location[heightY][widthX];
            private int locationX = 0;
            private int locationY =0;

    public GameMap() 
    {
    }

    public GameMap(int height, int width) 
    {
        this.heightY = height;
        this.widthX = width ;  
        game_map = new Location[width][height];
    }
    
    public boolean SetLocation(Location local, int x, int y)
    {
     if ((x<0 || x>=widthX) || (y<0 || y>=heightY) || (local == null))
     {
         //throw out of bounds exception
         return false;
     }
     
     game_map[x][y] = local;
     return true;
     
    }
        
    public Location setXY(int x,int y)
    {
        if ((x>0 && x<widthX) && (y>0 && y<heightY))
        {
            //set location
            locationX =x;
            locationY =y;
            return getCurrentLocation();
        }
        else
        {
            return null;
        }
                
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
