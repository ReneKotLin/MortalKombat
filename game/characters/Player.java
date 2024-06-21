package game.characters;

public class Player extends Character {

    public Player(String name,
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
        return String.format("Игрокгода %s здоровье:%d", getName(), getHealth());
    }
}
