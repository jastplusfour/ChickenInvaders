package ChickenInvaders.Scenes;

import ChickenInvaders.Components.Animation.FadeIn;
import ChickenInvaders.Components.Position;
import ChickenInvaders.Components.Sprite;
import ChickenInvaders.GameManager;
import ChickenInvaders.GameProgress;
import ChickenInvaders.Systems.Animation.FadeInSystem;
import ChickenInvaders.Systems.Animation.FadeOutSystem;
import ChickenInvaders.Systems.RenderSystem;
import Engine.Component;
import Engine.Entity;
import Engine.MathMagic.Vector2i;
import Engine.Scene;
import Engine.System;

/**
 * Created by Макс on 25.05.2016.
 */
public class GameOverScene extends Scene {

    Entity gameOverBackGround1 = new Entity();
    Entity gameOverBackGround2 = new Entity();

    Component sprite   = new Sprite("images/gameover.png", 0);
    Component position = new Position(new Vector2i(0,0));
    Component fadeIn   = new FadeIn(5);

    Component sprite2   = new Sprite("images/sasha.png", 0);
    Component position2 = new Position(new Vector2i(270,300));
    Component fadeIn2   = new FadeIn(5);

    System renderSystem  = new RenderSystem();
    System fadeInSystem  = new FadeInSystem();


    double initianalTime = 0;


    public GameOverScene() {
        gameOverBackGround1.addComponent(sprite);
        gameOverBackGround1.addComponent(position);
        gameOverBackGround1.addComponent(fadeIn);

        gameOverBackGround2.addComponent(sprite2);
        gameOverBackGround2.addComponent(position2);
        gameOverBackGround2.addComponent(fadeIn2);

        this.addEntity(gameOverBackGround1);
        this.addEntity(gameOverBackGround2);
        this.addSystem(renderSystem);
        this.addSystem(fadeInSystem);
//        GameManager.instance.audioManager.play("audio/sandstorm.wav");
    }

    @Override
    public void update(Double dt) {
        super.update(dt);
        initianalTime += dt;
        if (initianalTime > 10) {
            GameManager.instance.audioManager.stop("audio/sadvolin.wav");
            GameScene gameScene = new GameScene();
            GameProgress.instance.resetValues();
            GameManager.instance.setScene(gameScene);
        }
    }
}
