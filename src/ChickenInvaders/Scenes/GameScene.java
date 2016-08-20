package ChickenInvaders.Scenes;

import ChickenInvaders.EntitiesFactory;
import ChickenInvaders.GameManager;
import ChickenInvaders.Systems.*;
import Engine.MathMagic.Vector2i;
import Engine.Scene;
import Engine.System;

/**
 * Created by Макс on 25.05.2016.
 */
public class GameScene extends Scene {

    System render          = new RenderSystem();
    System movementSystem  = new MovementSystem();
    System aisystem        = new AISystem();
    System inputSystem     = new InputSystem();
    System collisionSystem = new ColisionSystem();
    System gameLogicSystem = new GameLogicSystem();
    System cleanerSystem   = new CleanerSystem();


    public GameScene() {
//        addEnemies();
        this.addEntity(EntitiesFactory.createBackGround());
        this.addEntity(EntitiesFactory.createHeroSpaceShip());

        this.addSystem(inputSystem);
        this.addSystem(aisystem);
        this.addSystem(movementSystem);
        this.addSystem(collisionSystem);
        this.addSystem(gameLogicSystem);
        this.addSystem(render);
        this.addSystem(cleanerSystem);

//        GameManager.instance.audioManager.play("audio/dubstep.wav");
        GameManager.instance.audioManager.play("audio/sandstorm.wav");
    }

    @Override
    public void update(Double dt) {
        super.update(dt);
    }

}
