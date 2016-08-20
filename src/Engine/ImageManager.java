package Engine;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

/**
 * Created by Макс on 25.05.2016.
 */
public class ImageManager {
    private HashMap<String, Image> images = new HashMap();
    public static ImageManager instance = new ImageManager();

    public Image read(String path) {
        Image image = this.images.get(path);
        if (image == null) {
            try {
                image = ImageIO.read(new File(path));
            } catch (IOException ex) {}
            this.images.put(path, image);
        }
        return image;
    }
}
