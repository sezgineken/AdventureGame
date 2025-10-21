package model;

import constants.GameConstants;

/**
 * Vampire obstacle class
 */
public class Vampire extends Obstacle {
    public Vampire() {
        super("Vampir", 
              GameConstants.VAMPIRE_ID, 
              GameConstants.VAMPIRE_DAMAGE, 
              GameConstants.VAMPIRE_HEALTH, 
              GameConstants.VAMPIRE_AWARD);
    }
}

