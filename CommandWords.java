import java.util.HashMap;

/**
 * This class is part of the "World of Zuul" application. "World of Zuul" is a
 * very simple, text based adventure game.
 * 
 * This class holds an enumeration of all command words known to the game. It is
 * used to recognise commands as they are typed in.
 * 
 * @author Tim Uil and Lucas Wagenaar
 * @version 2020.01.24
 */

public class CommandWords {
    // A mapping between a command word and the CommandWord
    // associated with it.
    private HashMap<String, Command> commands;

    /**
     * Constructor - initialise the command words.
     */
    public CommandWords()
    {
        commands = new HashMap<String, Command>();
        commands.put("go", new GoCommand());
        commands.put("help", new HelpCommand(this));
        commands.put("quit", new QuitCommand());
        commands.put("take", new TakeCommand());
        commands.put("use", new UseCommand());
    }

    /**
     * Given a command word, find and return the matching command object.
     * Return null if there is no command with the given name
     */
    public Command get(String word)
    {
        return commands.get(word);
    }

    /**
     * Print all valid commands 
     */
    public void showAll() 
    {
        for (Object element : commands.keySet()) {
            System.out.print(element + " - ");
        }
        System.out.println();
    }
}