package ChickenInvaders.Components;

import Engine.*;
import Engine.System;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * Created by Макс on 16.05.2016.
 */
public class Sprite extends Engine.Component {

    public Image image;
    public float opacity;


    public Sprite (String fileName) {
        image = ImageManager.instance.read(fileName);
//        try {
//            image = ImageIO.read(new File(fileName));
//        } catch (IOException ex) {}
        opacity = 1;
    }

    public Sprite (String fileName, float opacity) {
        this(fileName);
        this.opacity = opacity;
    }

    /**
     * Created by Макс on 16.05.2016.
     */
//    public static class Ren   derSystem extends System {
//
//        private Graphics2D g2;
//        private ArrayList<Entity> entities;
//
//        private Scene curScene;
//
//
//        private void renderEntities() {
//            Entity currEntity;
//            Engine.Component c;
//
//            for (Entity e : entities) {
//
//
//            }
//        }
//
//        private void clearScreen() {
//            g2.clearRect(0, 0, 100, 100);
//        }

//        @Override
//        public void update(java.util.List<Entity> entities) {
////            g2 = curScene
//            for (Entity e : entities) {
//                g2.drawImage(e.getComponent(Sprite.class).image, 0, 0, 100, 100, null);
//            }
//        }
    }
//}
