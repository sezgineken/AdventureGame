package model;

import interfaces.Combatable;

/**
 * Abstract base class for game characters
 * Implements Combatable interface
 * Cleaned: Removed unused setters (immutable after creation)
 */
public abstract class GameChar implements Combatable {
    private final int id;
    private final String name;
    private final int damage;
    private final int health;
    private final int money;

    public GameChar(int id, String name, int damage, int health, int money) {
        this.id = id;
        this.name = name;
        this.damage = damage;
        this.health = health;
        this.money = money;
    }

    public int getId() {
        return id;
    }

    public int getMoney() {
        return money;
    }

    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public int getDamage() {
        return damage;
    }

    @Override
    public String getName() {
        return name;
    }

    // Interface methods that don't apply to immutable character templates
    @Override
    public void setHealth(int health) {
        // Character templates are immutable
        throw new UnsupportedOperationException("GameChar is immutable");
    }

    @Override
    public void setDamage(int damage) {
        // Character templates are immutable
        throw new UnsupportedOperationException("GameChar is immutable");
    }
}
