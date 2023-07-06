import java.util.Random;
abstract class unit {
    public int health_points, movement_points, attack, defence, initiation, luck;

    static int archer_stat_roll(){
        return new Random().nextInt(1,8);
    }

    static int magic_stat_roll(){
        return new Random().nextInt(1,6);
    }
    static int melee_stat_roll(){
        return new Random().nextInt(1,10);
    }

}
