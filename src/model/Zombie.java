package model;

import constants.GameConstants;

/**
 * Zombie obstacle class
 */
public class Zombie extends Obstacle {
    public Zombie() {
        super("Zombi", 
              GameConstants.ZOMBIE_ID, 
              GameConstants.ZOMBIE_DAMAGE, 
              GameConstants.ZOMBIE_HEALTH, 
              GameConstants.ZOMBIE_AWARD);
    }
}

