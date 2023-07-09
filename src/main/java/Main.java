import java.lang.reflect.Constructor;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        // HW_1
        Crossbowman crossbowman = new Crossbowman();
//        System.out.println(crossbowman);
//        Sniper sniper = new Sniper("Clark");
//        System.out.println(sniper);
//        Mage mage = new Mage("Lisa");
//        System.out.println(mage);
//        Monk monk = new Monk("Clarissa");
//        System.out.println(monk);
//        Peasant peasant = new Peasant("Knocker");
//        System.out.println(peasant);
//        Spearman spearman = new Spearman("Leyla");
//        System.out.println(spearman);
//        Rogue rogue = new Rogue("Delrow");
//        System.out.println(rogue);
//        System.out.println("--------------");
        // HW_2
        ArrayList<Unit> team_1 = new ArrayList<>();
        ArrayList<Unit> team_2 = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            int rng = new Random().nextInt(7);
            switch (rng) {
                case 0 -> team_1.add(new Rogue());
                case 1 -> team_1.add(new Mage());
                case 2 -> team_1.add(new Spearman());
                case 3 -> team_1.add(new Crossbowman());
                case 4 -> team_1.add(new Monk());
                case 5 -> team_1.add(new Peasant());
                default -> team_1.add(new Sniper());
            }
        }
        for (int i = 0; i < 10; i++) {
            int rng = new Random().nextInt(7);
            switch (rng) {
                case 0 -> team_2.add(new Rogue());
                case 1 -> team_2.add(new Mage());
                case 2 -> team_2.add(new Spearman());
                case 3 -> team_2.add(new Crossbowman());
                case 4 -> team_2.add(new Monk());
                case 5 -> team_2.add(new Peasant());
                default -> team_2.add(new Sniper());
            }
        }

        for (Unit character :
                team_1) {
            System.out.println(character.getInfo());
        }
        System.out.println("---------------");
        for (Unit character :
                team_2) {
            System.out.println(character.getInfo());
        }
    }
}
