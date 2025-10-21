package model;

import interfaces.Combatable;
import interfaces.Damageable;

/**
 * Represents game obstacles/enemies
 * Implements Combatable and Damageable interfaces
 * Cleaned: Removed unused setters for immutable fields
 */
public class Obstacle implements Combatable, Damageable {
    private final String name;
    private final int id;
    private int damage;
    private int health;
    private final int award;
    private final int originalHealth;

    public Obstacle(String name, int id, int damage, int health, int award) {
        this.name = name;
        this.id = id;
        this.damage = damage;
        this.health = health;
        this.originalHealth = health;
        this.award = award;
    }

    @Override
    public String getName() {
        return name;
    }

    public int getId() {
        return id;
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

    public int getAward() {
        return award;
    }

    public int getOriginalHealth() {
        return originalHealth;
    }

    @Override
    public boolean isAlive() {
        return health > 0;
    }
}
