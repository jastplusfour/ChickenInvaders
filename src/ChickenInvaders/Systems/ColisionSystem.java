package ChickenInvaders.Systems;

import ChickenInvaders.Components.Flags.Bullet;
import ChickenInvaders.Components.Collision;
import ChickenInvaders.Components.Flags.Enemy;
import ChickenInvaders.Components.Health;
import ChickenInvaders.Components.Position;
import ChickenInvaders.GameManager;
import Engine.Entity;
import Engine.Scene;
import Engine.System;

import java.util.ArrayList;


/**
 * Created by Макс on 25.05.2016.
 */
public class ColisionSystem extends System{


    @Override
    public void update(double dt) {
        Scene gameScene = GameManager.instance.getCurrentScene();
        for (Entity e1 : (ArrayList<Entity>)GameManager.instance.getCurrentScene().getEntities().clone()) {

            Collision colision1  = e1.getComponent(Collision.class);
            Bullet    bullet1    = e1.getComponent(Bullet.class);
            Position  position1  = e1.getComponent(Position.class);

            if (colision1  == null ||
                bullet1    == null ||
                position1  == null) continue;

            colision1.rectangle.x = position1.value.x;
            colision1.rectangle.y = position1.value.y;

            for (Entity e2 : gameScene.getEntities()){
                if (e1 == e2)
                    continue;

                Collision colision2  = e2.getComponent(Collision.class);
                Position  position2  = e2.getComponent(Position.class);
                Health helth      = e2.getComponent(Health.class);

                if (colision2  == null ||
                    position2  == null ||
                        helth  == null)  continue;

                if (e1.hasComponent(Enemy.class) &&
                        e2.hasComponent(Enemy.class))
                    continue;


                colision2.rectangle.x = position2.value.x;
                colision2.rectangle.y = position2.value.y;

                if (colision1.rectangle.intersects(colision2.rectangle)) {
                    gameScene.getEntities().remove(e1);
                    helth.value -= 1;
                    break;
                }
            }


        }
    }
}
