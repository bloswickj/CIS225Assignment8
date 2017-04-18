/**
 * Write a description of class Room here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.Random;

public class Room
{
    private float roomOccupiedChance, roomItemChance;
    private String roomName, roomDescription, northRoom, southRoom, eastRoom, westRoom;;
    private Occupant occupant;
    private Item item;
    
    public Room(float roomOccupiedChance, float roomItemChance, String roomName, String roomDescription, String northRoom, String southRoom, String eastRoom, String westRoom)
    {
        this.roomOccupiedChance = roomOccupiedChance;
        this.roomItemChance = roomItemChance;
        this.roomName = roomName;
        this.roomDescription = roomDescription;
        this.northRoom = northRoom;
        this.southRoom = southRoom;
        this.eastRoom = eastRoom;
        this.westRoom = westRoom;
        setOccupant();
        setItem();
    }
    
    private void setOccupant()
    {
        Random rand = new Random();
        float i = rand.nextFloat();
        if(i <= roomOccupiedChance)
        {
            occupant = new Occupant();
        }        
    }
      
    private void setItem()
    {
        Random rand = new Random();
        float i = rand.nextFloat();
        if(i <= roomItemChance)
        {
            item = new Item();
        }        
    }
    
    public float getRoomOccupiedChance()
    {
        return roomOccupiedChance;
    }
    
    public float getRoomItemChance()
    {
        return roomItemChance;
    }
    
    public String getRoomName()
    {
        return roomName;
    }
    
    public String getRoomDescription()
    {
        return roomDescription;
    }
    
    public String getNorthRoom()
    {
        return northRoom;
    }
    
    public String getSouthRoom()
    {
        return southRoom;
    }
    
    public String getEastRoom()
    {
        return eastRoom;
    }
    
    public String getWestRoom()
    {
        return westRoom;
    }
    
    public Occupant getOccupant()
    {
        return occupant;
    }
    
    public Item getItem()
    {
        return item;
    }
}
