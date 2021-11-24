package characters.heroes;

import characters.DungeonCharacter;
import io.Keyboard;

/**
 * Abstract base class for a hierarchy of heroes. It is derived from DungeonCharacter.
 * A Hero has battle choices: regular attack and a special skill which is defined by the
 * classes derived from Hero.
 */
public abstract class Hero extends DungeonCharacter {
    protected double chanceToBlock;
    // If a hero is faster than opponent, there is a possibility for more than one
    // attack per round of battle.
    protected int    numTurns;

    /**
     * Call the base constructor and get the name of hero from the user.
     *
     * @param name		    Name of character.
     * @param hitPoints	    Points of damage a character can take before killed.
     * @param attackSpeed   How fast the character can attack.
     * @param chanceToHit   Chance an attack will strike the opponent.
     * @param damageMin     Minimum amount of damage a character can inflict.
     * @param damageMax     Maximum amount of damage a character can inflict.
     * @param chanceToBlock The chance to block an opponents attack.
     */
    protected Hero(String name, int hitPoints, int attackSpeed, double chanceToHit,
                   int damageMin, int damageMax, double chanceToBlock) {
        super(name, hitPoints, attackSpeed, chanceToHit, damageMin, damageMax);
        this.chanceToBlock = chanceToBlock;
        readName();
    }

    /** Obtains the name for the hero specified by the user. */
    public void readName() {
        System.out.print("Enter character name: ");
        name = Keyboard.readString();
    }

    /**
     * Check if the hero blocked the attack, and if so a message is displayed, otherwise
     * the base version of this method is invoked to perform the subtraction operation.
     *
     * @param hitPoints The number of hit points to subtract.
     */
    @Override
    public void subtractHitPoints(int hitPoints) {
        if (Math.random() <= chanceToBlock) {
            System.out.println(name + " BLOCKED the attack!");
        } else {
            super.subtractHitPoints(hitPoints);
        }
    }

    public void numOfTurns(DungeonCharacter opponent) {
        numTurns = attackSpeed / opponent.getAttackSpeed();

        if (numTurns == 0) { numTurns++; }

        System.out.println("Number of turns this round is: " + numTurns);
    }
}
