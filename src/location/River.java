package location;

import constants.GameConstants;
import constants.Messages;
import model.Bear;
import model.Player;

/**
 * River battle location with bears
 */
public class River extends BattleLoc {
    public River(Player player) {
        super(player, Messages.RIVER, new Bear(), "Water", GameConstants.RIVER_MAX_OBSTACLES);
    }
}

