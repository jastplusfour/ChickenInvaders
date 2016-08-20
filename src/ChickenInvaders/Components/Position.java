package ChickenInvaders.Components;

import Engine.Component;
import Engine.MathMagic.Vector2i;

/**
 * Created by Макс on 16.05.2016.
 */
public class Position extends Component {

//    public int x;
//    public int y;
    public Vector2i value = new Vector2i();



    public Position(Vector2i value) {
        this.value.set(value);
    }
}
