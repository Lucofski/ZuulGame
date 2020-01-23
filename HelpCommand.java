/**
 * HelpCommand Class
 * 
 * @author Alexandre Boursier and Nolan Potier
 * @version 2011.10.24
 */
public class HelpCommand extends Command
{
    private CommandWords commandWords;

    /**
     * Constructor for objects of class HelpCommand
     */
    public HelpCommand(CommandWords words)
    {
        commandWords = words;
    }

    /**
     * Print out some help information. Here we print some stupid, 
     * cryptic message and a list of the command words.
     * Returns always false.
     */
    @Override
    public boolean execute(Player player)
    {
        System.out.println("You are in the world of ZUUL no way to get out instead of finding the EXIT DOOR ! MUHAHAHA");
        System.out.println(player.getCurrentRoom().getLongDescription());
        System.out.println();
        System.out.println("Your command words are:");
        commandWords.showAll();
        return false;
    }
}