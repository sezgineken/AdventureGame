package managers;

import constants.Messages;
import model.Obstacle;
import model.Player;
import utils.InputHandler;
import java.util.Random;

/**
 * Manages combat logic
 * Separates combat mechanics from location logic (SRP)
 * ÖDEV 2: First strike system added
 * BUG FIX: Victory condition corrected
 */
public class CombatManager {
    private final InputHandler inputHandler;
    private final CombatUI combatUI;
    private final Random random;
    
    public CombatManager(InputHandler inputHandler, CombatUI combatUI) {
        this.inputHandler = inputHandler;
        this.combatUI = combatUI;
        this.random = new Random();
    }
    
    public boolean startCombat(Player player, Obstacle obstacle, int obstacleCount, String locationName) {
        combatUI.displayLocationInfo(locationName, obstacleCount, obstacle.getName());
        System.out.print(Messages.FIGHT_OR_RUN);
        String selectCase = inputHandler.readLineUpperCase();
        
        if (selectCase.equals("S") && combat(player, obstacle, obstacleCount)) {
            combatUI.displayAllEnemiesDefeated(locationName);
            return true;
        }
        
        if (player.getHealth() <= 0) {
            System.out.println(Messages.YOU_DIED);
            return false;
        }
        
        return true;
    }
    
    public boolean combat(Player player, Obstacle obstacle, int obstacleCount) {
        for (int i = 1; i <= obstacleCount; i++) {
            obstacle.setHealth(obstacle.getOriginalHealth());
            combatUI.displayPlayerStats(player);
            combatUI.displayObstacleStats(obstacle, i);
            
            // ÖDEV 2: İlk hamleyi %50 şans ile belirle
            boolean playerStrikesFirst = random.nextBoolean();
            if (playerStrikesFirst) {
                System.out.println(Messages.FIRST_STRIKE_PLAYER);
            } else {
                System.out.println(Messages.FIRST_STRIKE_ENEMY);
            }
            System.out.println();
            
            while (player.getHealth() > 0 && obstacle.getHealth() > 0) {
                System.out.print(Messages.HIT_OR_RUN);
                String selectCombat = inputHandler.readLineUpperCase();
                
                if (selectCombat.equals("V")) {
                    // ÖDEV 2: İlk hamle sırasına göre saldır
                    if (playerStrikesFirst) {
                        // Oyuncu önce vurur
                        combatUI.displayYouHit();
                        obstacle.setHealth(obstacle.getHealth() - player.getTotalDamage());
                        combatUI.displayAfterHit(player, obstacle);
                        
                        if (obstacle.getHealth() > 0) {
                            combatUI.displayEnemyHit();
                            int obstacleDamage = obstacle.getDamage() - player.getInventory().getArmor().getBlock();
                            if (obstacleDamage < 0) {
                                obstacleDamage = 0;
                            }
                            player.setHealth(player.getHealth() - obstacleDamage);
                            combatUI.displayAfterHit(player, obstacle);
                        }
                    } else {
                        // Düşman önce vurur
                        combatUI.displayEnemyHit();
                        int obstacleDamage = obstacle.getDamage() - player.getInventory().getArmor().getBlock();
                        if (obstacleDamage < 0) {
                            obstacleDamage = 0;
                        }
                        player.setHealth(player.getHealth() - obstacleDamage);
                        combatUI.displayAfterHit(player, obstacle);
                        
                        if (player.getHealth() > 0) {
                            combatUI.displayYouHit();
                            obstacle.setHealth(obstacle.getHealth() - player.getTotalDamage());
                            combatUI.displayAfterHit(player, obstacle);
                        }
                    }
                } else {
                    return false;
                }
            }
            
            // BUG FIX: Correct victory condition
            // ÖNCE: if (obstacle.getHealth() < player.getHealth())
            // SORUN: Düşman canlıyken bile kazanç olabiliyordu!
            // SONRA: Sadece düşman ölü mü kontrolü
            if (obstacle.getHealth() <= 0 && player.getHealth() > 0) {
                player.setMoney(player.getMoney() + obstacle.getAward());
                combatUI.displayVictory(obstacle, player.getMoney());
            } else {
                // Player died
                return false;
            }
        }
        return true;
    }
}
