package interfaces;

/**
 * Interface for entities that can be healed
 */
public interface Healable {
    void heal(int amount);
    void fullHeal();
    int getHealth();
    int getMaxHealth();
}

