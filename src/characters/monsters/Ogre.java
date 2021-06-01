package characters.monsters;

import characters.DungeonCharacter;

/** Ogre character. */
public class Ogre extends Monster {
    /** Constructor. */
    public Ogre() {
        /*
         * super(
         *      name         = "Oscar the Ogre"
         *      hitPoints    = 200
         *      attackSpeed  = 2
         *      chanceToHit  = .6
         *      chanceToHeal = .1
         *      damageMin    = 30
         *      damageMax    = 50
         *      minHeal      = 30
         *      maxHeal      = 50
         * )
         */
        super("Oscar the Ogre", 200, 2, .6, .1, 30, 50, 30, 50);
    }

    /**
     * @param opponent The opponent being attacked.
     */
    @Override
    public void attack(DungeonCharacter opponent) {
        System.out.println(name + " slowly swings a club toward's " + opponent.getName()
                           + ":");
        super.attack(opponent);
        System.out.println();
    }

    @Override
    public void battleChoices(DungeonCharacter theMonster) {
        /*
         * battleChoices is not used in this class, but must be implemented in one way
         * or another.
         */
    }
}
