package game;

import game.characters.Character;
import game.characters.Player;
import game.interfaces.FightCallback;


public class MortalKombat {

    private final int sleepTimeMilli = 1000;

    public void fight(Character player, Character monster, FightCallback fightCallback) {
        
        Runnable runnable = () -> {
            
            int turn = 1;
            
            boolean isFightEnded = false;

            while (!isFightEnded) {

                System.out.printf("----Ход: %s ----\n", turn);
                
                if (turn++ % 2 != 0)
                {
                    isFightEnded = makeHit(monster, player, fightCallback);

                } else
                {
                    isFightEnded = makeHit(player, monster, fightCallback);
                }
                try {

                    Thread.sleep(sleepTimeMilli);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        
        Thread thread = new Thread(runnable);
        thread.setName("Mortal Kombat thread");
        thread.start();
    }

    
    private Boolean makeHit(Character defender, Character attacker, FightCallback fightCallback) {
        
        int hit = attacker.fight();
        
        int defenderHealth = defender.getHealth() - hit;
        
        if (hit != 0) {


            System.out.printf("%s Нанес удар в %d единиц!\n", attacker.getName(), hit);

            System.out.printf( "У %s осталось %d единиц здоровья...\n", defender.getName(), defenderHealth );


        } else {
            
            System.out.printf("%s промахнулся!\n", attacker.getName());
        }

        if (defenderHealth <= 0 && defender instanceof Player) {
            
            System.out.println("Ты мертв...");

            fightCallback.fightLost();

            return true;

        } else if (defenderHealth <= 0) {
            
            System.out.printf("Враг побежден! Вы получаете %d опыт и %d золота\n", defender.getExperience(), defender.getGold());
            attacker.setExperience(attacker.getExperience() + defender.getExperience());
            attacker.setGold(attacker.getGold() + defender.getGold());
            
            fightCallback.fightWin();

            return true;
        } else {
            
            defender.setHealth(defenderHealth);
            return false;
        }
    }
}