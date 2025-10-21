package model;

import constants.GameConstants;

/**
 * Knight character class
 */
public class Knight extends GameChar {
    public Knight() {
        super(GameConstants.KNIGHT_ID, 
              "Şövalye", 
              GameConstants.KNIGHT_DAMAGE, 
              GameConstants.KNIGHT_HEALTH, 
              GameConstants.KNIGHT_MONEY);
    }
}

