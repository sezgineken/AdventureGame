package location;

import model.Player;

/**
 * Abstract class for normal (non-battle) locations
 */
public abstract class NormalLoc extends Location {

    public NormalLoc(Player player, String name) {
        super(player, name);
    }

    @Override
    public boolean onLocation() {
        return true;
    }
}

