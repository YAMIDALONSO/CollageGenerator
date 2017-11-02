package views;

import java.awt.BorderLayout;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import models.Photo;

public class Window extends JFrame {

    public static final String ICON = "/data/Icon.png";
    public static final String TITLE = "COLLAGE CREATOR";

    private JPanelPhotos panelPhotos;
    private JPanelButtons panelButtons;
    private JPanelCollage panelCollage;
    private JPanelDetails panelDetails;

    public Window(ActionListener controller) {
        setTitle(TITLE);
        setIconImage(new ImageIcon(getClass().getResource(ICON)).getImage());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setExtendedState(MAXIMIZED_BOTH);

        setJMenuBar(new MenuBar(controller));

        panelCollage = new JPanelCollage();
        add(panelCollage, BorderLayout.CENTER);

        panelButtons = new JPanelButtons(controller);
        add(panelButtons, BorderLayout.PAGE_END);

        panelDetails = new JPanelDetails();
        add(panelDetails, BorderLayout.LINE_END);

        /*setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        
        c.gridy = 0;
        c.weighty = 0;
        c.gridx = 0;
        c.gridwidth = 3;*/

        panelPhotos = new JPanelPhotos();
        add(panelPhotos, BorderLayout.LINE_START);

        setVisible(true);
    }

    public File getFolder() {
        JFileChooser jf = new JFileChooser();
        jf.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int option = jf.showOpenDialog(null);
        return jf.getSelectedFile();
    }

    public void refreshPhoto(ArrayList<Photo> imagelist) {
        panelPhotos.refreshImage(imagelist);
        revalidate();
    }

    public void generateCollage(ArrayList<Photo> photoList) {
        panelCollage.generateCollage(photoList);
        revalidate();
    }

    public void save() {
        panelCollage.save();
    }
}
