package views;

import java.awt.GridLayout;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import models.Photo;

public class JPanelPhotoList extends JPanel {
    
    public void addPhotoToPanel(ArrayList<Photo> photoList) {
        removeAll();
        setLayout(new GridLayout(photoList.size(), 1, 20, 10));
        for (Photo photo : photoList) {
            Image iiNewSize = new ImageIcon(photo.getPath()).getImage();
            Image newPhoto = iiNewSize.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
            add(new JLabel(new ImageIcon(newPhoto)));
        }
        revalidate();
    }
}