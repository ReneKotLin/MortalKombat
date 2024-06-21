package game.characters;

public class Goblin extends Character {

    public Goblin(String name,
                  int health,
                  int strength,
                  int agility,
                  int experience,
                  int gold,
                  int boostStrengthMinute,
                  int agilityMultiplier) {
        super(name, health, strength, agility, experience, gold, boostStrengthMinute, agilityMultiplier);
    }

    @Override
    public String toString() {
        return String.format("ГоблинДрочер %s здоровье:%d", getName(), getHealth());
    }
}
