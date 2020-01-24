/**
 * This class is part of the "World of Zuul" application. "World of Zuul" is a
 * very simple, text based adventure game.
 * 
 * This class holds information about a command that was issued by the user. A
 * command currently consists of two parts: a CommandWord and a string (for
 * example, if the command was "take map", then the two parts are TAKE and
 * "map").
 * 
 * The way this is used is: Commands are already checked for being valid command
 * words. If the user entered an invalid command (a word that is not known) then
 * the CommandWord is UNKNOWN.
 * 
 * If the command had only one word, then the second word is <null>.
 * 
 * @author Tim Uil and Lucas Wagenaar
 * @version 2020.01.24
 */

public abstract class Command {
    private String secondWord;

    /**
     * Create a command object. 
     * 
     * The command word should be null to tell the command is UNKNOWN
     */
    public Command()
    {
        secondWord = null;
    }

    /**
     * Return the second word of this command. If no
     * second word was entered, the result is null.
     */
    public String getSecondWord()
    {
        return secondWord;
    }

    /**
     * Check whether a second word was entered for this 
     * command.
     */
    public boolean hasSecondWord()
    {
        return secondWord != null;
    }

    /**
     * Define the second word of thie command
     */
    public void setSecondWord(String secondWord)
    {
        this.secondWord = secondWord;
    }

    /**
     * Execute the current command. 
     * A flag is returned indicating :
     *  
     * @return True, if game should exit; false otherwise.
     */
    public abstract boolean execute(Player player);
}