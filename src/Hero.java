/**
 * Abstract base class for a hierarchy of heroes. It is derived from DungeonCharacter.
 * A Hero has battle choices: regular attack and a special skill which is defined by the
 * classes derived from Hero.
 */
public abstract class Hero extends DungeonCharacter {
    protected double chanceToBlock;
    // If a hero is faster than opponent, their is a possibility for more than one
    // attack per round of battle.
    protected int    numTurns;

    /**
     * calls base constructor and gets name of hero from user.
     *
     * @param name		    Name of character.
     * @param hitPoints	    Points of damage a character can take before killed.
     * @param attackSpeed   How fast the character can attack.
     * @param chanceToHit   Chance an attack will strike the opponent.
     * @param damageMin     Minimum amount of damage a character can inflict.
     * @param damageMax     Maximum amount of damage a character can inflict.
     * @param chanceToBlock The chance to block an opponents attack.
     */
    public Hero(String name, int hitPoints, int attackSpeed, double chanceToHit,
                int damageMin, int damageMax, double chanceToBlock) {
        super(name, hitPoints, attackSpeed, chanceToHit, damageMin, damageMax);
        this.chanceToBlock = chanceToBlock;
        readName();
    }

    /**
     * readName obtains a name for the hero from the user.
     *
     * This method calls: nothing
     * This method is called by: hero constructor
     */
    public void readName() {
        System.out.print("Enter character name: ");
        name = Keyboard.readString();
    }

    /**
     * defend determines if hero blocks attack.
     *
     * This method calls: Math.random()
     * This method is called by: subtractHitPoints()
     *
     * @return True if attack is blocked, false otherwise.
     */
    public boolean defend() {
        return Math.random() <= chanceToBlock;
    }

    /**
     * subtractHitPoints checks to see if hero blocked attack, if so a message is
     * displayed, otherwise base version of this method is invoked to perform the
     * subtraction operation.  This method overrides the method inherited from
     * DungeonCharacter promoting polymorphic behavior.
     *
     * This method calls: defend() or base version of method
     * This method is called by: attack() from base class
     *
     * @param hitPoints The number of hit points to subtract.
     */
    @Override
    public void subtractHitPoints(int hitPoints) {
        if (defend()) {
            System.out.println(name + " BLOCKED the attack!");
        } else {
            super.subtractHitPoints(hitPoints);
        }
    }

    /**
     * battleChoices will be overridden in derived classes. It computes the number of
     * turns a hero will get per round based on the opponent that is being fought. The
     * number of turns is reported to the user.  This stuff might go better in another
     * method that is invoked from this one...
     *
     * This method calls: getAttackSpeed()
     * This method is called by: external sources
     *
     * @param opponent The opponent to attack.
     */
    public void battleChoices(DungeonCharacter opponent) {
        numTurns = attackSpeed / opponent.getAttackSpeed();

        if (numTurns == 0) {
            numTurns++;
        }

        System.out.println("Number of turns this round is: " + numTurns);
    }
}
