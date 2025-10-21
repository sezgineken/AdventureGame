package managers;

import constants.Messages;
import model.Obstacle;
import model.Player;

/**
 * Handles combat-related UI display
 * Separates UI logic from combat logic (SRP)
 */
public class CombatUI {
    
    public void displayLocationInfo(String locationName, int obstacleCount, String obstacleName) {
        System.out.println(String.format(Messages.CURRENT_LOCATION, locationName));
        System.out.println(String.format(Messages.ENEMY_WARNING, obstacleCount, obstacleName));
    }
    
    public void displayPlayerStats(Player player) {
        System.out.println(Messages.PLAYER_STATS);
        System.out.println("*****************************");
        System.out.println(String.format(Messages.HEALTH, player.getHealth()));
        System.out.println(String.format(Messages.WEAPON, player.getInventory().getWeapon().getName()));
        System.out.println(String.format(Messages.DAMAGE, player.getTotalDamage()));
        System.out.println(String.format(Messages.ARMOR, player.getInventory().getArmor().getName()));
        System.out.println(String.format(Messages.BLOCK, player.getInventory().getArmor().getBlock()));
        System.out.println(String.format(Messages.MONEY, player.getMoney()));
        System.out.println();
    }
    
    public void displayObstacleStats(Obstacle obstacle, int index) {
        System.out.println(String.format(Messages.ENEMY_STATS, index, obstacle.getName()));
        System.out.println("*****************************");
        System.out.println(String.format(Messages.HEALTH, obstacle.getHealth()));
        System.out.println(String.format(Messages.DAMAGE, obstacle.getDamage()));
        System.out.println(String.format(Messages.AWARD, obstacle.getAward()));
        System.out.println();
    }
    
    public void displayAfterHit(Player player, Obstacle obstacle) {
        System.out.println("Canınız: " + player.getHealth());
        System.out.println(obstacle.getName() + " Canı: " + obstacle.getHealth());
        System.out.println("----------");
    }
    
    public void displayVictory(Obstacle obstacle, int currentMoney) {
        System.out.println();
        System.out.println(Messages.ENEMY_DEFEATED);
        System.out.println(String.format(Messages.MONEY_EARNED, obstacle.getAward()));
        System.out.println(String.format(Messages.CURRENT_MONEY, currentMoney));
        System.out.println();
    }
    
    public void displayAllEnemiesDefeated(String locationName) {
        System.out.println(String.format(Messages.ALL_ENEMIES_DEFEATED, locationName));
    }
    
    public void displayYouHit() {
        System.out.println(Messages.YOU_HIT);
    }
    
    public void displayEnemyHit() {
        System.out.println();
        System.out.println(Messages.ENEMY_HIT);
    }
}
