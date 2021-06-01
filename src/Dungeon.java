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
     * chooseHero allows the user to select a hero, creates that hero, and returns it.
     * It utilizes a polymorphic reference (Hero) to accomplish this task.
     *
     * @return Return the specified hero [class].
     */
    public static DungeonCharacter chooseHero() {
        int choice;

        while (true) {
            System.out.println("Choose a hero:\n"
                               + "  1. Warrior\n"
                               + "  2. Sorceress\n"
                               + "  3. Thief");

            choice = Keyboard.readInt();

            switch (choice) {
                case 1: return characterFactory.getCharacter("Warrior");
                case 2: return characterFactory.getCharacter("Sorceress");
                case 3: return characterFactory.getCharacter("Thief");
                default:
                    System.out.println(Keyboard.RED
                                       + "Invalid option: choose between options 1-3"
                                       + Keyboard.NC);
            }
        }
    }

    /**
     * generateMonster randomly selects a Monster and returns it. It utilizes a
     * polymorphic reference (Monster) to accomplish this task.
     *
     * @return Return a random monster [class].
     */
    public static DungeonCharacter generateMonster() {
        var choice = randomInt.nextInt(3) + 1;

        switch (choice) {
            case 1: return characterFactory.getCharacter("Ogre");
            case 2: return characterFactory.getCharacter("Gremlin");
            case 3: return characterFactory.getCharacter("Skeleton");
            // TODO: Added custom text to thrown exception.
            default: throw new IllegalArgumentException();
        }
    }

    /**
     * playAgain allows gets choice from user to play another game.  It returns true if
     * the user chooses to continue, false otherwise.
     *
     * @return Whether or not the user entered 'y' or 'n'.
     */
    public static boolean playAgain() {
        String again;

        System.out.println("Play again? [y/n]");
        again = Keyboard.readString().toLowerCase();

        return (again.equals("y") || again.equals("yes"));
    }

    /**
     * Performs the combat portion of the game. Battles occur in rounds. The Hero goes
     * first, then the Monster. At the conclusion of each round, the user has the option
     * of quitting.
     *
     * TODO: Add output to make it more clear when the hero and monster are performing
     *       some action.
     *
     * @param theHero 	 The Hero that will fight the monster.
     * @param theMonster The monster to be fought.
     */
    public static void battle(DungeonCharacter theHero, DungeonCharacter theMonster) {
        var pause = "";
        System.out.println(theHero.getName() + " battles " + theMonster.getName());
        System.out.println("---------------------------------------------");

        // Do battle
        while (theHero.isAlive() && theMonster.isAlive() && ! pause.equals("q")) {
            // Hero goes first
            theHero.battleChoices(theMonster);

            // Monster's turn (provided it's still alive!)
            if (theMonster.isAlive()) {
                theMonster.attack(theHero);
            }

            // Let the player bail out if desired
            System.out.print("\n-->q to quit, anything else to continue: ");
            // TODO: Make it possible to just press enter instead of requiring the user
            //       to enter a letter, then press [Enter].
            pause = Keyboard.readString();
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
