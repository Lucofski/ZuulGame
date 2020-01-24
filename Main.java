import java.util.Scanner;
/**
 * Main class dedicated to start and restart the game
 * @author Tim Uil and Lucas Wagenaar
 * @version 2020.01.22
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
