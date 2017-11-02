package persistence;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import models.CollageGenerator;
import models.Photo;

public class FileManager {

    private File file;

    public void setFile(File file) {
        this.file = file;
    }

    public ArrayList<Photo> readFolderPhoto() throws IOException {
        ArrayList<Photo> photosInFolder = new ArrayList<>();
        for (File fileInFolder : file.listFiles()) {
            if (fileInFolder.isFile()) {
                photosInFolder.add(CollageGenerator.createPhoto(fileInFolder.getAbsolutePath()));
            }
        }
        return photosInFolder;
    }
}