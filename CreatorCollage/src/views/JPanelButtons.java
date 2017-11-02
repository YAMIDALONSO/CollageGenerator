package views;

import controller.Events;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

public class JPanelButtons extends JPanel{

    private static final Color TEXT_COLOR = Color.WHITE;
    
    public JPanelButtons(ActionListener controller) {
        
        setLayout(new FlowLayout(FlowLayout.CENTER, 80, 0));
        
        JButton jbSave = new JButton(Events.SAVE.toString());
        jbSave.setForeground(TEXT_COLOR);
        jbSave.setBackground(Color.GREEN);
        jbSave.addActionListener(controller);
        jbSave.setActionCommand(Events.SAVE.toString());
        add(jbSave);
        
        JButton jbEdit = new JButton(Events.EDIT.toString());
        jbEdit.setBackground(TEXT_COLOR);
        jbEdit.setBackground(Color.BLUE);
        add(jbEdit);
        
        JButton jbSelect = new JButton(Events.SELECT.toString());
        jbSelect.setForeground(TEXT_COLOR);
        jbSelect.setBackground(Color.PINK);
        add(jbSelect);
        
        JButton jbGenerate = new JButton(Events.GENERATE.toString());
        jbGenerate.setBackground(TEXT_COLOR);
        jbGenerate.setBackground(Color.DARK_GRAY);
        jbGenerate.addActionListener(controller);
        jbGenerate.setActionCommand(Events.GENERATE.toString());
        add(jbGenerate);
        
        JButton jbDelete = new JButton(Events.DELETE.toString());
        jbDelete.setBackground(TEXT_COLOR);
        jbDelete.setBackground(Color.RED);
        add(jbDelete);
    }
}
