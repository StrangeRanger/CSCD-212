package characters.heroes;

import characters.DungeonCharacter;
import io.Keyboard;

/** Sorceress character. */
public class Sorceress extends Hero {
    /** Constructor. */
    public Sorceress() {
        /* super(
         *      name          = "Sorceress"  // To be overwritten in parent class.
         *      hitPoints     = 75
         *      attackSpeed   = 5
         *      chanceToHit   = .7
         *      damageMin     = 25
         *      damageMax     = 50
         *      chanceToBlock = .3
         * )
         */
        super("Sorceress", 75, 5, .7, 25, 50, .3);
    }

    /** Special move. */
    public void increaseHitPoints() {
        var minAdd  = 25;
        var maxAdd  = 50;
        var hPoints = randomInt.nextInt(maxAdd - minAdd + 1) + minAdd;

        addHitPoints(hPoints);
        System.out.println(name + " added [" + hPoints + "] points.\n"
                           + "Total hit points remaining are: " + hitPoints);
        System.out.println();
    }

    /**
     * @param opponent The opponent being attacked.
     */
    @Override
    public void attack(DungeonCharacter opponent) {
        System.out.println(name + " casts a spell of fireball at " +
                           opponent.getName() + ":");
        super.attack(opponent);
    }

    /**
     * Provides the user with possible actions to perform during their turn.
     *
     * @param opponent The opponent to attack.
     */
    @Override
    public void battleChoices(DungeonCharacter opponent) {
        numOfTurns(opponent);
        int choice;

        do {
            System.out.println("1. Attack Opponent");
            System.out.println("2. Increase Hit Points");
            System.out.print("Choose an option: ");
            choice = Keyboard.readInt();
            System.out.println();

            switch (choice) {
                case 1: attack(opponent); break;
                case 2: increaseHitPoints(); break;
                default:
                    System.out.println("Invalid option: choose either options 1 or 2");
                    continue;
            }
            System.out.println();

            numTurns--;
            if (numTurns > 0) {
                System.out.println("Number of turns remaining is: " + numTurns);
            }
        } while (numTurns > 0 && hitPoints > 0 && opponent.getHitPoints() > 0);
    }
}
