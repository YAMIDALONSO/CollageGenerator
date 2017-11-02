package views;

import java.awt.BorderLayout;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
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
        JScrollPane jsp = new JScrollPane();
        panelList.refreshPhoto(photolist);
        panelImagelist.addPhotoToPanel(photolist);
        jsp.setViewportView(panelImagelist);
        add(jsp,BorderLayout.CENTER);
    }

    public Photo getSelectedPhoto() {
        return null;
    }
}