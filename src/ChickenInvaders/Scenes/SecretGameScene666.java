package ChickenInvaders.Scenes;

import ChickenInvaders.EntitiesFactory;
import ChickenInvaders.GameManager;
import ChickenInvaders.Systems.*;
import Engine.MathMagic.Vector2i;
import Engine.Scene;
import Engine.System;

/**
 * Created by Макс on 26.05.2016.
 */
public class SecretGameScene666 extends Scene {
    System render          = new RenderSystem();
    System movementSystem  = new MovementSystem();
    AISystem aisystem      = new AISystem();
    System inputSystem     = new InputSystem();
    System collisionSystem = new ColisionSystem();
    System gameLogicSystem = new GameLogicSystem();

    private float time = 0;
    private boolean START_MLG = false;

    public SecretGameScene666() {

        addEnemies();

        GameManager.instance.audioManager.play("audio/mlg/mlgsecretlvl.wav");

        this.addSystem(inputSystem);
        this.addSystem(aisystem);
        this.addSystem(movementSystem);
        this.addSystem(collisionSystem);
        this.addSystem(gameLogicSystem);
        aisystem.setX(500);
        this.addSystem(render);
    }

    @Override
    public void update(Double dt) {
        super.update(dt);
        time += dt;
        java.lang.System.out.println(time);

        if (time > 13) {
            aisystem.setX(10);

            if(START_MLG == false) {
                GameManager.instance.audioManager.play("audio/mlg/MOM_GET_THE_CAMERA.wav");
                GameManager.instance.audioManager.play("audio/mlg/WOMBO.wav");
                START_MLG = true;
            }
        }



    }

    private void addEnemies() {
        this.addEntity(EntitiesFactory.createBackGround());
        this.addEntity(EntitiesFactory.createHeroSpaceShip());
        this.addEntity(EntitiesFactory.createEnemy(new Vector2i(0,0)));
        this.addEntity(EntitiesFactory.createEnemy(new Vector2i(100,0)));
        this.addEntity(EntitiesFactory.createEnemy(new Vector2i(200,0)));
        this.addEntity(EntitiesFactory.createEnemy(new Vector2i(300,0)));
        this.addEntity(EntitiesFactory.createEnemy(new Vector2i(400,0)));

        this.addEntity(EntitiesFactory.createEnemy(new Vector2i(0,100)));
        this.addEntity(EntitiesFactory.createEnemy(new Vector2i(100,100)));
        this.addEntity(EntitiesFactory.createEnemy(new Vector2i(200,100)));
        this.addEntity(EntitiesFactory.createEnemy(new Vector2i(300,100)));
        this.addEntity(EntitiesFactory.createEnemy(new Vector2i(400,100)));
    }
}
