package model;

import constants.GameConstants;
import java.util.Random;

/**
 * Snake obstacle class - ÖDEV 3
 * Rastgele hasar veren düşman
 */
public class Snake extends Obstacle {
    private static final Random random = new Random();
    
    public Snake() {
        super("Yılan", 
              GameConstants.SNAKE_ID, 
              generateRandomDamage(), // Rastgele hasar
              GameConstants.SNAKE_HEALTH, 
              GameConstants.SNAKE_AWARD);
    }
    
    /**
     * 3 ile 6 arası rastgele hasar üretir
     */
    private static int generateRandomDamage() {
        return random.nextInt(GameConstants.SNAKE_MAX_DAMAGE - GameConstants.SNAKE_MIN_DAMAGE + 1) 
               + GameConstants.SNAKE_MIN_DAMAGE;
    }
    
    /**
     * Her yılan için yeni rastgele hasar üret
     */
    public void regenerateDamage() {
        setDamage(generateRandomDamage());
    }
}

