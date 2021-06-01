import java.util.Random;

import characters.CharacterFactory;
import characters.DungeonCharacter;
import io.Keyboard;

/**
 * Driver file for Heroes and Monsters project.
 *
 * This class is the driver file for the Heroes and Monsters project. It will do the
 * following:
 *   1.  Allow the user to choose a hero
 *   2.  Randomly select a monster
 *   3.  Allow the hero to battle the monster
 *
 * Once a battle concludes, the user has the option of repeating the above.
 */
public class Dungeon {
    private static final Random           randomInt        = new Random();
    private static final CharacterFactory characterFactory = new CharacterFactory();

    /** Main method. */
    public static void main(String[] args) {
        DungeonCharacter theHero;
        DungeonCharacter theMonster;

        do {
            theHero    = chooseHero();
            theMonster = generateMonster();
            battle(theHero, theMonster);
        } while (playAgain());
    }

    /**
     * Allows the user to select a hero, creates that hero, and returns it.
     *
     * @return Return the specified hero [class].
     */
    public static DungeonCharacter chooseHero() {
        int choice;

        while (true) {
            System.out.println("Choose a hero:\n"
                               + "1. Warrior\n"
                               + "2. Sorceress\n"
                               + "3. Thief");
            choice = Keyboard.readInt();

            switch (choice) {
                case 1: return characterFactory.getCharacter("Warrior");
                case 2: return characterFactory.getCharacter("Sorceress");
                case 3: return characterFactory.getCharacter("Thief");
                default:
                    System.out.println("Invalid option: choose between options 1-3");
            }
        }
    }

    /**
     * Randomly selects a Monster and returns it.
     *
     * @return Return a random monster [class].
     */
    public static DungeonCharacter generateMonster() {
        var choice = randomInt.nextInt(3) + 1;

        switch (choice) {
            case 1: return characterFactory.getCharacter("Ogre");
            case 2: return characterFactory.getCharacter("Gremlin");
            case 3: return characterFactory.getCharacter("Skeleton");
            default:
                throw new IllegalArgumentException(
                        "Internal Error: generateMonster "
                        + "attempted to generate a monster that doesn't exist\nChoice: "
                        + choice);
        }
    }

    /**
     * Get the user's answer of whether or not to play another game.
     *
     * @return Returns true if the user chooses to continue, false otherwise.
     */
    public static boolean playAgain() {
        String again;

        System.out.println("Play again? [y/n]");
        again = Keyboard.readString().toLowerCase();

        return (again.equals("y") || again.equals("yes"));
    }

    /**
     * Perform the combat portion of the game. Battles occur in rounds. The Hero goes
     * first, then the Monster. At the conclusion of each round, the user has the option
     * of quitting.
     *
     * @param theHero 	 The Hero that will fight the monster.
     * @param theMonster The monster to be fought.
     */
    public static void battle(DungeonCharacter theHero, DungeonCharacter theMonster) {
        var pause = "";
        System.out.println(theHero.getName() + " battles " + theMonster.getName());
        System.out.println("---------------------------------------------");

        // Do battle.
        while (theHero.isAlive() && theMonster.isAlive() && ! pause.equals("q")) {
            // Hero goes first.
            theHero.battleChoices(theMonster);

            // Monster's turn (provided it's still alive!).
            if (theMonster.isAlive()) {
                theMonster.attack(theHero);
            }

            /// Let the player bail out if desired.
            System.out.print("--> q to quit, anything else to continue: ");
            pause = Keyboard.readString();
            System.out.println();
        }

        if (! theMonster.isAlive()) {
            System.out.println(theHero.getName() + " was victorious!");
        } else if (! theHero.isAlive()) {
            System.out.println(theHero.getName() + " was defeated :-(");
        } else {
            System.out.println("Quitters never win ;-)");
        }
    }
}
