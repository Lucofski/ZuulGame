/**
 * QuitCommand Class
 * 
 * @author Alexandre Boursier and Nolan Potier
 * @version 2011.10.24
 */
public class QuitCommand extends Command
{
    /**
     * Constructor for objects of class QuitCommand
     */
    public QuitCommand() {}

    /**
     * "Quit" was entered. Check the argument to see whether
     * we really quit the game. Return true, if we should quit, false
     * otherwise.
     */
    @Override
    public boolean execute(Player player)
    {
        if(getSecondWord() == null) {
            return true;
        }
        else {
            System.out.println("Quit what ?");
            return false;
        }
    }

}