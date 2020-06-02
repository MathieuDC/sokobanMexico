package view.level;

import model.element.Element;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ElementImg{

    private BufferedImage image;

    private int x;

    private int y;

    public ElementImg(Element element, int i, int j) {
        String path = "img/" + element.name() + ".png";
        try {
            this.image = ImageIO.read(new File(path));
        } catch (IOException e) {
            System.out.println(path);
            e.printStackTrace();
        }
        this.y = i * 34;
        this.x = j * 34;
    }

    public BufferedImage getImage() {
        return image;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
