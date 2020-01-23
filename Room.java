import java.util.ArrayList;
import java.util.HashMap;

/**
 * Class Room - a room in an adventure game.
 * 
 * This class is part of the "World of Zuul" application. "World of Zuul" is a
 * very simple, text based adventure game.
 * 
 * A "Room" represents one location in the scenery of the game. It is connected
 * to other rooms via exits. For each existing exit, the room stores a reference
 * to the neighboring room.
 * 
 * @author Michael Kolling and David J. Barnes and Alexandre Boursier and Nolan Potier
 * @version 2011.10.28
 */

public class Room {
    private Type nom;
    private String description;
    //private HashMap<String, Room> exits; // stores exits of this room.
    private ArrayList<Door> doors;
    // The HashMap is used to map the door names of the room with
    private HashMap<String, Room> doorsHash;
    private Character person;
    private Item item;
    /**
     * Create a room described "description". Initially, it has no exits.
     * "description" is something like "a kitchen" or "an open court yard".
     * 
     * @param description
     *            The room's description.
     */
    public Room(String description, Type type) {
        this.nom = type;
        this.description = description;
        doorsHash = new HashMap<String, Room>();
        doors = new ArrayList<Door>();
        // add the room to the dictionnary
        Game.addRoom(this);
    }

    /**
     * Define an exit from this room.
     * 
     * @param direction
     *            The direction of the exit.
     * @param neighbor
     *            The room to which the exit leads.
     */
    /*public void setExit(String direction, Room neighbor) {
        exits.put(direction, neighbor);
    }*/

    public void setDoor(String doorName, Room neighbor, Boolean isLocked){
        Door door = new Door(doorName);
        door.setLock(isLocked);
        getDoors().add(door);
        doorsHash.put(doorName, neighbor);
    }

    /**
     * @return The short description of the room (the one that was defined in
     *         the constructor).
     */
    public String getShortDescription() {
        return description;
    }

    /**
     * Return a description of the room in the form: You are in the kitchen.
     * Exits: north west
     * 
     * @return A long description of this room
     */
    public String getLongDescription() {
        return "You are " + description + ".\n" + getExitString();
    }

    /**
     * Return a string describing the room's exits, for example
     * "Exits: north west".
     * 
     * @return Details of the room's exits.
     */
    private String getExitString() {
        String returnString = "Exits:";
        for(Door door : getDoors()) {
            returnString += " " + door.getName();
        }
        return returnString;
    }

    /**
     * Return the room that is reached if we go from this room in direction
     * "direction". If there is no room in that direction, return null.
     * 
     * @param direction
     *            The exit's direction.
     * @return The room in the given direction.
     */
    public Room getExit(String direction) {
        return doorsHash.get(direction);
    }

    /**
     * Get the Door of the room
     */
    public Door getDoor(String doorName){
        for (Door door : getDoors()){
            if (door.getName().equals(doorName)){
                return door;
            }
        }
        return null;
    }

    /**
     * Add a character to the room
     * @param person
     */
    public void addCharacter(Character person) {
        this.person = person;
    }

    /**
     * 
     * @return the character of the room
     */
    public Character getCharacter() {
        return this.person;
    }    

    /**
     * @return the name of the room
     */
    public Type getType() {
        return nom;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Add a item to the room 
     * @param item
     */
    public void addItem(Item item) {
        this.item = item;
    }

    /**
     * Get the item.
     * @return item of the room
     */
    public Item getItem() {
        return item;
    }

    /**
     * Take the item of room.
     * @return item of the room
     */
    public Item takeItem() {
        Item res = item;
        item = null;
        return res;
    }

    /**
     * @return the doors
     */
    public ArrayList<Door> getDoors() {
        return doors;
    }

    /**
     * @param doors the doors to set
     */
    public void setDoors(ArrayList<Door> doors) {
        this.doors = doors;
    }

}