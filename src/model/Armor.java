package model;

import constants.GameConstants;
import interfaces.Purchasable;

/**
 * Represents armor in the game
 * Implements Purchasable interface
 */
public class Armor implements Purchasable {
    private int id;
    private String name;
    private int block;
    private int price;

    public Armor(String name, int id, int block, int price) {
        this.name = name;
        this.id = id;
        this.block = block;
        this.price = price;
    }

    public static Armor[] armors() {
        Armor[] armorList = new Armor[3];
        armorList[0] = new Armor("Hafif", GameConstants.LIGHT_ARMOR_ID, 
                                 GameConstants.LIGHT_ARMOR_BLOCK, GameConstants.LIGHT_ARMOR_PRICE);
        armorList[1] = new Armor("Orta", GameConstants.MEDIUM_ARMOR_ID, 
                                 GameConstants.MEDIUM_ARMOR_BLOCK, GameConstants.MEDIUM_ARMOR_PRICE);
        armorList[2] = new Armor("Ağır", GameConstants.HEAVY_ARMOR_ID, 
                                 GameConstants.HEAVY_ARMOR_BLOCK, GameConstants.HEAVY_ARMOR_PRICE);
        return armorList;
    }

    public static Armor getArmorObjByID(int id) {
        for (Armor a : Armor.armors()) {
            if (a.getId() == id) {
                return a;
            }
        }
        return null;
    }

    @Override
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBlock() {
        return block;
    }

    public void setBlock(int block) {
        this.block = block;
    }

    @Override
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}

