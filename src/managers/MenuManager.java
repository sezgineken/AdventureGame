package managers;

import constants.Messages;
import utils.InputHandler;

/**
 * Manages game menus and user selections
 * Separates UI logic from game logic (SRP)
 */
public class MenuManager {
    private final InputHandler inputHandler;
    
    public MenuManager(InputHandler inputHandler) {
        this.inputHandler = inputHandler;
    }
    
    public void displayWelcome(String playerName) {
        System.out.println(Messages.GAME_TITLE);
        System.out.println(String.format(Messages.WELCOME_MESSAGE, playerName));
        System.out.println(Messages.SELECT_CHARACTER);
        System.out.println("*********************************:");
    }
    
    public int displayLocationMenu() {
        System.out.println();
        System.out.println(Messages.REGIONS_TITLE);
        System.out.println();
        System.out.println("1- " + Messages.SAFE_HOUSE);
        System.out.println("2- " + Messages.TOOL_STORE);
        System.out.println("3- " + Messages.CAVE);
        System.out.println("4- " + Messages.FOREST);
        System.out.println("5- " + Messages.RIVER);
        System.out.println("6- " + Messages.MINE + " ⚒️ (YENİ!)"); // ÖDEV 3
        System.out.println("0- Çıkış Yap.");
        
        System.out.print(Messages.SELECT_REGION);
        return inputHandler.readInt();
    }
    
    public int displayStoreMenu() {
        System.out.println("1- Silahlar");
        System.out.println("2- Zırhlar");
        System.out.println("3- Çıkış yap");
        System.out.print("Seçiminiz: ");
        return inputHandler.readIntInRange(1, 3);
    }
    
    public void displayInvalidRegion() {
        System.out.println(Messages.INVALID_REGION);
    }
    
    public void displayQuitMessage() {
        System.out.println(Messages.QUIT_MESSAGE);
    }
    
    public void displayGameOver() {
        System.out.println(Messages.GAME_OVER);
    }
}
