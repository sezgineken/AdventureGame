package location;

import constants.Messages;
import managers.CombatManager;
import managers.CombatUI;
import model.Obstacle;
import model.Player;
import utils.InputHandler;
import java.util.Random;

/**
 * Abstract class for battle locations
 * Refactored to use CombatManager and CombatUI (SRP)
 * ÖDEV 1: Reward system and completion tracking added
 * Optimized: Random instance reused, removed unused setters
 */
public abstract class BattleLoc extends Location {
    private final Obstacle obstacle;
    private final String award;
    private final int maxObstacle;
    private final CombatManager combatManager;
    private final Random random; // Performance: Reused instead of recreating
    private boolean completed;

    public BattleLoc(Player player, String name, Obstacle obstacle, String award, int maxObstacle) {
        super(player, name);
        this.obstacle = obstacle;
        this.award = award;
        this.maxObstacle = maxObstacle;
        this.completed = false;
        this.random = new Random();
        
        // Initialize combat manager with dependencies
        InputHandler inputHandler = InputHandler.getInstance();
        CombatUI combatUI = new CombatUI();
        this.combatManager = new CombatManager(inputHandler, combatUI);
    }

    @Override
    public boolean onLocation() {
        // ÖDEV 1: Bölge zaten tamamlanmışsa tekrar giriş engelle
        if (completed) {
            System.out.println(Messages.AREA_ALREADY_COMPLETED);
            return true;
        }
        
        int obsNumber = randomObstacleNumber();
        boolean won = combatManager.startCombat(this.getPlayer(), this.obstacle, obsNumber, this.getName());
        
        // ÖDEV 1: Savaş kazanıldıysa ödül ver ve bölgeyi tamamla
        if (won && this.getPlayer().getHealth() > 0) {
            giveReward();
            this.completed = true;
        }
        
        return won;
    }
    
    /**
     * ÖDEV 1: Oyuncuya bölge ödülünü ver
     */
    private void giveReward() {
        if (award != null && !award.isEmpty()) {
            this.getPlayer().getInventory().addReward(award);
            System.out.println(String.format(Messages.REWARD_EARNED, award));
        }
    }

    /**
     * Performance: Random instance reused instead of recreating each time
     */
    public int randomObstacleNumber() {
        return random.nextInt(this.maxObstacle) + 1;
    }

    public int getMaxObstacle() {
        return maxObstacle;
    }

    public Obstacle getObstacle() {
        return obstacle;
    }

    public String getAward() {
        return award;
    }
    
    public boolean isCompleted() {
        return completed;
    }
    
    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
