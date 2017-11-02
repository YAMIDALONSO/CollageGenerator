package views;

import controller.Events;
import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuBar extends JMenuBar {

    private static final long serialVersionUID = 1L;
    private static final String FILE = "File";
    private static final String ADD_FOLDER = "Add Folder";

    public MenuBar(ActionListener controller) {
        JMenu menuFile = new JMenu(FILE);

        JMenuItem itemShowAddCamping = new JMenuItem(ADD_FOLDER);
        itemShowAddCamping.addActionListener(controller);
        itemShowAddCamping.setActionCommand(Events.ADD_FOLDER.toString());
        menuFile.add(itemShowAddCamping);

        add(menuFile);
    }

}
