package game;

import game.characters.Character;
import game.characters.Goblin;
import game.characters.Player;
import game.characters.Skeleton;
import game.interfaces.FightCallback;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WorldOfGames {

    private static BufferedReader br;

    private static Character player = null;

    private static MortalKombat battleScene = null;

    public static void main(String[] args) {

        br = new BufferedReader(new InputStreamReader(System.in));

        battleScene = new MortalKombat();

        System.out.println("Введите имя игрока:");

        try {
            command(br.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void command(String string) throws IOException {

        if (player == null) {

            player = new Player(
                    string,
                    100,
                    20,
                    20,
                    0,
                    0,
                    30,
                    2
            );
            System.out.printf("Спасти нашу планету вызвался %s! Да пребудет с ним сила куриных крылышек!\n", player.getName());

            printNavigation();
        }

        switch (string) {
            case "1": {

                System.out.println("Барыги нет");
                command(br.readLine());

            }
            break;
            case "2": {
                commitFight();
            }
            break;
            case "3":
                System.exit(1);
                break;
            case "да":
                command("2");
                break;
            case "нет": {
                printNavigation();
                command(br.readLine());
            }
        }

        command(br.readLine());
    }

    private static void commitFight() {
        battleScene.fight(player, createMonster(), new FightCallback() {
            @Override
            public void fightWin() {

                System.out.printf("%s победил! Теперь у Вас %d опыта и %d золота, а также осталось %d единиц здоровья.\n"
                        , player.getName(), player.getExperience(), player.getGold(), player.getHealth());


                System.out.println("Желаете продолжить поход или вернуться в город? (да/нет)");

                try {

                    command(br.readLine());

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void fightLost() {

            }
        });
    }

    private static void printNavigation() {
        System.out.println("Куда Вы хотите пойти?");
        System.out.println("1. К Барыге");
        System.out.println("2. В темный лес");
        System.out.println("3. Выход");
    }

    private static Character createMonster() {

        int random = (int) (Math.random() * 10);

        if (random % 2 == 0) return new Goblin(
                "Гоблин",
                50,
                10,
                10,
                100,
                20,
                30,
                3

        );
        else return new Skeleton(
                "Скелет",
                25,
                20,
                20,
                100,
                10,
                30,
                3
        );
    }


}