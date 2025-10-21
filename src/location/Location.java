package location;

import model.Player;

/**
 * Abstract base class for all game locations
 * Immutable after creation (SOLID: prefer composition over inheritance)
 * OCP: isWinningLocation() method prevents instanceof checks
 */
public abstract class Location {
    private final Player player;
    private final String name;

    public Location(Player player, String name) {
        this.player = player;
        this.name = name;
    }

    public abstract boolean onLocation();
    
    /**
     * OCP: Prevents instanceof check in Game class
     * Override this for locations where game can be won
     */
    public boolean isWinningLocation() {
        return false;
    }

    public Player getPlayer() {
        return player;
    }

    public String getName() {
        return name;
    }
}
