import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * This class is the main class of the "Zuul" application.
 * "Zuul" is a very simple, text based adventure game. Users can walk
 * around some scenery. That's all. It should really be extended to make it more
 * interesting!
 * 
 * To play this game, create an instance of this class and call the "play"
 * method.
 * 
 * This main class creates and initializes all the others: it creates all rooms,
 * creates the parser and starts the game. It also evaluates and executes the
 * commands that the parser returns.
 * 
 * - A level can be chosen, which determine the number of moves a player can have.
 * - The trap door will slows the game if the user tries to go through it.
 * - To access the last door, the player must take the key placed in the "DELIVERY_ROOM"
 * - A beamer can be used to teleport the player wherever he had chosen
 * - The room "TOILETS" randomly teleports the player into another.
 * - To win the game, you have to reach the room "OUTSIDE".
 * 
 * @author Michael Kolling and David J. Barnes and Alexandre Boursier and Nolan Potier
 * @version 2011.10.24
 */

public class Game {
    private Parser parser;
    private static Player player;
    // Count the number of current number of moves
    private static int numberOfMoves;
    // Fix a limit to the number of moves
    private static int limitOfMoves;
    // Fix a number of rooms for choosing the teleport room
    private static final int NB_ROOM_TELEPORT = 8;
    // Build a list which contains all the current rooms of the game
    private static ArrayList<Room> rooms;

    private static Room randomRoom;
    private static Room beamerRoom;
    private HashMap<String, Item> items;
    private ArrayList<Door> doors;

    private Room outside;
    private Room topaz_temple;
    private Room ruby_temple;
    private Room diamond_temple;
    private Room teleporter;
    private Room jungle;
    private Room emerald_temple;
    private Room trap_room;
    private Room sunstone_temple;
    private Room amethyst_temple;
    private Room landing_room;
    private Room victory;

    /**
     * Create the game and initialize its internal map.
     */
    public Game() {
        rooms = new ArrayList<Room>();
        items = new HashMap<String, Item>();  
        doors = new ArrayList<Door>();
        numberOfMoves = 0;

        createItems();
        createDoors();        
        setPlayer(new Player());
        createRooms();
        setRoomsDoors();
        addItemsToRooms();
        new Trap();
    }

    /**
     * Create all the rooms and link their exits together.
     * Create a random trap door to make the game harder.
     * 
     */
    private void createRooms() {
        // Create the rooms
        outside = new Room("outside\n in front of you stands an amazing temple\nQuickly go for it" , Type.OUTSIDE);
        topaz_temple = new Room("in the topaz temple\nOver there is a sign\n 'Hello pilsmaister you're trapped and there is only one way out good luck!!'", Type.TOPAZ_TEMPLE);
        ruby_temple = new Room("in the ruby temple.\nOh shit that gorilla on the north looks hungry. I can't passed him" , Type.RUBY_TEMPLE);
        diamond_temple = new Room("in the diamond temple.\nWhat is that on the west it's looks weird.... a teleport or something", Type.DIAMOND_TEMPLE);
        teleporter = new Room("You are telported to this room with four teleports and a ladder going up and down.\nOn a sign stands: 'Choose wisley it could help you'", Type.TELEPORTER);
        jungle = new Room("in the jungle. There is a banana on the ground.\nWhy are all that monkey's in the trees watching me. It is freaking me out", Type.JUNGLE);
        emerald_temple = new Room("in the emerald temple.\nOh no not a second gorilla but now on the east", Type.EMERALD_TEMPLE);
        trap_room = new Room("in an empty room with a opening to the east and on the west it's again that gorilla." , Type.TRAP_ROOM);
        sunstone_temple = new Room("in the sunstone temple.\nIt's pretty here isn't it??\n You can stay here forever if you want or if you don't want ", Type.SUNSTONE_TEMPLE);
        amethyst_temple = new Room("in the amethyst_temple." , Type.AMETHYST_TEMPLE);
        landing_room = new Room("in the landing room.\nIt doesn't feel good here.. I need to go. Quick!!", Type.LANDING_ROOM);
        victory = new Room("You made it!.", Type.VICTORY);
        
        //Create character
        Character Bubbles = new Character("oe-oe-OE-oe", "monkey translater: Go quikly you are running out of time!!");

        amethyst_temple.addCharacter(Bubbles);

        // start game in the bedroom
        getPlayer().setCurrentRoom(outside); 
        randomRoom = amethyst_temple;
    }
    
    /**
     * Initialise items
     */
    private void createItems() {
        Item Banana;
        Banana = new Item("Banana", "Maybe the gorilla wants a banana");
        items.put(Banana.getName().toLowerCase(), Banana);
    }

    /**
     * Initialise room doors and respective locks
     */
    private void setRoomsDoors()
    {        
        // Initialise room exits
        outside.setDoor("north", topaz_temple, false);

        topaz_temple.setDoor("east", ruby_temple, false);
        topaz_temple.setDoor("south", outside, false);

        ruby_temple.setDoor("north", emerald_temple, true);
        ruby_temple.setDoor("east", jungle, false);
        ruby_temple.setDoor("south", diamond_temple, false);
        
        jungle.setDoor("west", ruby_temple, false);

        diamond_temple.setDoor("west", teleporter, false);
        diamond_temple.setDoor("north", ruby_temple, false);
   
        emerald_temple.setDoor("east", trap_room, true);
        emerald_temple.setDoor("south", ruby_temple, false);
        emerald_temple.setDoor("west", amethyst_temple, false);     

        amethyst_temple.setDoor("east", emerald_temple, false);
        
        trap_room.setDoor("east", landing_room, false);
        trap_room.setDoor("west", emerald_temple, true);

        landing_room.setDoor("north", sunstone_temple, false);
        landing_room.setDoor("west", trap_room, false);
        
        sunstone_temple.setDoor("south", landing_room, false);
        sunstone_temple.setDoor("up", victory, false);
        
        teleporter.setDoor("north", outside, false);
        teleporter.setDoor("east", jungle, false);
        teleporter.setDoor("south", amethyst_temple, false);
        teleporter.setDoor("west", emerald_temple, false);
        teleporter.setDoor("up", topaz_temple, false);
        teleporter.setDoor("down", sunstone_temple, false);
    }

