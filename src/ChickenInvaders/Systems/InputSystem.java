package ChickenInvaders.Systems;

import ChickenInvaders.Components.Direction;
import ChickenInvaders.Components.Flags.Hero;
import ChickenInvaders.Components.Position;
import ChickenInvaders.EntitiesFactory;
import ChickenInvaders.GameManager;
import Engine.Entity;
import Engine.System;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by Макс on 25.05.2016.
 */
public class InputSystem extends System implements KeyListener {

    public InputSystem() {
        GameManager.instance.addKeyListener(this);
    }

    private Queue<Integer> queue = new ConcurrentLinkedQueue<>();

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
//        java.lang.System.out.println(e.getExtendedKeyCode());
        queue.add(e.getExtendedKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void update(double dt) {
        if (queue.isEmpty())
            return;


        for (Entity e : (ArrayList<Entity>)GameManager.instance.getCurrentScene().getEntities().clone()) {

            Direction direction = e.getComponent(Direction.class);
            Position position   = e.getComponent(Position.class);
            Hero hero           = e.getComponent(Hero.class);

            if (direction == null ||
                     hero == null ||
                 position == null) continue;

            switch (queue.peek()) {
                case KeyEvent.VK_W: direction.setDirection(Direction.UP);
                    break;
                case KeyEvent.VK_D: direction.setDirection(Direction.RIGHT);
                    break;
                case KeyEvent.VK_A: direction.setDirection(Direction.LEFT);
                    break;
                case KeyEvent.VK_S: direction.setDirection(Direction.DOWN);
                    break;
                case KeyEvent.VK_ENTER: {
                    GameManager.instance.getCurrentScene().addEntity(EntitiesFactory.createLaserBullet(position.value));
                    GameManager.instance.audioManager.play("audio/lazershot.wav");
                    break;
                }
            }



        }
        queue.poll();
    }
}
