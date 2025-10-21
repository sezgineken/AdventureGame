package factory;

import constants.GameConstants;
import location.*;
import model.Player;

/**
 * Factory for creating game locations
 * Implements Factory Pattern for location creation
 * ÖDEV 3: Mine location added
 */
public class LocationFactory {
    
    public static Location createLocation(int locationId, Player player) {
        switch (locationId) {
            case GameConstants.SAFE_HOUSE_OPTION:
                return new SafeHouse(player);
            case GameConstants.TOOL_STORE_OPTION:
                return new ToolStore(player);
            case GameConstants.CAVE_OPTION:
                return new Cave(player);
            case GameConstants.FOREST_OPTION:
                return new Forest(player);
            case GameConstants.RIVER_OPTION:
                return new River(player);
            case GameConstants.MINE_OPTION: // ÖDEV 3
                return new Mine(player);
            case GameConstants.EXIT_OPTION:
                return null;
            default:
                return null;
        }
    }
}
