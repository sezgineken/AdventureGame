package model;

import constants.GameConstants;

/**
 * Samurai character class
 */
public class Samurai extends GameChar {
    public Samurai() {
        super(GameConstants.SAMURAI_ID, 
              "Samuray", 
              GameConstants.SAMURAI_DAMAGE, 
              GameConstants.SAMURAI_HEALTH, 
              GameConstants.SAMURAI_MONEY);
    }
}

