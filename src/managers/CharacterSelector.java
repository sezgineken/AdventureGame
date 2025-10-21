package managers;

import constants.Messages;
import factory.CharacterFactory;
import model.GameChar;
import utils.InputHandler;

/**
 * Handles character selection logic
 * Separates character selection from Player class (SRP)
 * BUG FIX: Removed recursive call to prevent stack overflow
 */
public class CharacterSelector {
    private final InputHandler inputHandler;
    
    public CharacterSelector(InputHandler inputHandler) {
        this.inputHandler = inputHandler;
    }
    
    /**
     * BUG FIX: Changed from recursive to iterative approach
     * Prevents StackOverflowError on repeated invalid inputs
     */
    public GameChar selectCharacter() {
        while (true) {
            GameChar[] charList = CharacterFactory.getAllCharacters();
            
            System.out.println(Messages.CHARACTERS_TITLE);
            System.out.println("---------------------------------------------------------------------------------------------------------------");
            
            for (GameChar gameChar : charList) {
                System.out.println(gameChar.getId() + "- " + gameChar.getName() +
                        " \t Hasar: " + gameChar.getDamage() +
                        " \t Sağlık: " + gameChar.getHealth() +
                        " \t Para: " + gameChar.getMoney());
            }
            
            System.out.println("---------------------------------------------------------------------------------------------------------------");
            System.out.println(Messages.SELECT_CHARACTER_PROMPT);
            
            int selectChar = inputHandler.readInt();
            GameChar selectedChar = CharacterFactory.createCharacter(selectChar);
            
            if (selectedChar != null) {
                return selectedChar;
            }
            
            // Loop continues for retry, no recursion
            System.out.println(Messages.INVALID_CHARACTER);
        }
    }
}
