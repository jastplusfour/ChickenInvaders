package ChickenInvaders;

/**
 * Created by Макс on 26.05.2016.
 */
public class GameProgress {

    public static final GameProgress instance = new GameProgress();
    public int numOfEnemies = 0;
    public int lvl = 1;

    public static final int OFFSET = 100;








    public void resetValues() {
        numOfEnemies = 0;
    }

    public boolean isNoMoreEnemies() {
        if (GameManager.instance.getCurrentScene().getEntities().size() <= 2)
            return true;
        return false;
    }
}
