package model;

import interfaces.Combatable;
import interfaces.Damageable;
import interfaces.Healable;

/**
 * Represents the player character
 * Implements Combatable, Damageable, and Healable interfaces
 * Cleaned: Removed unused charName field and methods
 */
public class Player implements Combatable, Damageable, Healable {
    private int damage;
    private int health;
    private int maxHealth;
    private int money;
    private final String name; // Player's entered name
    private Inventory inventory;

    public Player(String name) {
        this.name = name;
        this.inventory = new Inventory();
    }

    /**
     * Initialize player with selected character stats
     */
    public void initializeWithCharacter(GameChar gameChar) {
        if (gameChar != null) {
            this.damage = gameChar.getDamage();
            this.maxHealth = gameChar.getHealth();
            this.health = gameChar.getHealth();
            this.money = gameChar.getMoney();
        }
    }

    public void printInfo() {
        System.out.println("Silahınız: " + this.inventory.getWeapon().getName() +
                ", Zırhınız: " + this.inventory.getArmor().getName() +
                ", Bloklamanız: " + this.inventory.getArmor().getBlock() +
                ", Hasarınız: " + getTotalDamage() +
                ", Sağlığınız: " + health +
                ", Paranız: " + money);
    }

    public int getTotalDamage() {
        return damage + this.inventory.getWeapon().getDamage();
    }

    @Override
    public int getDamage() {
        return damage;
    }

    @Override
    public void setDamage(int damage) {
        this.damage = damage;
    }

    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public void setHealth(int health) {
        this.health = Math.max(0, health);
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    @Override
    public String getName() {
        return name;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        if (inventory != null) {
            this.inventory = inventory;
        }
    }

    @Override
    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    @Override
    public boolean isAlive() {
        return health > 0;
    }

    @Override
    public void heal(int amount) {
        this.health = Math.min(this.health + amount, this.maxHealth);
    }

    @Override
    public void fullHeal() {
        this.health = this.maxHealth;
    }
}
