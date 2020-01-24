import java.util.HashMap;

/**
 * This class represents players in the game. 
 * Each player has a current location.
 * Externalisation of the current room 
 * 
 * @author Tim Uil and Lucas Wagenaar
 * @version 2020.01.24
 */
public class Player
{
    private Room currentRoom;
    private HashMap<String, Item> items;

    /**
     * Constructor for objects of class Player
     */
    public Player()
    {
        currentRoom = null;
        items = new HashMap<String, Item>();
    }

    /**
     * Return the current room for this player.
     */
    public Room getCurrentRoom()
    {
        return currentRoom;
    }

    /**
     * Set the current room for this player.
     */
    public void setCurrentRoom(Room room)
    {
        currentRoom = room;
    }

    /**
     * Try to go to one direction. If there is an exit, enter the new room,
     * otherwise print an error message.
     * 
     * New form of time limit : Each time a player uses the command "GO" 
     * with a good given direction (ex : go east), it is counted as a move
     * 
     * All cases are checked in order to prevent the player from going outside without
     * the key, or without having opened the door, etc.
     * 
     * If the number of moves equals to the limit number of moves,
     *  the player loses the game.
     *  
     */
    public boolean goRoom(String direction) 
    {

        // Try to leave current room.
        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null) {
            System.out.println("There is no door in that direction.");
            boolean decision = Game.countMove();     
            return decision;
        }
        if(currentRoom.getDoor(direction).isLocked()) 
        {
            if(items.get("Banana")==null) {
                System.out.println("That gorilla won't let you pass! You will need a banana to lure it away!");
                boolean decision = Game.countMove();     
                return decision;
            }
            else 
            {
                System.out.println("You have to open the door to get out of there!");
                return false;
            }
        }
        else 
        {
            setCurrentRoom(nextRoom);
            //Check if there are Character in the room
            //
            Character person = currentRoom.getCharacter(); 
            if(person != null && !person.hasSpoken()) {
                System.out.println("\nThere is a Monkey in this temple...\n" + person.getName() + ": " + person.getDialogue());
                person.setHasSpoken(true);
            }
            //Check that is randomRoom
            //
            if(currentRoom.equals(Game.getRandomRoom())) {
                Game.goRandomRoom();
            }

            // Check if the player is in the trap room and if he has already been there
            // Yes : the game continues normally
            // No  : he falls into the trap
            if (!Trap.Is_catched_by_trap() && currentRoom.getType().equals(Trap.getChosen_trap().getType()))
            {
                System.out.println();
                System.out.println("----You travel through the portal and enter a new room -----------");
                System.out.println();

                for(Room r : Game.getRooms()){
                    if(r.getType().equals(Type.TRAP_ROOM)){
                        setCurrentRoom(r);
                    }
                }       
                Trap.setIs_catched_by_trap(true);
            }

            // Check if the nextroom is the final exit
            if (currentRoom.getType().equals(Type.VICTORY)) {
                System.out.println("The outside checkpoint has been reached ! ");
                System.out.println("You have won the game, well done Pilsmaister! ;)");
                System.out.println();
                System.out.println();
                return true;
            }
            System.out.println(currentRoom.getLongDescription());
        }
        boolean decision = Game.countMove(); 
        return decision;
    }

    /**
     * @return the items
     */
    public HashMap<String, Item> getItems() 
    {
        return items;
    }

    /**
     * @param items the items to set
     */
    public void setItems(HashMap<String, Item> items) 
    {
        this.items = items;
    }
    
    /**
     * Add a item to inventory of player.
     * @param item
     */
    public void addItem(Item item) 
    {
        items.put(item.getName().toLowerCase(), item);
    }

}