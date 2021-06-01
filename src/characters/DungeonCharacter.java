package characters;

import java.util.Random;

/** Abstract Base class for inheritance hierarchy for a role playing game. */
public abstract class DungeonCharacter implements Comparable<Object> {
    protected String name;
    protected int    hitPoints;
    protected int    attackSpeed;
    protected double chanceToHit;
    protected int    damageMin;
    protected int    damageMax;
    protected Random randomInt = new Random();

    @Override
    public int compareTo(Object o) {
        return 1;
    }

    /**
     * Explicit constructor to initialize instance variables.
     *
     * @param name		  Name of character.
     * @param hitPoints	  Points of damage a character can take before killed.
     * @param attackSpeed How fast the character can attack.
     * @param chanceToHit Chance an attack will strike the opponent.
     * @param damageMin	  Minimum amount of damage a character can inflict.
     * @param damageMax	  Maximum amount of damage a character can inflict.
     */
    protected DungeonCharacter(String name,
                               int    hitPoints,
                               int    attackSpeed,
                               double chanceToHit,
                               int    damageMin,
                               int    damageMax) {
        this.name        = name;
        this.hitPoints   = hitPoints;
        this.attackSpeed = attackSpeed;
        this.chanceToHit = chanceToHit;
        this.damageMin   = damageMin;
        this.damageMax   = damageMax;
    }

    /** Return the character's name. */
    public String getName() { return name; }

    /** Return a character's hit points (health). */
    public int getHitPoints() { return hitPoints; }

    /** Return the character's attack speed. */
    public int getAttackSpeed() { return attackSpeed; }

    /**
     * Increments the hitPoints that a dungeon character has.
     *
     * @param hitPoints The number of hit points to add.
     */
    public void addHitPoints(int hitPoints) {
        if (hitPoints <= 0) {
            System.out.println("Hitpoint amount must be positive.");
        } else {
            this.hitPoints += hitPoints;
        }
    }

    /**
     * Decrements the hitPoints a dungeon character has.
     *
     * TODO: It also reports the damage and remaining hit points (these things could be
     *       done in separate methods to make code more modular ;-)
     *
     * @param hitPoints The number of hit points to subtract.
     */
    public void subtractHitPoints(int hitPoints) {
        if (hitPoints < 0) {
            System.out.println("Hitpoint amount must be positive.");
        } else if (hitPoints > 0) {
            this.hitPoints -= hitPoints;

            if (this.hitPoints < 0) {
                this.hitPoints = 0;
            }

            System.out.println(getName() + " hit "
                               + " for <" + hitPoints + "> points damage.");
            System.out.println(getName() + " now has " + getHitPoints()
                               + " hit points remaining.");
        }

        if (this.hitPoints == 0) {
            System.out.println();
            System.out.println(name + " has been killed :-(");
        }
    }

    /**
     * Used to see if a character is still alive by checking their hit
     * points.
     *
     * @return True if hero is alive, false otherwise.
     */
    public boolean isAlive() { return (hitPoints > 0); }

    /**
     * Allows characters to attempt an attack on an opponent. First, chance to hit is
     * considered. If a hit can occur, then the damage is calculated based on
     * character's damage range. This damage is then applied to the opponent.
     *
     * @param opponent The opponent being attacked.
     */
    public void attack(DungeonCharacter opponent) {
        boolean canAttack = Math.random() <= chanceToHit;
        int     damage;

        if (canAttack) {
            damage = randomInt.nextInt(damageMax - damageMin + 1) + damageMin;

            opponent.subtractHitPoints(damage);
        } else {
            System.out.println(getName() + "'s attack on " + opponent.getName()
                               + " failed!");
        }
    }

    /**
     * Abstract of the battleChoices class, to be implemented by the Hero class.
     *
     * @param opponent The opponent to be fought.
     */
    public abstract void battleChoices(DungeonCharacter opponent);
}
