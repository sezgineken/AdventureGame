package location;

import constants.GameConstants;
import constants.Messages;
import model.Player;
import model.Vampire;

/**
 * Forest battle location with vampires
 */
public class Forest extends BattleLoc {
    public Forest(Player player) {
        super(player, Messages.FOREST, new Vampire(), "Firewood", GameConstants.FOREST_MAX_OBSTACLES);
    }
}

