package ChickenInvaders.Scenes;

import ChickenInvaders.Components.Animation.FadeOut;
import ChickenInvaders.Components.Position;
import ChickenInvaders.Components.Sprite;
import ChickenInvaders.GameManager;
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
public class StartGameScene extends Scene {

    Entity startBackGround = new Entity();

    Component sprite   = new Sprite("images/startscreen.png");
    Component position = new Position(new Vector2i(0,0));
    Component fadeOut  = new FadeOut(5);

    System renderSystem = new RenderSystem();
    System fadeOutSystem = new FadeOutSystem();

    double initianalTime = 0;


    public StartGameScene() {
        startBackGround.addComponent(sprite);
        startBackGround.addComponent(position);
        startBackGround.addComponent(fadeOut);

        this.addEntity(startBackGround);
        this.addSystem(renderSystem);
        this.addSystem(fadeOutSystem);
//        GameManager.instance.audioManager.play("audio/sandstorm.wav");
    }

    @Override
    public void update(Double dt) {
            super.update(dt);
        initianalTime += dt;
        if (initianalTime > 5) {
            GameManager.instance.setScene(new GameScene());
//            GameManager.instance.audioManager.stop("audio/1.wav");
        }
    }
}
