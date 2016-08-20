package ChickenInvaders.Systems;

import ChickenInvaders.Components.Flags.Hero;
import ChickenInvaders.Components.Health;
import ChickenInvaders.EntitiesFactory;
import ChickenInvaders.GameManager;
import ChickenInvaders.GameProgress;
import ChickenInvaders.Scenes.GameOverScene;
import Engine.Entity;
import Engine.MathMagic.Vector2i;
import Engine.Scene;
import Engine.System;

import java.util.ArrayList;

/**
 * Created by Макс on 25.05.2016.
 */
public class GameLogicSystem extends System{
    @Override
    public void update(double dt) {
        Scene gameScene = GameManager.instance.getCurrentScene();
        for (Entity entity : (ArrayList<Entity>)GameManager.instance.getCurrentScene().getEntities().clone()) {

            if (GameProgress.instance.isNoMoreEnemies()) {

                for (int i = 0; i < GameProgress.instance.numOfEnemies; i++ ) {

                    gameScene.addEntity(EntitiesFactory.createEnemy(new Vector2i(50 + i * GameProgress.OFFSET, 50)));
                    gameScene.addEntity(EntitiesFactory.createEnemy(new Vector2i(50 + i * GameProgress.OFFSET, 100)));
                }
                GameProgress.instance.numOfEnemies++;
            }



            Health health = entity.getComponent(Health.class);
            Hero   hero   = entity.getComponent(Hero.class);

            if (health == null) continue;

            if (health.value <= 0) {
                gameScene.getEntities().remove(entity);
            }

            if (health.value <= 0 && hero != null) {
                java.lang.System.out.println("OH NO");
                GameManager.instance.audioManager.play("audio/sadvolin.wav");
                GameManager.instance.audioManager.stop("audio/sandstorm.wav");
                GameManager.instance.audioManager.stop("audio/dubstep.wav");
                GameManager.instance.setScene(new GameOverScene());
                break;
            }




        }
    }
}
