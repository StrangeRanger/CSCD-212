package characters.monsters;

import characters.DungeonCharacter;

/** Skeleton character. */
public class Skeleton extends Monster {
    /** Constructor. */
    public Skeleton() { super("Sargath the Skeleton", 100, 3, .8, .3, 30, 50, 30, 50); }

    @Override
    public void attack(DungeonCharacter opponent) {
        System.out.println(name + " slices his rusty blade at " + opponent.getName()
                           + ":");
        super.attack(opponent);
    }
}
