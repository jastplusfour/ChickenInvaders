package ChickenInvaders;

import ChickenInvaders.Components.*;
import ChickenInvaders.Components.Flags.AI;
import ChickenInvaders.Components.Flags.Bullet;
import ChickenInvaders.Components.Flags.Enemy;
import ChickenInvaders.Components.Flags.Hero;
import Engine.Component;
import Engine.Entity;
import Engine.MathMagic.Vector2i;

/**
 * Created by Макс on 25.05.2016.
 */
public class EntitiesFactory {

    public static Entity createEnemy(Vector2i p) {
        Entity enemy         = new Entity();

        Component sprite     = new Sprite("images/invader.png");
        Component position   = new Position(p);
        Component speed      = new Speed(3);
        Component direction  = new Direction(Direction.LEFT);
        Component ai         = new AI();
        Component collision  = new Collision(50,50);
        Component health = new Health(1);
        Component cenemy = new Enemy();

        enemy.addComponent(sprite);
        enemy.addComponent(position);
        enemy.addComponent(speed);
        enemy.addComponent(direction);
        enemy.addComponent(ai);
        enemy.addComponent(collision);
        enemy.addComponent(health);
        enemy.addComponent(cenemy);

        return enemy;
    }

    public static Entity createHeroSpaceShip() {
        Entity spaceShip     = new Entity();

        Component sprite     = new Sprite("images/spaceship.png");
        Component position   = new Position(new Vector2i(GameManager.WIDTH / 2, GameManager.HEIGHT / 2 + 200));
        Component speed      = new Speed(2);
        Component direction  = new Direction(Direction.LEFT);
        Component hero       = new Hero();
        Component collision  = new Collision(50, 50);
        Health helth = new Health(3);

        spaceShip.addComponent(sprite);
        spaceShip.addComponent(position);
        spaceShip.addComponent(speed);
        spaceShip.addComponent(direction);
        spaceShip.addComponent(hero);
        spaceShip.addComponent(collision);
        spaceShip.addComponent(helth);

        return spaceShip;
    }

    public static Entity createBackGround() {
        Entity backGround = new Entity();

        Component sprite   = new Sprite("images/space.png");
        Component position = new Position(new Vector2i(0,0));

        backGround.addComponent(sprite);
        backGround.addComponent(position);

        return backGround;
    }

    public static Entity createLaserBullet(Vector2i p) {
        Entity laserBullet = new Entity();

        Component sprite    = new Sprite("images/laser.png");
        Component position  = new Position(p);
        Component speed     = new Speed(10);
        Component direction = new Direction(Direction.UP);
        Component bullet    = new Bullet();
        Component colision  = new Collision(10, 5);

        laserBullet.addComponent(sprite);
        laserBullet.addComponent(position);
        laserBullet.addComponent(speed);
        laserBullet.addComponent(direction);
        laserBullet.addComponent(bullet);
        laserBullet.addComponent(colision);

        return laserBullet;
    }

    public static Entity createEgg(Vector2i p) {
        Entity egg = new Entity();

        Component sprite    = new Sprite(   "images/egg.png");
        Component position  = new Position(p);
        Component speed     = new Speed(5);
        Component direction = new Direction(Direction.DOWN);
        Component bullet    = new Bullet();
        Component colision  = new Collision(10, 10);
        Component enemy     = new Enemy();

        egg.addComponent(sprite);
        egg.addComponent(position);
        egg.addComponent(speed);
        egg.addComponent(direction);
        egg.addComponent(bullet);
        egg.addComponent(colision);
        egg.addComponent(enemy);

        return egg;
    }


}
