/**
 * This class is part of the "World of NolsPotLex" application. "World of NolsPotLex" is a
 * very simple, text based adventure game.
 * 
 * A "Character" represents a person in the scenery of the game. He can give you some indications.
 * 
 * @author Alexandre Boursier & Nolan Potier
 * @version 2011.10.25
 */
public class Character {

    private String name;
    private String dialogue;
    private boolean hasSpoken;

    /**
     * Create a character object. First and second words must be supplied.
     * 
     * @param name
     *          The name of the character 
     * @param dialogue
     *          The tip he will give to the player  
     */
    public Character(String name, String dialogue) {
        this.name = name;
        this.dialogue = dialogue;
        this.hasSpoken = false;
    }

    /**
     * @return the name of character
     */
    public String getName() {
        return name;
    }

    /**
     * Define the name of character
     * @param name
     *           the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the dialogue
     */
    public String getDialogue() {
        return dialogue;
    }

    /**
     * Define the dialogue of character when meeting
     * 
     * @param dialogue 
     *          the dialogue to set
     */
    public void setDialogue(String dialogue) {
        this.dialogue = dialogue;
    }

    /**
     * Check if character has spoken or not
     * 
     * @return the hasSpoken
     */
    public boolean hasSpoken() {
        return hasSpoken;
    }

    /**
     * Define if character has spoken or not
     * 
     * @param hasSpoken 
     *          the hasSpoken to set
     */
    public void setHasSpoken(boolean hasSpoken) {
        this.hasSpoken = hasSpoken;
    }

}