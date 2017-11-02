package views;

import java.awt.AWTException;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import models.Photo;

public class JPanelCollage extends JPanel {

    public static final String DEFAULT_PHOTO = "/data/DefaultImage.png";

    private static final String DEFAULT_FORMAT = "png";
    private static final String COLLAGE_PNG = "collage.png";

    public JPanelCollage() {
        add(new JLabel(getIcon(DEFAULT_PHOTO)));
    }

    public void generateCollage(ArrayList<Photo> photoList) {
        this.removeAll();
        setLayout(new GridLayout(4, photoList.size()));
        for (Photo photo : photoList) {
            Image iiNewSize = new ImageIcon(photo.getPath()).getImage();
            add(new JLabel(new ImageIcon(iiNewSize.getScaledInstance(getHeight(), getWidth(), Image.SCALE_SMOOTH))));
        }
        repaint();
    }

    private Icon getIcon(String path) {
        return new ImageIcon(getClass().getResource(path));
    }

    public void save() {
        try {
            BufferedImage bufferedImage = new Robot().createScreenCapture(getBounds());
            ImageIO.write(bufferedImage, DEFAULT_FORMAT, new File(COLLAGE_PNG));
        } catch (AWTException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}