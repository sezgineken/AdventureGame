package factory;

import constants.GameConstants;
import model.*;

/**
 * Factory for creating game characters
 * Implements Factory Pattern for character creation
 */
public class CharacterFactory {
    
    public static GameChar createCharacter(int characterId) {
        switch (characterId) {
            case GameConstants.SAMURAI_ID:
                return new Samurai();
            case GameConstants.ARCHER_ID:
                return new Archer();
            case GameConstants.KNIGHT_ID:
                return new Knight();
            default:
                return null;
        }
    }
    
    public static GameChar[] getAllCharacters() {
        return new GameChar[] {
            new Samurai(),
            new Archer(),
            new Knight()
        };
    }
}
