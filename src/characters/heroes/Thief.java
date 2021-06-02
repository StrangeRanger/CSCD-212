package characters.heroes;

import characters.DungeonCharacter;
import io.Keyboard;

/** Thief character. */
public class Thief extends Hero {
    /** Constructor. */
    public Thief() {
        /* super(
         *      name          = "Thief"  // To be overwritten in parent class.
         *      hitPoints     = 75
         *      attackSpeed   = 6
         *      chanceToHit   = .8
         *      damageMin     = 20
         *      damageMax     = 40
         *      chanceToBlock = .5
         * )
         */
        super("Thief", 75, 6, .8, 20, 40, .5);
    }

    /**
     * Special move.
     *
     * @param opponent The opponent to attack.
     */
    public void surpriseAttack(DungeonCharacter opponent) {
        double surprise = Math.random();

        if (surprise <= .4) {
            System.out.println("Surprise attack was successful!\n" + name
                               + " gets an additional turn.");
            numTurns++;
            attack(opponent);
        } else if (surprise >= .9) {
            System.out.println("Uh oh! " + opponent.getName() + " saw you and"
                               + " blocked your attack!");
        } else {
            attack(opponent);
        }
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
            System.out.println("2. Surprise Attack");
            System.out.print("Choose an option: ");
            choice = Keyboard.readInt();
            System.out.println();

            switch (choice) {
                case 1: attack(opponent); break;
                case 2: surpriseAttack(opponent); break;
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
