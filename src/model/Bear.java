package model;

import constants.GameConstants;

/**
 * Bear obstacle class
 */
public class Bear extends Obstacle {
    public Bear() {
        super("Ayı", 
              GameConstants.BEAR_ID, 
              GameConstants.BEAR_DAMAGE, 
              GameConstants.BEAR_HEALTH, 
              GameConstants.BEAR_AWARD);
    }
}

