import java.util.ArrayList;

public interface InGameInterface {
    Unit step(ArrayList<Unit> allyTeam, ArrayList<Unit> enemyTeam);
    String getInfo();
}
