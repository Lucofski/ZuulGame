/**
 * This class is part of the "World of Zuul" application. "World of Zuul" is a
 * very simple, text based adventure game.
 * 
 * A "item" represents a device that you can be used in the scenery of the game.
 * 
 * @author Tim Uil and Lucas Wagenaar
 * @version 2020.01.20
 */

public class Item {

    private String name;
    private String description;

    /**
     * Create a new Item.
     * @param name
     * @param description
     */
    public Item(String name, String description) {
        this.name = name;
        this.description = description;
    }

    /**
     * Return a name of the item. 
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Define the name of the item.
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Return a description of the item.     * 
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Define the description of the item.
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Execute the action of this item.
     * @param player
     * @return
     */
    public boolean useItem(Player player) {

        if(this.name.equals("Banana")) {
            for(Door r : player.getCurrentRoom().getDoors()) {
                if(r.isLocked()) {
                    r.setLock(false);
                    System.out.println(r.getName() + " can be passed !");
                    return true;
                }                                    
            }
        }
        return false;
    }

}