package location;

import constants.Messages;
import interfaces.Purchasable;
import managers.MenuManager;
import model.*;
import utils.InputHandler;

/**
 * Tool store location where player can buy weapons and armor
 * Refactored to reduce code duplication
 */
public class ToolStore extends NormalLoc {
    private final InputHandler inputHandler;
    private final MenuManager menuManager;

    public ToolStore(Player player) {
        super(player, Messages.TOOL_STORE);
        this.inputHandler = InputHandler.getInstance();
        this.menuManager = new MenuManager(inputHandler);
    }

    @Override
    public boolean onLocation() {
        System.out.println(Messages.WELCOME_STORE);
        boolean showMenu = true;
        
        while (showMenu) {
            int selectCase = menuManager.displayStoreMenu();
            
            switch (selectCase) {
                case 1:
                    printWeapon();
                    buyWeapon();
                    break;
                case 2:
                    printArmor();
                    buyArmor();
                    break;
                case 3:
                    System.out.println(Messages.COME_AGAIN);
                    showMenu = false;
                    break;
            }
        }
        return true;
    }

    public void printWeapon() {
        System.out.println(Messages.WEAPONS_TITLE);
        for (Weapon w : Weapon.weapons()) {
            System.out.println(w.getId() + "- " + w.getName() + 
                    " <Para : " + w.getPrice() + " , Hasar: " + w.getDamage());
        }
        System.out.println("0- Çıkış yap");
    }

    public void buyWeapon() {
        System.out.print(Messages.SELECT_WEAPON);
        int selectWeaponID = inputHandler.readInt();

        while (selectWeaponID < 0 || selectWeaponID > Weapon.weapons().length) {
            System.out.print(Messages.INVALID_VALUE);
            selectWeaponID = inputHandler.readInt();
        }

        if (selectWeaponID != 0) {
            Weapon selectedWeapon = Weapon.getWeaponObjById(selectWeaponID);
            purchaseItem(selectedWeapon, true);
        }
    }

    public void printArmor() {
        System.out.println(Messages.ARMORS_TITLE);
        for (Armor a : Armor.armors()) {
            System.out.println(a.getId() + "- " + a.getName() + 
                    " , Zırh: " + a.getBlock() + " Para : " + a.getPrice());
        }
        System.out.println("0- Çıkış yap");
    }

    public void buyArmor() {
        System.out.print(Messages.SELECT_ARMOR);
        int selectArmorID = inputHandler.readInt();

        while (selectArmorID < 0 || selectArmorID > Armor.armors().length) {
            System.out.print(Messages.INVALID_VALUE);
            selectArmorID = inputHandler.readInt();
        }

        if (selectArmorID != 0) {
            Armor selectedArmor = Armor.getArmorObjByID(selectArmorID);
            purchaseItem(selectedArmor, false);
        }
    }

    /**
     * Generic purchase method to reduce code duplication
     * Follows DRY principle
     */
    private void purchaseItem(Purchasable item, boolean isWeapon) {
        if (item == null) {
            return;
        }

        if (item.getPrice() > this.getPlayer().getMoney()) {
            System.out.println(Messages.INSUFFICIENT_BALANCE);
        } else {
            String message = isWeapon ? 
                    String.format(Messages.WEAPON_PURCHASED, item.getName()) :
                    String.format(Messages.ARMOR_PURCHASED, item.getName());
            System.out.println("********************");
            System.out.println(message);
            
            int balance = this.getPlayer().getMoney() - item.getPrice();
            this.getPlayer().setMoney(balance);
            System.out.println(String.format(Messages.REMAINING_BALANCE, this.getPlayer().getMoney()));
            System.out.println("********************");
            
            if (isWeapon) {
                this.getPlayer().getInventory().setWeapon((Weapon) item);
            } else {
                this.getPlayer().getInventory().setArmor((Armor) item);
            }
        }
    }
}

