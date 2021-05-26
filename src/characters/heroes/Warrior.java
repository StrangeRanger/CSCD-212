package characters.heroes;
import characters.DungeonCharacter;
import io.Keyboard;

/** Warrior character. */
public class Warrior extends Hero {
    /** Constructor. */
    public Warrior() {
        super("Warrior", 125, 4, .8, 35, 60, .2);
    }

    /**
     * Special move.
     *
     * @param opponent The opponent to attack.
     */
    public void crushingBlow(DungeonCharacter opponent) {
        if (Math.random() <= .4) {
            int blowPoints = (int) (Math.random() * 76) + 100;
            System.out.println(name + " lands a CRUSHING BLOW for " + blowPoints
                               + " damage!");
            opponent.subtractHitPoints(blowPoints);
        } else {
            System.out.println(name + " failed to land a crushing blow");
            System.out.println();
        }
    }

    @Override
    public void attack(DungeonCharacter opponent) {
        System.out.println(name + " swings a mighty sword at " + opponent.getName()
                           + ":");
        super.attack(opponent);
    }

    @Override
    public void battleChoices(DungeonCharacter opponent) {
        int choice;

        super.battleChoices(opponent);

        do {
            System.out.println("1. Attack Opponent");
            System.out.println("2. Crushing Blow on Opponent");
            System.out.print("Choose an option: ");
            choice = Keyboard.readInt();

            switch (choice) {
                case 1 :
                    attack(opponent);
                    break;
                case 2 :
                    crushingBlow(opponent);
                    break;
                default :
                    System.out.println("invalid choice!");
            }

            numTurns--;
            if (numTurns > 0) {
                System.out.println("Number of turns remaining is: " + numTurns);
            }

        } while (numTurns > 0);
    }
}