    /**
     * Create the Doors for the game.
     */
    private void createDoors(){
        Door north, east, south, west,up, down;

        north = new Door("north");
        east = new Door("east");
        south = new Door("south");
        west = new Door("west");
        // To get out of the trap
        up = new Door("up");
        down = new Door("down");

        //add each door to doors collection
        doors.add(north);
        doors.add(east);
        doors.add(south);
        doors.add(west);
        doors.add(up);
        doors.add(down);
    }

    /**
     * Add items to the rooms
     */
    private void addItemsToRooms(){
        jungle.addItem(items.get("banana"));
    }

    /**
     * Adding a room to the dictionary
     * @param r
     */
    public static void addRoom(Room r){
        rooms.add(r);
    }   

    /**
     * Main play routine. Loops until end of play.
     * 
     */
    public void play() {

        printWelcome();

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.
        boolean finished = false;
        while(! finished) {
            Command command = parser.getCommand();
            if(command == null) {
                System.out.println("I don't understand...");
            } else {
                finished = command.execute(getPlayer());
            }
        }
    }

    /**
     * Print out the opening message for the player. 
     * New form of time limit : a level is asked at the beginning
     * of the game defined by the maximum tolerated number of moves.
     * @return 
     */
    private void printWelcome() {
        System.out.println();
        System.out.println("Welcome to Zuul!");
        
        chooseLevel();

        System.out.println("Type help if you need help.");
        System.out.println();
        System.out.println(getPlayer().getCurrentRoom().getLongDescription());

        // Instantiate a parser which will read the command words
        parser = new Parser();
    }

    /**
     * Choosing the level of the game :
     * - Easy is for beginners 
     * - Medium brings a little bit more challenge
     * - Hard is the "no-mistake way"
     * 
     */
    private void chooseLevel()
    {
        // Choosing a level (asking to the user through the terminal)
        Scanner reader = new Scanner(System.in);
        System.out.println("Please choose a level : Easy 20 moves(0) - Medium 16 moves(1) - Hard 14 moves (2)");
        // Find the chosen level and alter the number of moves accorfing to the chosen one
        try {
            switch (reader.nextInt()) {
            case 0:
                limitOfMoves = 20;
                System.out.println("You don't trust yourself? A bit harder next time! - Number of moves : " + limitOfMoves);
                break;
            case 1:
                limitOfMoves = 16;
                System.out.println("Medium? alright let's go! - Number of moves : " + limitOfMoves);
                break;
            case 2:
                limitOfMoves = 14;
                System.out.println("Yess finaly a real gamer!  - Number of moves : " + limitOfMoves);
                break;
            default:
                limitOfMoves = 20;
                System.out.println("Unkown command - Default level : Easy - Number of moves : " + limitOfMoves);
                break;
            }
        } catch(Exception e){
            limitOfMoves = 20;
            System.out.println("Unkown command - Default level : Easy - Number of moves : " + limitOfMoves);
        }
    }

    /**
     * Counting the current move of the player
     * @return false if the player has executed too many moves, true otherwise
     */
    public static boolean countMove(){
        // Count a move
        numberOfMoves++;

        // Give some informations concerning the number of moves
        if (numberOfMoves < limitOfMoves) {
            System.out.println("Current number of moves : " + numberOfMoves);
            System.out.println("Moves left : " + (limitOfMoves - numberOfMoves));
            return false;
            // Ending the game if the number of moves is reached
        } else {
            System.out.println("You have reached the maximum number of moves");
            System.out.println("By the way, GAME OVER ! ");
            System.out.println();
            System.out.println();
            return true;
        }
    }

    /**
     * Randomly transported into one of the other rooms.
     */
    public static void goRandomRoom(){

        int random = (int)(Math.random() * NB_ROOM_TELEPORT);
        // Select a random room
        Type teleport = Type.values()[random];
        for(Room r : rooms){
            if(r.getType().equals(teleport)){
                getPlayer().setCurrentRoom(r);
            }
        }
        System.out.println("\n ------- You are teleported to a random room. -------\n");
    }

    /**
     * @return the numberOfMoves
     */
    public int getNumberOfMoves() {
        return numberOfMoves;
    }

    /**
     * @return the limitOfMoves
     */
    public int getLimitOfMoves() {
        return limitOfMoves;
    }

    /**
     * @return the rooms
     */
    public static ArrayList<Room> getRooms() {
        return rooms;
    }

    /**
     * @param limitOfMoves the limitOfMoves to set
     */
    public void setLimitOfMoves(int lom) {
        limitOfMoves = lom;
    }

    /**
     * @return the randomRoom
     */
    public static Room getRandomRoom() {
        return randomRoom;
    }

    /**
     * @param randomRoom the randomRoom to set
     */
    public static void setRandomRoom(Room random) {
        randomRoom = random;
    }

    /**
     * @return the player
     */
    public static Player getPlayer() {
        return player;
    }

    /**
     * @param player the player to set
     */
    public static void setPlayer(Player player) {
        Game.player = player;
    }

}