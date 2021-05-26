package characters.monsters;

import characters.DungeonCharacter;

/** Gremlin character. */
public class Gremlin extends Monster {
    /** Constructor. */
    public Gremlin() {
        super("Gnarltooth the Gremlin", 70, 5, .8, .4, 15, 30, 20, 40);
    }

    @Override
    public void attack(DungeonCharacter opponent) {
        System.out.println(name + " jabs his kris at " + opponent.getName() + ":");
        super.attack(opponent);
    }
}
