package characters.monsters;

import characters.DungeonCharacter;

/** Ogre character. */
public class Ogre extends Monster {
    /** Constructor. */
    public Ogre() { super("Oscar the Ogre", 200, 2, .6, .1, 30, 50, 30, 50); }

    @Override
    public void attack(DungeonCharacter opponent) {
        System.out.println(name + " slowly swings a club toward's " + opponent.getName()
                           + ":");
        super.attack(opponent);
    }
}
