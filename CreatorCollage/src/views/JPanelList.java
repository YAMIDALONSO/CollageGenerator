package views;

import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import models.Photo;

public class JPanelList extends JPanel {

    private static final String IMAGE_LIST_TEXT = "Lista de Imagenes";

    private DefaultListModel<Photo> model;
    private JList<Photo> imageList;

    public JPanelList() {
        model = new DefaultListModel<>();
        imageList = new JList<>(model);
        imageList.setBorder(BorderFactory.createTitledBorder(IMAGE_LIST_TEXT));

        add(new JScrollPane(imageList));
    }
    
    public void refreshPhoto(ArrayList<Photo> imagelist){
        model.clear();
        for (Photo image : imagelist) {
            model.addElement(image);
        }
    }
}