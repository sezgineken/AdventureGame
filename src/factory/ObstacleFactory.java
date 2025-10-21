package factory;

import constants.GameConstants;
import model.*;

/**
 * Factory for creating obstacles
 * ÖDEV 3: Snake added
 */
public class ObstacleFactory {
    
    public static Obstacle createObstacle(int obstacleId) {
        switch (obstacleId) {
            case GameConstants.ZOMBIE_ID:
                return new Zombie();
            case GameConstants.VAMPIRE_ID:
                return new Vampire();
            case GameConstants.BEAR_ID:
                return new Bear();
            case GameConstants.SNAKE_ID: // ÖDEV 3
                return new Snake();
            default:
                return null;
        }
    }
}
