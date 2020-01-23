/**
 * 
 * The Trap class allows the creation of a trap
 * - The trap door will slows the game if the user tries to go through it.
 * 
 * @author Alexandre Boursier and Nolan Potier
 * @version 2011.10.24
 * 
 */
public class Trap {
    // Check if the player fell into the trap
    private static boolean is_catched_by_trap = false;
    // Attribute dedicated to the trap room
    private static Room chosen_trap;
    // Fix a number of rooms for choosing the trap
    private final int NB_ROOM_TRAP = 6;

    /**
     * Create a random trap
     * 
     * The goal of this method is to choose amongst 
     * rooms a trap which consist in falling into a new room we can cross
     * one way. The following way brings the player to the bedroom.
     * 
     */
    public Trap()
    {
        int random = (int)(Math.random() * NB_ROOM_TRAP);
        // Select a random room
        Type trap = Type.values()[random];
        for(Room r : Game.getRooms()){
            if(r.getType().equals(trap)){
                chosen_trap = r;
            }
        }
    }

    /**
     * @return the chosen_trap
     */
    public static Room getChosen_trap() {
        return chosen_trap;
    }

    /**
     * @param chosen_trap the chosen_trap to set
     */
    public static void setChosen_trap(Room trap) {
        chosen_trap = trap;
    }

    /**
     * @return the is_catched_by_trap
     */
    public static boolean Is_catched_by_trap() {
        return is_catched_by_trap;
    }

    /**
     * @param is_catched_by_trap the is_catched_by_trap to set
     */
    public static void setIs_catched_by_trap(boolean trap) {
        is_catched_by_trap = trap;
    }
}