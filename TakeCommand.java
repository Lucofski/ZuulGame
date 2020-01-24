/**
 * TakeCommand Class
 * 
 * @author Alexandre Boursier and Nolan Potier
 * @version 2020.01.24
 */
public class TakeCommand extends Command
{
    /**
     * Constructor for objects of class GoCommand
     */
    public TakeCommand() {}

    /**
     * Try to take an item if present into the room
     * We have to be in the good room
     * Returns always 'false'.
     */
    @Override
    public boolean execute(Player player)
    {
        if(player.getCurrentRoom().getItem() == null) {
            System.out.println("There is nothing to take there !");
        }
        else if (!hasSecondWord()) {
            System.out.println("take what?");
        } 
        else if (! getSecondWord().equals(player.getCurrentRoom().getItem().getName().toLowerCase())){
            System.out.println("There is nothing like that to take !");
        }
        else
        {
            System.out.println("You've just a found " + player.getCurrentRoom().getItem().getName()  + "! :) ");
            System.out.println(player.getCurrentRoom().getItem().getDescription());

            player.addItem(player.getCurrentRoom().takeItem());
        }
        return false;
    }
}