package ChickenInvaders.Components.Animation;

import Engine.Component;

/**
 * Created by Макс on 25.05.2016.
 */
public class FadeOut extends Component {

    public float value = 1;
    public float duration;

    public FadeOut(float duration) {
        this.duration = duration;
    }
}
