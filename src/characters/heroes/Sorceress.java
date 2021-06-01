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

    @Override
    public void attack(DungeonCharacter opponent) {
        System.out.println(name + " casts a spell of fireball at " + opponent.getName()
                           + ":");
        super.attack(opponent);
    }

    @Override
    public void battleChoices(DungeonCharacter opponent) {
        super.battleChoices(opponent);
        int choice;

        do {
            System.out.println("1. Attack Opponent");
            System.out.println("2. Increase Hit Points");
            System.out.print("Choose an option: ");
            choice = Keyboard.readInt();

            switch (choice) {
                case 1: attack(opponent); break;
                case 2: increaseHitPoints(); break;
                default:
                    System.out.println(Keyboard.RED
                                       + "Invalid option: choose either options 1 or 2"
                                       + Keyboard.NC);
                    continue;
            }

            numTurns--;
            if (numTurns > 0) {
                System.out.println("Number of turns remaining is: " + numTurns);
            }
        } while (numTurns > 0 && hitPoints > 0 && opponent.getHitPoints() > 0);
    }
}
