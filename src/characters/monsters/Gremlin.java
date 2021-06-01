package characters.monsters;

import characters.DungeonCharacter;

/** Gremlin character. */
public class Gremlin extends Monster {
    /** Constructor. */
    public Gremlin() {
        /*
         * super(
         *      name         = "Gnarltooth the Gremlin"
         *      hitPoints    = 70
         *      attackSpeed  = 5
         *      chanceToHit  = .8
         *      chanceToHeal = .4
         *      damageMin    = 15
         *      damageMax    = 30
         *      minHeal      = 20
         *      maxHeal      = 40
         * )
         */
        super("Gnarltooth the Gremlin", 70, 5, .8, .4, 15, 30, 20, 40);
    }

    /**
     * @param opponent The opponent being attacked.
     */
    @Override
    public void attack(DungeonCharacter opponent) {
        System.out.println(name + " jabs his kris at " + opponent.getName() + ":");
        super.attack(opponent);
        System.out.println();
    }

    @Override
    public void battleChoices(DungeonCharacter opponent) {
        /*
         * battleChoices is not used in this class, but must be implemented in one way
         * or another.
         */
    }
}
