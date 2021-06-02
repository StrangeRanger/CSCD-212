package characters.heroes;

import characters.DungeonCharacter;
import io.Keyboard;

/** Warrior character. */
public class Warrior extends Hero {
    /** Constructor. */
    public Warrior() {
        /* super(
         *      name          = "Warrior"  // To be overwritten in parent class.
         *      hitPoints     = 125
         *      attackSpeed   = 4
         *      chanceToHit   = .8
         *      damageMin     = 35
         *      damageMax     = 60
         *      chanceToBlock = .2
         * )
         */
        super("Warrior", 125, 4, .8, 35, 60, .2);
    }

    /**
     * Special move.
     *
     * @param opponent The opponent to attack.
     */
    public void crushingBlow(DungeonCharacter opponent) {
        if (Math.random() <= .4) {
            var blowPoints = randomInt.nextInt(76) + 100;
            System.out.println(name + " lands a CRUSHING BLOW for " + blowPoints
                               + " damage!");
            opponent.subtractHitPoints(blowPoints);
        } else {
            System.out.println(name + " failed to land a crushing blow");
            System.out.println();
        }
    }

    /**
     * @param opponent The opponent being attacked.
     */
    @Override
    public void attack(DungeonCharacter opponent) {
        System.out.println(name + " swings a mighty sword at " + opponent.getName()
                           + ":");
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
            System.out.println("2. Crushing Blow on Opponent");
            System.out.print("Choose an option: ");
            choice = Keyboard.readInt();
            System.out.println();

            switch (choice) {
                case 1: attack(opponent); break;
                case 2: crushingBlow(opponent); break;
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
