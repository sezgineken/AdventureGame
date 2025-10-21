import factory.LocationFactory;
import location.Location;
import managers.CharacterSelector;
import managers.MenuManager;
import model.GameChar;
import model.Player;
import utils.InputHandler;

/**
 * Main game class
 * Refactored to follow SOLID principles:
 * - Uses Factory Pattern for location creation (OCP)
 * - Delegates responsibilities to specialized classes (SRP)
 * - Uses dependency injection for InputHandler (DIP)
 * - Removed instanceof check (OCP compliance)
 */
public class Game {
    private final InputHandler inputHandler;
    private final MenuManager menuManager;
    private final CharacterSelector characterSelector;

    public Game() {
        this.inputHandler = InputHandler.getInstance();
        this.menuManager = new MenuManager(inputHandler);
        this.characterSelector = new CharacterSelector(inputHandler);
    }

    public void start() {
        System.out.print("Lütfen isminizi giriniz: ");
        String playerName = inputHandler.readLine();

        Player player = new Player(playerName);
        menuManager.displayWelcome(playerName);

        // Character selection delegated to CharacterSelector
        GameChar selectedChar = characterSelector.selectCharacter();
        player.initializeWithCharacter(selectedChar);

        // Main game loop
        gameLoop(player);
        
        // Cleanup
        inputHandler.close();
    }

    private void gameLoop(Player player) {
        while (true) {
            player.printInfo();

            // Location selection using MenuManager
            int selectLoc = menuManager.displayLocationMenu();

            // Location creation using Factory Pattern
            Location location = LocationFactory.createLocation(selectLoc, player);

            if (location == null) {
                if (selectLoc == 0) {
                    menuManager.displayQuitMessage();
                } else {
                    menuManager.displayInvalidRegion();
                    continue;
                }
                break;
            }

            // Visit location
            if (!location.onLocation()) {
                // OCP: No instanceof check, using polymorphic method instead
                if (!location.isWinningLocation()) {
                    menuManager.displayGameOver();
                }
                break;
            }
        }
    }
}
