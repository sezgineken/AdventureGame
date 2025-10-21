package interfaces;

/**
 * Interface for entities that can take damage
 */
public interface Damageable {
    int getHealth();
    void setHealth(int health);
    boolean isAlive();
}

