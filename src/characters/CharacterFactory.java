package characters;

import characters.heroes.*;
import characters.monsters.*;

public class CharacterFactory {
    public DungeonCharacter getCharacter(String characterType) {
        switch (characterType.toLowerCase()) {
            case "warrior": return new Warrior();
            case "sorceress": return new Sorceress();
            case "thief": return new Thief();
            case "ogre": return new Ogre();
            case "gremlin": return new Gremlin();
            case "skeleton": return new Skeleton();
            // TODO: Added custom text to thrown exception.
            default: throw new IllegalArgumentException();
        }
    }
}