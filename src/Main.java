import ChickenInvaders.GameManager;
import ChickenInvaders.Scenes.GameOverScene;
import ChickenInvaders.Scenes.SecretGameScene666;
import ChickenInvaders.Scenes.StartGameScene;


/**
 * Created by Макс on 19.03.2016.
 */
public class Main {
    public static void main(String[] args) {
        GameManager.instance.setScene(new SecretGameScene666());
        GameManager.instance.run();
    }
}
