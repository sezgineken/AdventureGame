package managers;

import constants.GameConstants;
import constants.Messages;
import model.*;
import java.util.Random;

/**
 * Loot system for Mine location - ÖDEV 3
 * Manages item drops with probabilities
 * Refactored to follow DRY principle
 */
public class LootSystem {
    private static final Random random = new Random();
    
    /**
     * Yenilen düşmandan ganimet düşür
     * %45 hiçbir şey
     * %25 para (1, 5 veya 10)
     * %15 silah (Tabanca, Kılıç veya Tüfek)
     * %15 zırh (Hafif, Orta veya Ağır)
     */
    public void dropLoot(Player player) {
        int roll = random.nextInt(100) + 1; // 1-100 arası
        
        if (roll <= GameConstants.NOTHING_DROP_CHANCE) {
            // %45 - Hiçbir şey düşmez
            System.out.println(Messages.LOOT_NOTHING);
        } else if (roll <= GameConstants.NOTHING_DROP_CHANCE + GameConstants.MONEY_DROP_CHANCE) {
            // %25 - Para düşer
            dropMoney(player);
        } else if (roll <= GameConstants.NOTHING_DROP_CHANCE + GameConstants.MONEY_DROP_CHANCE + GameConstants.WEAPON_DROP_CHANCE) {
            // %15 - Silah düşer
            dropWeapon(player);
        } else {
            // %15 - Zırh düşer
            dropArmor(player);
        }
    }
    
    /**
     * Para düşürme (1, 5 veya 10 TL)
     * DRY: Tek metot ile tüm para seviyeleri
     */
    private void dropMoney(Player player) {
        int amount = rollForRarity(1, 5, 10);
        
        System.out.println(Messages.LOOT_DROPPED);
        System.out.println(String.format(Messages.LOOT_MONEY, amount));
        player.setMoney(player.getMoney() + amount);
    }
    
    /**
     * Silah düşürme - DRY refactored
     * Tabanca: %50, Kılıç: %30, Tüfek: %20
     */
    private void dropWeapon(Player player) {
        Weapon droppedWeapon = createWeaponByRarity();
        
        System.out.println(Messages.LOOT_DROPPED);
        System.out.println(String.format(Messages.LOOT_WEAPON, droppedWeapon.getName()));
        
        // Mevcut silahtan daha iyiyse değiştir
        if (droppedWeapon.getDamage() > player.getInventory().getWeapon().getDamage()) {
            player.getInventory().setWeapon(droppedWeapon);
            System.out.println("Yeni silahınız daha güçlü! Silahınız güncellendi.");
        } else {
            System.out.println("Mevcut silahınız daha iyi, silahınızı değiştirmediniz.");
        }
    }
    
    /**
     * Zırh düşürme - DRY refactored
     * Hafif: %50, Orta: %30, Ağır: %20
     */
    private void dropArmor(Player player) {
        Armor droppedArmor = createArmorByRarity();
        
        System.out.println(Messages.LOOT_DROPPED);
        System.out.println(String.format(Messages.LOOT_ARMOR, droppedArmor.getName()));
        
        // Mevcut zırhtan daha iyiyse değiştir
        if (droppedArmor.getBlock() > player.getInventory().getArmor().getBlock()) {
            player.getInventory().setArmor(droppedArmor);
            System.out.println("Yeni zırhınız daha sağlam! Zırhınız güncellendi.");
        } else {
            System.out.println("Mevcut zırhınız daha iyi, zırhınızı değiştirmediniz.");
        }
    }
    
    /**
     * DRY Helper: Rarity'ye göre değer seç
     * Common: %50, Uncommon: %30, Rare: %20
     */
    private int rollForRarity(int common, int uncommon, int rare) {
        int roll = random.nextInt(100) + 1;
        
        if (roll <= GameConstants.COMMON_DROP_RATE) {
            return common;
        } else if (roll <= GameConstants.COMMON_DROP_RATE + GameConstants.UNCOMMON_DROP_RATE) {
            return uncommon;
        } else {
            return rare;
        }
    }
    
    /**
     * DRY Helper: Rarity'ye göre silah oluştur
     */
    private Weapon createWeaponByRarity() {
        int roll = random.nextInt(100) + 1;
        
        if (roll <= GameConstants.COMMON_DROP_RATE) {
            // Tabanca (Common)
            return new Weapon("Tabanca", GameConstants.GUN_ID, 
                            GameConstants.GUN_DAMAGE, GameConstants.GUN_PRICE);
        } else if (roll <= GameConstants.COMMON_DROP_RATE + GameConstants.UNCOMMON_DROP_RATE) {
            // Kılıç (Uncommon)
            return new Weapon("Kılıç", GameConstants.SWORD_ID, 
                            GameConstants.SWORD_DAMAGE, GameConstants.SWORD_PRICE);
        } else {
            // Tüfek (Rare)
            return new Weapon("Tüfek", GameConstants.RIFLE_ID, 
                            GameConstants.RIFLE_DAMAGE, GameConstants.RIFLE_PRICE);
        }
    }
    
    /**
     * DRY Helper: Rarity'ye göre zırh oluştur
     */
    private Armor createArmorByRarity() {
        int roll = random.nextInt(100) + 1;
        
        if (roll <= GameConstants.COMMON_DROP_RATE) {
            // Hafif (Common)
            return new Armor("Hafif", GameConstants.LIGHT_ARMOR_ID, 
                           GameConstants.LIGHT_ARMOR_BLOCK, GameConstants.LIGHT_ARMOR_PRICE);
        } else if (roll <= GameConstants.COMMON_DROP_RATE + GameConstants.UNCOMMON_DROP_RATE) {
            // Orta (Uncommon)
            return new Armor("Orta", GameConstants.MEDIUM_ARMOR_ID, 
                           GameConstants.MEDIUM_ARMOR_BLOCK, GameConstants.MEDIUM_ARMOR_PRICE);
        } else {
            // Ağır (Rare)
            return new Armor("Ağır", GameConstants.HEAVY_ARMOR_ID, 
                           GameConstants.HEAVY_ARMOR_BLOCK, GameConstants.HEAVY_ARMOR_PRICE);
        }
    }
}
