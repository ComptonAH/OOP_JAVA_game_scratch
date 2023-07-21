package smth;

import smth.Units.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static ArrayList<Unit> team_1 = new ArrayList<>();
    public static ArrayList<Unit> team_2 = new ArrayList<>();
    public static ArrayList<Unit> turn_order = new ArrayList<>();

    static Boolean isTeamDie(ArrayList<Unit> team) {
        for (Unit unit : team) {
            if (!unit.state.equals(unit.states.get(2))) return false;
        }
        return true;
    }

    public static void main(String[] args) {

        // HW_1
//        smth.Units.Crossbowman crossbowman = new smth.Units.Crossbowman();
//        System.out.println(crossbowman);
//        smth.Units.Sniper sniper = new smth.Units.Sniper("Clark");
//        System.out.println(sniper);
//        smth.Units.Mage mage = new smth.Units.Mage("Lisa");
//        System.out.println(mage);
//        smth.Units.Monk monk = new smth.Units.Monk("Clarissa");
//        System.out.println(monk);
//        smth.Units.Peasant peasant = new smth.Units.Peasant("Knocker");
//        System.out.println(peasant);
//        smth.Units.Spearman spearman = new smth.Units.Spearman("Leyla");
//        System.out.println(spearman);
//        smth.Units.Rogue rogue = new smth.Units.Rogue(smth.Units.Instances.smth.Units.Rogue.name(),10,10);
//        System.out.println(rogue);
//        System.out.println("--------------");
        // HW_2

//
        for (int i = 1; i < 11; i++) {
            int rng = new Random().nextInt(1, 5);
//            if(i == 1 || i == 2 || i == 4) rng = 3; //Строка для проверки работы "step";
            switch (rng) {
                case 1 -> team_1.add(new Rogue(Instances.Rogue.name(), 1, i));
                case 2 -> team_1.add(new Mage(Instances.Mage.name(), 1, i));
                case 3 -> team_1.add(new Peasant(Instances.Peasant.name(), 1, i));
                case 4 -> team_1.add(new Sniper(Instances.Sniper.name(), 1, i));
            }
        }
        for (int i = 1; i < 11; i++) {
            int rng = new Random().nextInt(1, 5);
            switch (rng) {
                case 1 -> team_2.add(new Spearman(Instances.Spearman.name(), 10, i));
                case 2 -> team_2.add(new Crossbowman(Instances.Crossbowman.name(), 10, i));
                case 3 -> team_2.add(new Monk(Instances.Monk.name(), 10, i));
                case 4 -> team_2.add(new Peasant(Instances.Peasant.name(), 10, i));
            }
        }
        System.out.println("---------------");
        System.out.println("Team 1:");
        System.out.println();
        for (Unit character :
                team_1) {
            System.out.println(character.getInfo());
        }
        System.out.println("---------------");
        System.out.println("Team 2:");
        System.out.println();
        for (Unit character :
                team_2) {
            System.out.println(character.getInfo());
        }
        System.out.println("---------------");

        // HW_3
//        team_1.get(1).distanceToNearestEnemy(team_2);

        // HW_4

        turn_order.addAll(team_1);
        turn_order.addAll(team_2);
        turn_order.sort(Comparator.comparingInt(o -> o.initiation));

        for (Unit unit :
                turn_order) {
            System.out.println(unit.name);
        }
        Scanner in = new Scanner(System.in);
        while (true) {

            View.view();
            in.nextLine();

            for (Unit unit : turn_order) {
                if (team_2.contains(unit)) {
                    unit.step(team_2, team_1);
                } else unit.step(team_1, team_2);
            }
            if (isTeamDie(team_1)) {
                System.out.println("Team 2 won");
                break;
            } else if (isTeamDie(team_2)) {
                System.out.println("Team 1 won");
                break;
            }
        }
    }
}
