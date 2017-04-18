/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.ArrayList;
import java.util.Random;

public class Player
{
    private String currentRoom;
    private ArrayList<Item> inventory;
    
    public Player(String startingRoom)
    {
        currentRoom = startingRoom;
        inventory = new ArrayList<Item>();
    }
    
    public String getCurrentRoom()
    {
        return currentRoom;
    }
    
    public ArrayList<Item> getInventory()
    {
        return inventory;
    }
    
    public void addInventory(Item item)
    {
        inventory.add(item);
    }
    
    public void setCurrentRoom(String currentRoom)
    {
        this.currentRoom = currentRoom;
    }
    
    public void printInventory()
    {
        System.out.print("\nInventory:");
        for(int i = 0; i < inventory.size(); i++)
        {
            System.out.print(" " + i + " - " + inventory.get(i).getItemType());
        }
    }
}
