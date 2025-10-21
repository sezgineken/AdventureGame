package model;

import constants.GameConstants;

/**
 * Archer character class
 */
public class Archer extends GameChar {
    public Archer() {
        super(GameConstants.ARCHER_ID, 
              "Okçu", 
              GameConstants.ARCHER_DAMAGE, 
              GameConstants.ARCHER_HEALTH, 
              GameConstants.ARCHER_MONEY);
    }
}

