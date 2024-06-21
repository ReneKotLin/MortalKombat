package game.characters;

import game.interfaces.Fighter;
import java.time.LocalTime;
import java.util.Random;

public abstract class Character implements Fighter {
    private String name;
    private int health = 100;
    private int strength;
    private int agility;
    private int experience;
    private int gold;
    private int boostStrengthMinute;
    private int agilityMultiplier;


    public Character(String name,
                     int health,
                     int strength,
                     int agility,
                     int experience,
                     int gold,
                     int boostStrengthMinute,
                     int agilityMultiplier) {
        this.name = name;
        this.health = health;
        this.strength = strength;
        this.gold = gold;
        this.agility = agility;
        this.experience = experience;
        this.boostStrengthMinute = boostStrengthMinute;
        this.agilityMultiplier = agilityMultiplier;

        System.out.printf("Был создан %s персонаж\n", name);

    }

    @Override
    public int fight() {
        if (agility * agilityMultiplier > getRandomValue()) return boostStrength(strength);
        else return 0;
    }


    /*
     * реализация логики критических ударов, бустудар каждые полчаса
     */
    private int boostStrength(int strength) {

        if (LocalTime.now().getMinute() == boostStrengthMinute)
            return strength * 2;

        return strength;
    }


    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getGold() {
        return gold;
    }

    public int getAgility() {
        return agility;
    }

    public int getStrength() {
        return strength;
    }

    public int getExperience() {
        return experience;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getRandomValue() {
        Random rand = new Random();
        return rand.nextInt(100);
    }

    @Override
    public String toString() {
        return String.format("Character %s здоровье:%d", name, health);
    }

}
