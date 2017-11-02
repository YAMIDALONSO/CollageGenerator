package views;

import java.awt.GridLayout;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import models.Photo;

public class JPanelCollage extends JPanel {

    public static final String DEFAULT_PHOTO = "/data/DefaultImage.png";

    public JPanelCollage() {
        add(new JLabel(getIcon(DEFAULT_PHOTO))); 
    }
    
    public int generateExperimantalNembre(){
        return (int)(Math.random()*((10 - 2) * 10));
    }

    public void generateCollage(ArrayList<Photo> photoList) {
        this.removeAll();
        setLayout(new GridLayout(photoList.size(), 5));
        for (Photo photo : photoList) {
            Image iiNewSize = new ImageIcon(photo.getPath()).getImage();
            Image newPhoto = iiNewSize.getScaledInstance(900, 500, Image.SCALE_SMOOTH);
            add(new JLabel(new ImageIcon(newPhoto)));
        }
    }

    private Icon getIcon(String path) {
        return new ImageIcon(getClass().getResource(path));
    }
}
