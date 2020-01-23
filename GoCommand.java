/**
 * GoCommand Class
 * 
 * @author Alexandre Boursier and Nolan Potier
 * @version 2011.10.24
 */
public class GoCommand extends Command
{
    /**
     * Constructor for objects of class GoCommand
     */
    public GoCommand() {}

    /** 
     * Try to go to one direction. If there is an exit, enter the new
     * room, otherwise print an error message. 
     * Returns 'false' when games continue, 'true' otherwise;
     */
    @Override
    public boolean execute(Player player)
    {
        if(hasSecondWord()) {
            String direction = getSecondWord();
            boolean decision = player.goRoom(direction);
            return decision;
        }
        else {
            // if there is no second word, we don't know where to go...
            System.out.println("Go where?");
        }
        return false;
    }
}