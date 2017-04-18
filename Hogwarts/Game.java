/**
 * Write a description of class Game here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
import java.io.File;

public class Game
{
    private float randomRoomChance;
    private boolean gameOver;
    private File roomsFile;
    private ArrayList<Room> rooms;
    private Player player;
    
    public Game()throws java.io.FileNotFoundException
    {
        randomRoomChance = .2f;
        roomsFile = new File("roomsfile.csv");
        rooms = new ArrayList<Room>();
        player = new Player("The Great Hall");
        populateRooms();
    }
    
    public void gameLoop()
    {
        gameOver = false;
        Scanner scan = new Scanner(System.in);
        System.out.print("\nWelcome to Hogwarts!");
        while(!gameOver)
        {
            printCurrentRoomDetails();
            System.out.print("\nCommand: ");
            String playerInput = scan.nextLine();
            parsePlayerInput(playerInput);
                        
        }
    }
    
    private void parsePlayerInput(String playerInput)
    {
        String[] playerInputs = playerInput.split("\\s+");
        Room currentRoom = null;
        for(Room room : rooms)
        {
            if(room.getRoomName().equals(player.getCurrentRoom()))
            {
                currentRoom = room;
            }
        }
        switch (playerInputs[0].toUpperCase())
        {
            case "GO":
                if(playerInputs.length > 1)
                {                
                    switch(playerInputs[1].toUpperCase())
                    {
                        case "NORTH":
                            if(currentRoom.getNorthRoom().equals("none"))
                            {
                                System.out.print("\nThere is nothing to the North.");
                            }
                            else
                            {
                                setCurrentRoom(currentRoom.getNorthRoom());
                            }
                            break;
                        case "SOUTH":
                            if(currentRoom.getSouthRoom().equals("none"))
                            {
                                System.out.print("\nThere is nothing to the South.");
                            }
                            else
                            {
                                setCurrentRoom(currentRoom.getSouthRoom());
                            }
                            break;
                        case "EAST":
                            if(currentRoom.getEastRoom().equals("none"))
                            {
                                System.out.print("\nThere is nothing to the East.");
                            }
                            else
                            {
                                setCurrentRoom(currentRoom.getEastRoom());
                            }
                            break;
                        case "WEST":
                            if(currentRoom.getWestRoom().equals("none"))
                            {
                                System.out.print("\nThere is nothing to the West.");
                            }
                            else
                            {
                                setCurrentRoom(currentRoom.getWestRoom());
                            }
                            break;
                        default:
                            System.out.print("\nThat is not a valid direction to go.");
                            break;
                    }
                }
                else
                {
                    System.out.print("\nThat is not a valid direction to go.");
                }
                break;                
            case "TAKE":
                if(currentRoom.getItem() != null && !currentRoom.getItem().getIsTaken())
                {
                    String itemName;
                    StringBuilder builder = new StringBuilder();
                    for(int i = 1; i < playerInputs.length; i++)
                    {
                        if(i > 1)
                        {
                            builder.append(" ");
                        }
                        builder.append(playerInputs[i]);
                    }
                    itemName = builder.toString();
                    if(itemName.toUpperCase().equals(currentRoom.getItem().getItemType().toUpperCase()))
                    {
                        System.out.print("\n" + currentRoom.getItem().getItemType() + " taken.");
                        currentRoom.getItem().setIsTaken(true);
                        player.addInventory(currentRoom.getItem());
                    }
                }
                else
                {
                    System.out.print("\nThere is no such item to take.");
                }
                break;
            case "INVENTORY":
                player.printInventory();
                break;
            default:
                System.out.print("\nThat is not a valid command.");
                break;
            case "QUIT":
                System.out.print("\n\tThanks for playing...");
                gameOver = true;
                break;
        }
    }
    
    private void setCurrentRoom(String room)
    {
        Random rand = new Random();
        float f = rand.nextFloat();
        if(f <= randomRoomChance)
        {
            Random rand2 = new Random();
            int i = rand2.nextInt(rooms.size() -1);
            player.setCurrentRoom(rooms.get(i).getRoomName());
            System.out.print("\nSome sorcery has caused you to be moved to a different part of the castle!");
        }
        else
        {
            player.setCurrentRoom(room);
        }        
    }

    private void printCurrentRoomDetails()
    {
        Room currentRoom = null;
        for(Room room : rooms)
        {
            if(room.getRoomName().equals(player.getCurrentRoom()))
            {
                currentRoom = room;
            }
        }
        System.out.print("\nYou are in " + currentRoom.getRoomName() + ". " + currentRoom.getRoomDescription() + " ");
        if(currentRoom.getItem() != null && !currentRoom.getItem().getIsTaken())
        {
            System.out.print("There is a " + currentRoom.getItem().getItemType() + " here. ");
        }
        if(currentRoom.getOccupant() != null)
        {
            System.out.print(currentRoom.getOccupant().getOccupantName() + " is here. ");
        }
        if(!currentRoom.getNorthRoom().equals("none"))
        {
            System.out.print("To the North is " + currentRoom.getNorthRoom() + ". ");
        }
        if(!currentRoom.getSouthRoom().equals("none"))
        {
            System.out.print("To the South is " + currentRoom.getSouthRoom() + ". ");
        }
        if(!currentRoom.getEastRoom().equals("none"))
        {
            System.out.print("To the East is " + currentRoom.getEastRoom() + ". ");
        }
        if(!currentRoom.getWestRoom().equals("none"))
        {
            System.out.print("To the West is " + currentRoom.getWestRoom() + ". ");
        } 
    }
    
    private void populateRooms() throws java.io.FileNotFoundException
    {
        ArrayList<String> lines = new ArrayList<String>();
        try
        {
            Scanner scan = new Scanner(roomsFile);
            while(scan.hasNext())
            {
                lines.add(scan.nextLine());
            }          
        }
        catch(java.io.FileNotFoundException ex)
        {
            System.out.print("\nFile not found.");
        }
        for(int i = 0; i < lines.size(); i++)
        {
            String[] lines2 = lines.get(i).split(",");
            float roomOccupiedChance = Float.parseFloat(lines2[0]);
            float roomItemChance = Float.parseFloat(lines2[1]);
            String roomName = lines2[2];
            String roomDescription = lines2[3];
            String northRoom = lines2[4];
            String southRoom = lines2[5];
            String eastRoom = lines2[6];
            String westRoom = lines2[7];
            rooms.add(new Room(roomOccupiedChance, roomItemChance, roomName, roomDescription, northRoom, southRoom, eastRoom, westRoom));
        }  
    } 
}


