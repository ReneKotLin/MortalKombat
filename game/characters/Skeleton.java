package game.characters;

public class Skeleton extends Character {
    public Skeleton(String name,
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
        return String.format("Скелетончик %s здоровье:%d", getName(), getHealth());
    }
}
