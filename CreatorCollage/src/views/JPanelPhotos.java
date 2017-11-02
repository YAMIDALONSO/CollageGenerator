package views;

import java.awt.BorderLayout;
import java.util.ArrayList;
import javax.swing.JPanel;
import models.Photo;

public class JPanelPhotos extends JPanel {

    private JPanelList panelList;
    private JPanelPhotoList panelImagelist;

    public JPanelPhotos() {
        setLayout(new BorderLayout());
        panelList = new JPanelList();
        add(panelList,BorderLayout.PAGE_START);
        panelImagelist = new JPanelPhotoList();
    }

    public void refreshImage(ArrayList<Photo> photolist) {
        panelList.refreshPhoto(photolist);
        panelImagelist.addPhotoToPanel(photolist);
        add(panelImagelist,BorderLayout.PAGE_END);
    }

    public Photo getSelectedPhoto() {
        return null;
    }
}