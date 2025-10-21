package constants;

/**
 * Constants for game configuration
 */
public class GameConstants {
    // Character IDs
    public static final int SAMURAI_ID = 1;
    public static final int ARCHER_ID = 2;
    public static final int KNIGHT_ID = 3;
    
    // Character Stats - Samurai
    public static final int SAMURAI_DAMAGE = 5;
    public static final int SAMURAI_HEALTH = 21;
    public static final int SAMURAI_MONEY = 15;
    
    // Character Stats - Archer
    public static final int ARCHER_DAMAGE = 7;
    public static final int ARCHER_HEALTH = 18;
    public static final int ARCHER_MONEY = 20;
    
    // Character Stats - Knight
    public static final int KNIGHT_DAMAGE = 8;
    public static final int KNIGHT_HEALTH = 24;
    public static final int KNIGHT_MONEY = 5;
    
    // Obstacle IDs
    public static final int ZOMBIE_ID = 1;
    public static final int VAMPIRE_ID = 2;
    public static final int BEAR_ID = 3;
    
    // Obstacle Stats - Zombie
    public static final int ZOMBIE_DAMAGE = 3;
    public static final int ZOMBIE_HEALTH = 10;
    public static final int ZOMBIE_AWARD = 4;
    
    // Obstacle Stats - Vampire
    public static final int VAMPIRE_DAMAGE = 4;
    public static final int VAMPIRE_HEALTH = 14;
    public static final int VAMPIRE_AWARD = 7;
    
    // Obstacle Stats - Bear
    public static final int BEAR_DAMAGE = 7;
    public static final int BEAR_HEALTH = 20;
    public static final int BEAR_AWARD = 12;
    
    // Obstacle Stats - Snake (Yılan) - ÖDEV 3
    public static final int SNAKE_ID = 4;
    public static final int SNAKE_MIN_DAMAGE = 3;
    public static final int SNAKE_MAX_DAMAGE = 6;
    public static final int SNAKE_HEALTH = 12;
    public static final int SNAKE_AWARD = 0; // Para yerine loot düşürür
    
    // Weapon IDs
    public static final int SWORD_ID = 1;
    public static final int GUN_ID = 2;
    public static final int RIFLE_ID = 3;
    
    // Weapon Stats
    public static final int SWORD_DAMAGE = 2;
    public static final int SWORD_PRICE = 15;
    
    public static final int GUN_DAMAGE = 3;
    public static final int GUN_PRICE = 35;
    
    public static final int RIFLE_DAMAGE = 7;
    public static final int RIFLE_PRICE = 45;
    
    // Armor IDs
    public static final int LIGHT_ARMOR_ID = 1;
    public static final int MEDIUM_ARMOR_ID = 2;
    public static final int HEAVY_ARMOR_ID = 3;
    
    // Armor Stats
    public static final int LIGHT_ARMOR_BLOCK = 1;
    public static final int LIGHT_ARMOR_PRICE = 15;
    
    public static final int MEDIUM_ARMOR_BLOCK = 3;
    public static final int MEDIUM_ARMOR_PRICE = 25;
    
    public static final int HEAVY_ARMOR_BLOCK = 5;
    public static final int HEAVY_ARMOR_PRICE = 40;
    
    // Default Items
    public static final String DEFAULT_WEAPON_NAME = "Yumruk";
    public static final int DEFAULT_WEAPON_ID = -1;
    public static final int DEFAULT_WEAPON_DAMAGE = 0;
    public static final int DEFAULT_WEAPON_PRICE = 0;
    
    public static final String DEFAULT_ARMOR_NAME = "Paçavra";
    public static final int DEFAULT_ARMOR_ID = -1;
    public static final int DEFAULT_ARMOR_BLOCK = 0;
    public static final int DEFAULT_ARMOR_PRICE = 0;
    
    // Battle Location Max Obstacles
    public static final int CAVE_MAX_OBSTACLES = 3;
    public static final int FOREST_MAX_OBSTACLES = 3;
    public static final int RIVER_MAX_OBSTACLES = 2;
    public static final int MINE_MIN_OBSTACLES = 1; // ÖDEV 3
    public static final int MINE_MAX_OBSTACLES = 5; // ÖDEV 3
    
    // Menu Options
    public static final int EXIT_OPTION = 0;
    public static final int SAFE_HOUSE_OPTION = 1;
    public static final int TOOL_STORE_OPTION = 2;
    public static final int CAVE_OPTION = 3;
    public static final int FOREST_OPTION = 4;
    public static final int RIVER_OPTION = 5;
    public static final int MINE_OPTION = 6; // ÖDEV 3
    
    // Loot System Probabilities - ÖDEV 3
    public static final int WEAPON_DROP_CHANCE = 15;
    public static final int ARMOR_DROP_CHANCE = 15;
    public static final int MONEY_DROP_CHANCE = 25;
    public static final int NOTHING_DROP_CHANCE = 45;
    
    // Item Drop Probabilities (within category)
    public static final int COMMON_DROP_RATE = 50;  // %50 - Common items
    public static final int UNCOMMON_DROP_RATE = 30; // %30 - Uncommon items  
    public static final int RARE_DROP_RATE = 20;    // %20 - Rare items
    
    // Rewards - ÖDEV 1
    public static final String REWARD_FOOD = "Food";
    public static final String REWARD_FIREWOOD = "Firewood";
    public static final String REWARD_WATER = "Water";
    
    private GameConstants() {
        // Prevent instantiation
    }
}

