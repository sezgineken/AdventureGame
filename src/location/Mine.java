package location;

import constants.GameConstants;
import constants.Messages;
import managers.CombatManager;
import managers.CombatUI;
import managers.LootSystem;
import model.Player;
import model.Snake;
import utils.InputHandler;
import java.util.Random;

/**
 * Mine battle location with snakes - ÖDEV 3
 * Special location with loot system
 * Refactored to follow SRP
 */
public class Mine extends BattleLoc {
    private final LootSystem lootSystem;
    private final Random random;
    private final CombatManager combatManager;
    
    public Mine(Player player) {
        super(player, Messages.MINE, new Snake(), null, GameConstants.MINE_MAX_OBSTACLES);
        this.lootSystem = new LootSystem();
        this.random = new Random();
        // Initialize combat manager once (performance improvement)
        this.combatManager = new CombatManager(InputHandler.getInstance(), new CombatUI());
    }
    
    @Override
    public boolean onLocation() {
        // Bölge zaten tamamlanmışsa tekrar giriş engelle
        if (isCompleted()) {
            System.out.println(Messages.AREA_ALREADY_COMPLETED);
            return true;
        }
        
        int obsNumber = generateRandomObstacleCount();
        displayLocationInfo(obsNumber);
        
        InputHandler inputHandler = InputHandler.getInstance();
        String selectCase = inputHandler.readLineUpperCase();
        
        if (selectCase.equals("S")) {
            boolean won = combatWithLoot(obsNumber);
            if (won && this.getPlayer().getHealth() > 0) {
                completeLocation();
            }
            return won;
        }
        
        return true;
    }
    
    /**
     * SRP: Rastgele düşman sayısı üretme sorumluluğu
     */
    private int generateRandomObstacleCount() {
        return random.nextInt(GameConstants.MINE_MAX_OBSTACLES - GameConstants.MINE_MIN_OBSTACLES + 1) 
               + GameConstants.MINE_MIN_OBSTACLES;
    }
    
    /**
     * SRP: Lokasyon bilgilerini gösterme sorumluluğu
     */
    private void displayLocationInfo(int obstacleCount) {
        System.out.println("Şu an buradasınız: " + this.getName());
        System.out.println("Dikkatli ol. Burada " + obstacleCount + " tane " + this.getObstacle().getName() + " yaşıyor");
        System.out.print(Messages.FIGHT_OR_RUN);
    }
    
    /**
     * SRP: Lokasyonu tamamlama sorumluluğu
     */
    private void completeLocation() {
        setCompleted(true);
        System.out.println(this.getName() + " - Tüm düşmanları yendiniz ve bölgeyi tamamladınız!");
    }
    
    /**
     * ÖDEV 3: Loot sistemi ile savaş
     * Performance: CombatManager artık sadece bir kez yaratılıyor
     */
    private boolean combatWithLoot(int obstacleCount) {
        for (int i = 1; i <= obstacleCount; i++) {
            // Her yılan için yeni rastgele hasar
            Snake snake = new Snake();
            
            boolean wonFight = combatManager.combat(this.getPlayer(), snake, 1);
            
            if (!wonFight || this.getPlayer().getHealth() <= 0) {
                return false;
            }
            
            // ÖDEV 3: Yenilen düşmandan loot düşür
            displayLootSection();
            lootSystem.dropLoot(this.getPlayer());
            displayLootSectionEnd();
        }
        
        return true;
    }
    
    /**
     * SRP: Loot bölümü UI sorumluluğu
     */
    private void displayLootSection() {
        System.out.println();
        System.out.println("=== GANİMET KONTROLÜ ===");
    }
    
    /**
     * SRP: Loot bölümü sonu UI sorumluluğu
     */
    private void displayLootSectionEnd() {
        System.out.println("========================");
        System.out.println();
    }
}
