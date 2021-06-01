package characters;

import characters.heroes.*;
import characters.monsters.*;

/** In charge of instantiating a new character. */
public class CharacterFactory {
    /**
     * Return a new instance of the specified character type.
     *
     * @param characterType The character to be played as.
     */
    public DungeonCharacter getCharacter(String characterType) {
        switch (characterType.toLowerCase()) {
            case "warrior": return new Warrior();
            case "sorceress": return new Sorceress();
            case "thief": return new Thief();
            case "ogre": return new Ogre();
            case "gremlin": return new Gremlin();
            case "skeleton": return new Skeleton();
            default: throw new IllegalArgumentException("Internal Error: "
            		+ "getCharacter attempted to generate character that doesn't "
            		+ "exist\nCharacter " + characterType);
        }
    }
}