package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import models.CollageGenerator;
import models.Photo;
import persistence.FileManager;
import views.Window;

public class Controller implements ActionListener {

    private CollageGenerator collageGenerator;
    private Window window;
    private FileManager fileManager;

    public Controller() {
        window = new Window(this);
        fileManager = new FileManager();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (Events.valueOf(e.getActionCommand())) {
            case ADD_FOLDER:
                fileManager.setFile(getFolder());
                setData();
                refreshPhoto();
                break;
            case GENERATE:
                generateCollage(collageGenerator.getPhotoList());
                break;
        }
    }

    private File getFolder() {
        return window.getFolder();
    }

    public void setData() {
        try {
            collageGenerator = new CollageGenerator(fileManager.readFolderPhoto());
        } catch (IOException ex) {
            System.out.println("Archivo no encontrado");
        }
    }

    private void refreshPhoto() {
        window.refreshPhoto(collageGenerator.getPhotoList());
    }

    private void generateCollage(ArrayList<Photo> photoList) {
        window.generateCollage(photoList);
    }
}
