package UIComponents;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

public class Background_image extends JPanel {
    private Image backgroundImage;

    public Background_image(String imagePath) throws IOException {
        backgroundImage = ImageIO.read(new File(imagePath));
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
    }
}
