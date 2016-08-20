package ChickenInvaders.Systems;

import ChickenInvaders.Components.Flags.AI;
import ChickenInvaders.Components.Direction;
import ChickenInvaders.Components.Position;
import ChickenInvaders.EntitiesFactory;
import ChickenInvaders.GameManager;
import Engine.Entity;
import Engine.MathMagic.Vector2i;
import Engine.System;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Макс on 24.05.2016.
 */
public class AISystem extends System {

    private Random random = new Random();
    private Vector2i eggPosition = new Vector2i();
    private int offsetFromEnemy = 50;
    int x = 120;

    public void setX(int x) {
        this.x = x;
    }

    @Override
    public void update(double dt) {

        for (Entity e : (ArrayList<Entity>)GameManager.instance.getCurrentScene().getEntities().clone()) {

            Position position   = e.getComponent(Position.class);
            AI ai               = e.getComponent(AI.class);
            Direction direction = e.getComponent(Direction.class);

            if (position  == null ||
                ai        == null ||
                direction == null) continue;


            if (position.value.x > GameManager.instance.WIDTH) {
                position.value.y += 40;
                direction.setDirection(Direction.LEFT);
            }

            if (position.value.x < -50) {
                position.value.y += 40;
                direction.setDirection(Direction.RIGHT);
            }


            int fire = random.nextInt(x);
            eggPosition.set(position.value);
            eggPosition.add(0, offsetFromEnemy);

            if (fire == 3)
                GameManager.instance.getCurrentScene().addEntity(EntitiesFactory.createEgg(eggPosition));
        }






    }
}
