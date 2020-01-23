import java.util.Scanner;
/**
 * Main class dedicated to start and restart the game
 * @author Alexandre Boursier and Nolan Potier
 * @version 2011.10.24
 * @author Sean Worthington
 * @version 2014.03.01
 */
public class Main {
    public static void main(String[] args) {
        Game G;
        boolean play_again = true;// Allows the player to play several times
        while (play_again)
        {
            System.out.println("");
            System.out.println("__________           .__   ");
            System.out.println("\\____    /__ __ __ __|  |  ");
            System.out.println("  /     /|  |  \\  |  \\  |  ");
            System.out.println(" /     /_|  |  /  |  /  |__");
            System.out.println("/_______ \\____/|____/|____/");
            System.out.println("        \\/                 ");   
            G = new Game();
            G.play();
        }//End While
        System.out.println("Thank you for playing Zuul. Goodbye.");
    }//End main
}//End Zuule
