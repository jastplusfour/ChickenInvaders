package ChickenInvaders.Components;

import Engine.Component;

import java.awt.*;

/**
 * Created by Макс on 25.05.2016.
 */
public class Collision extends Component {

    public Rectangle rectangle = new Rectangle();


    public Collision(int width, int height) {
        rectangle.width = width;
        rectangle.height = height;
    }
}
