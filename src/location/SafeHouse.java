package location;

import constants.Messages;
import model.Player;

/**
 * Safe house location where player can heal
 * OCP: Override isWinningLocation to indicate this is where game can be won
 */
public class SafeHouse extends NormalLoc {
    public SafeHouse(Player player) {
        super(player, Messages.SAFE_HOUSE);
    }
    
    @Override
    public boolean isWinningLocation() {
        return true;
    }

    @Override
    public boolean onLocation() {
        System.out.println("**************************");
        System.out.println(Messages.SAFE_HOUSE_MESSAGE);
        System.out.println(Messages.HEALTH_RESTORED);
        System.out.println("**************************");
        this.getPlayer().fullHeal();
        
        // ÖDEV 1: Tüm ödüller toplandıysa oyunu kazan
        System.out.println(Messages.CHECKING_WIN_CONDITION);
        if (this.getPlayer().getInventory().hasAllRewards()) {
            System.out.println();
            System.out.println(Messages.GAME_WON);
            System.out.println();
            System.out.println("Toplanan Ödüller:");
            for (String reward : this.getPlayer().getInventory().getRewards()) {
                System.out.println("✓ " + reward);
            }
            System.out.println();
            return false; // Oyunu bitir
        } else {
            System.out.println("Henüz tüm ödülleri toplamadınız. Maceraya devam edin!");
            System.out.println("Mevcut Ödülleriniz: " + this.getPlayer().getInventory().getRewards());
        }
        
        return true;
    }
}

