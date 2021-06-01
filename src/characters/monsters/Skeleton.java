package characters.monsters;

import characters.DungeonCharacter;

/** Skeleton character. */
public class Skeleton extends Monster {
    /** Constructor. */
    public Skeleton() {
        /* 
         * super(
         *      name         = "Sargath the Skeleton"
         *      hitPoints    = 100
         *      attackSpeed  = 3
         *      chanceToHit  = .8
         *      chanceToHeal = .3
         *      damageMin    = 30
         *      damageMax    = 50
         *      minHeal      = 30
         *      maxHeal      = 50
         * )
         */
        super("Sargath the Skeleton", 100, 3, .8, .3, 30, 50, 30, 50);
    }

    /**
     * @param opponent The opponent being attacked.
     */
    @Override
    public void attack(DungeonCharacter opponent) {
        System.out.println(name + " slices his rusty blade at " + opponent.getName()
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
