package model;

import constants.GameConstants;
import java.util.HashSet;
import java.util.Set;

/**
 * Manages player's inventory (weapons, armor and rewards)
 * ÖDEV 1: Reward tracking added
 */
public class Inventory {
    private Weapon weapon;
    private Armor armor;
    private Set<String> rewards; // ÖDEV 1: Toplanan ödüller

    public Inventory() {
        this.weapon = new Weapon(GameConstants.DEFAULT_WEAPON_NAME, 
                                 GameConstants.DEFAULT_WEAPON_ID, 
                                 GameConstants.DEFAULT_WEAPON_DAMAGE, 
                                 GameConstants.DEFAULT_WEAPON_PRICE);
        this.armor = new Armor(GameConstants.DEFAULT_ARMOR_NAME, 
                               GameConstants.DEFAULT_ARMOR_ID, 
                               GameConstants.DEFAULT_ARMOR_BLOCK, 
                               GameConstants.DEFAULT_ARMOR_PRICE);
        this.rewards = new HashSet<>(); // ÖDEV 1
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        if (weapon != null) {
            this.weapon = weapon;
        }
    }

    public Armor getArmor() {
        return armor;
    }

    public void setArmor(Armor armor) {
        if (armor != null) {
            this.armor = armor;
        }
    }
    
    // ÖDEV 1: Reward management methods
    public void addReward(String reward) {
        if (reward != null && !reward.isEmpty()) {
            rewards.add(reward);
        }
    }
    
    public boolean hasReward(String reward) {
        return rewards.contains(reward);
    }
    
    public Set<String> getRewards() {
        return new HashSet<>(rewards);
    }
    
    public boolean hasAllRewards() {
        return rewards.contains(GameConstants.REWARD_FOOD) &&
               rewards.contains(GameConstants.REWARD_FIREWOOD) &&
               rewards.contains(GameConstants.REWARD_WATER);
    }
}

