import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        // HW_1
//        Crossbowman crossbowman = new Crossbowman();
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
//        Rogue rogue = new Rogue(Instances.Rogue.name(),10,10);
//        System.out.println(rogue);
//        System.out.println("--------------");
        // HW_2
        ArrayList<Unit> team_1 = new ArrayList<>();
        ArrayList<Unit> team_2 = new ArrayList<>();
//
        for (int i = 0; i < 10; i++) {
            int rng = new Random().nextInt(7);
//            if(i == 0) rng = 3; Строка для проверки работы "step";
            switch (rng) {
                case 0 -> team_1.add(new Rogue(Instances.Rogue.name(),10,10));
                case 1 -> team_1.add(new Mage(Instances.Mage.name(),5,7));
                case 2 -> team_1.add(new Spearman(Instances.Spearman.name(),3,1));
                case 3 -> team_1.add(new Crossbowman(Instances.Crossbowman.name(),8,4));
                case 4 -> team_1.add(new Monk(Instances.Monk.name(),1,2));
                case 5 -> team_1.add(new Peasant(Instances.Peasant.name(),1,1));
                default -> team_1.add(new Sniper(Instances.Sniper.name(),6,6));
            }
        }
        for (int i = 0; i < 10; i++) {
            int rng = new Random().nextInt(7);
            switch (rng) {
                case 0 -> team_2.add(new Rogue(Instances.Rogue.name(),6,7));
                case 1 -> team_2.add(new Mage(Instances.Mage.name(),3,8));
                case 2 -> team_2.add(new Spearman(Instances.Spearman.name(),2,4));
                case 3 -> team_2.add(new Crossbowman(Instances.Crossbowman.name(),5,3));
                case 4 -> team_2.add(new Monk(Instances.Monk.name(),9,4));
                case 5 -> team_2.add(new Peasant(Instances.Peasant.name(),3,3));
                default -> team_2.add(new Sniper(Instances.Sniper.name(),6,8));
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
        System.out.println("---------------");

        // HW_3
//        team_1.get(1).distanceToNearestEnemy(team_2);

        // HW_4
        team_1.get(0).step(team_1,team_2);
    }
}
