package characters.monsters;

import characters.DungeonCharacter;

/**
 * Abstract base class for a hierarchy of Monsters. It is derived from DungeonCharacter.
 */
public abstract class Monster extends DungeonCharacter {
    protected double chanceToHeal;
    protected int    minHeal, maxHeal;

    /**
     * Constructor.
     *
     * @param name		   Name of character.
     * @param hitPoints	   Points of damage a character can take before killed.
     * @param attackSpeed  How fast the character can attack.
     * @param chanceToHit  Chance an attack will strike the opponent.
     * @param chanceToHeal Chance a character has to heal.
     * @param damageMin	   Minimum amount of damage a character can inflict.
     * @param damageMax	   Maximum amount of damage a character can inflict.
     * @param minHeal      The minimum amount of health to be restored.
     * @param maxHeal      The maximum amount of health to be restored...
     */
    public Monster(String name, int hitPoints, int attackSpeed, double chanceToHit,
                   double chanceToHeal, int damageMin, int damageMax, int minHeal,
                   int maxHeal) {
        super(name, hitPoints, attackSpeed, chanceToHit, damageMin, damageMax);
        this.chanceToHeal = chanceToHeal;
        this.maxHeal      = maxHeal;
        this.minHeal      = minHeal;
    }

    /** ... */
    public void heal() {
        boolean canHeal;
        int     healPoints;

        canHeal = (Math.random() <= chanceToHeal) && (hitPoints > 0);

        if (canHeal) {
            healPoints = (int) (Math.random() * (maxHeal - minHeal + 1)) + minHeal;
            addHitPoints(healPoints);
            System.out.println(name + " healed itself for " + healPoints + " points.\n"
                               + "Total hit points remaining are: " + hitPoints);
            System.out.println();
        }
    }

    @Override
    public void subtractHitPoints(int hitPoints) {
        super.subtractHitPoints(hitPoints);
        heal();
    }
}
