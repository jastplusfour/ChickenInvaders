package ChickenInvaders.Components;

import Engine.Component;
import Engine.MathMagic.Vector2i;

/**
 * Created by Макс on 19.05.2016.
 */
public class Direction extends Component {

    public Vector2i value;


    public static final Vector2i UP    = new Vector2i( 0, -1);
    public static final Vector2i DOWN  = new Vector2i( 0,  1);
    public static final Vector2i LEFT  = new Vector2i(-1,  0);
    public static final Vector2i RIGHT = new Vector2i( 1,  0);


    public Direction(Vector2i direction) {
        this.value = direction;
    }

    public void setDirection(Vector2i value) {
        this.value = value;
    }
}
