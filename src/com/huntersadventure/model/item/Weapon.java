package com.huntersadventure.model.item;

import com.huntersadventure.model.item.Item;

public class Weapon extends Item {
    /*
    Weapon is a subclass of Item that is used to create weapons.
    - It has the following attributes
    - String name;
    - String description;
    - Int damage;
    - String attackName;
     */

    int damage;
    String attackName;

    public Weapon() {
    }

    public Weapon(String name, String description, int damage) {
        super(name, description);
        this.damage = damage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public String getAttackName() {
        return attackName;
    }

    public void setAttackName(String attackName) {
        this.attackName = attackName;
    }

    @Override
    public String toString() {
        return "Weapon{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", damage=" + damage +
                ", attackName='" + attackName + '\'' +
                '}';
    }
}