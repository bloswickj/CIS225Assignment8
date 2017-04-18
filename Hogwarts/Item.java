/**
 * Write a description of class Item here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.Random;
public class Item
{
    private String itemType;
    private boolean isTaken;
    
    public Item()
    {
        setItemType();
        isTaken = false;
    }
    
    private void setItemType()
    {
        Random rand = new Random();
        int i = rand.nextInt(5);
        switch (i)
        {
            case 0:
                itemType = "Enchanted Coin";
                break;
            case 1:
                itemType = "Invisibility Cloak";
                break;  
            case 2:
                itemType = "Elder Wand";
                break;
            case 3:
                itemType = "Resurrection Stone";
                break;
            case 4:
                itemType = "Probity Probe";
                break;
        }
    }
    
    public String getItemType()
    {
        return itemType;
    }
    
    public boolean getIsTaken()
    {
        return isTaken;
    }
    
    public void setIsTaken(boolean isTaken)
    {
        this.isTaken = isTaken;
    }
}
