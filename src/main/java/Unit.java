import java.util.Random;

public abstract class Unit implements InGameInterface {
    protected int movement_points, attack, defence, initiation, luck, attack_range;
    protected int health_points;
    protected String name;

    static int archer_stat_roll() {
        return new Random().nextInt(1, 8);
    }

    static int magic_stat_roll() {
        return new Random().nextInt(1, 6);
    }

    static int melee_stat_roll() {
        return new Random().nextInt(1, 10);
    }


    public String getInfo(){
        return name;
    }
}

