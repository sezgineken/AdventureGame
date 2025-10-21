package location;

import constants.GameConstants;
import constants.Messages;
import model.Player;
import model.Zombie;

/**
 * Cave battle location with zombies
 */
public class Cave extends BattleLoc {
    public Cave(Player player) {
        super(player, Messages.CAVE, new Zombie(), "Food", GameConstants.CAVE_MAX_OBSTACLES);
    }
}

