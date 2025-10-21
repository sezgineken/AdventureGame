package model;

import constants.GameConstants;
import interfaces.Purchasable;

/**
 * Represents weapons in the game
 * Implements Purchasable interface
 */
public class Weapon implements Purchasable {
    private String name;
    private int id;
    private int damage;
    private int price;

    public Weapon(String name, int id, int damage, int price) {
        this.name = name;
        this.id = id;
        this.price = price;
        this.damage = damage;
    }

    public static Weapon[] weapons() {
        Weapon[] weaponList = new Weapon[3];
        weaponList[0] = new Weapon("Kılıç", GameConstants.SWORD_ID, 
                                   GameConstants.SWORD_DAMAGE, GameConstants.SWORD_PRICE);
        weaponList[1] = new Weapon("Tabanca", GameConstants.GUN_ID, 
                                   GameConstants.GUN_DAMAGE, GameConstants.GUN_PRICE);
        weaponList[2] = new Weapon("Tüfek", GameConstants.RIFLE_ID, 
                                   GameConstants.RIFLE_DAMAGE, GameConstants.RIFLE_PRICE);
        return weaponList;
    }

    public static Weapon getWeaponObjById(int id) {
        for (Weapon w : Weapon.weapons()) {
            if (w.getId() == id) {
                return w;
            }
        }
        return null;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    @Override
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}

