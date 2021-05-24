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
    /** Main method. */
    public static void main(String[] args) {
        Hero    theHero;
        Monster theMonster;

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
    public static Hero chooseHero() {
        int  choice;
        Hero theHero;

        System.out.println("Choose a hero:\n"
                           + "1. Warrior\n"
                           + "2. Sorceress\n"
                           + "3. Thief");
        choice = Keyboard.readInt();

        switch (choice) {
            case 1 :
                return new Warrior();
            case 2 :
                return new Sorceress();
            case 3 :
                return new Thief();
            default :
                System.out.println("invalid choice, returning Thief");
                return new Thief();
        }
    }

    /**
     * generateMonster randomly selects a Monster and returns it. It utilizes a
     * polymorphic reference (Monster) to accomplish this task.
     *
     * @return Return a random monster [class].
     */
    public static Monster generateMonster() {
        int choice;
        choice = (int) (Math.random() * 3) + 1;

        switch (choice) {
            case 1 :
                return new Ogre();
            case 2 :
                return new Gremlin();
            case 3 :
                return new Skeleton();
            default :
                System.out.println("invalid choice, returning Skeleton");
                return new Skeleton();
        }
    }

    /**
     * playAgain allows gets choice from user to play another game.  It returns true if
     * the user chooses to continue, false otherwise.
     *
     * @return Whether or not the user entered 'y' or 'n'.
     */
    public static boolean playAgain() {
        char again;

        System.out.println("Play again (y/n)?");
        again = Keyboard.readChar();

        return (again == 'Y' || again == 'y');
    }

    /**
     * battle is the actual combat portion of the game. It requires a Hero and a Monster
     * to be passed in.  Battle occurs in rounds. The Hero goes first, then the Monster.
     * At the conclusion of each round, the user has the option of quitting.
     *
     * @param theHero 	 The Hero that will fight the monster.
     * @param theMonster The monster to be fought.
     */
    public static void battle(Hero theHero, Monster theMonster) {
        char pause = 'p';
        System.out.println(theHero.getName() + " battles " + theMonster.getName());
        System.out.println("---------------------------------------------");

        // Do battle
        while (theHero.isAlive() && theMonster.isAlive() && pause != 'q') {
            // Hero goes first
            theHero.battleChoices(theMonster);

            // Monster's turn (provided it's still alive!)
            if (theMonster.isAlive()) {
                theMonster.attack(theHero);
            }

            // Let the player bail out if desired
            System.out.print("\n-->q to quit, anything else to continue: ");
            pause = Keyboard.readChar();
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
