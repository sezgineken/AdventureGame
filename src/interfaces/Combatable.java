package interfaces;

/**
 * Interface for entities that can engage in combat
 */
public interface Combatable {
    int getDamage();
    void setDamage(int damage);
    int getHealth();
    void setHealth(int health);
    String getName();
}

