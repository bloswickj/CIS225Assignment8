/**
 * Write a description of class Occupant here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.Random;

public class Occupant
{
    private String occupantName;

    public Occupant()
    {
        setOccupantName();
    }
    
    private void setOccupantName()
    {
        Random rand = new Random();
        int i = rand.nextInt(10);
        switch (i)
        {
            case 0:
                occupantName = "Harry Potter";
                break;
            case 1:
                occupantName = "Ron Weasley";
                break;  
            case 2:
                occupantName = "Hermione Granger";
                break;
            case 3:
                occupantName = "Severus Snape";
                break;
            case 4:
                occupantName = "Albus Dumbledore";
                break;
            case 5:
                occupantName = "Dobby";
                break;
            case 6:
                occupantName = "Draco Malfoy";
                break;
            case 7:
                occupantName = "Newt Scamander";
                break;
            case 8:
                occupantName = "Neville Longbottom";
                break;
            case 9:
                occupantName = "Ginny Weasley";
                break;
        }
    }
    public String getOccupantName()
    {
        return occupantName;
    }
}

