package persistence;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import models.CollageGenerator;
import models.Photo;

public class FileManager {

    private static final String[] SES = {"jpg", "png","tiff","jpeg","bmp","gif","jfif"};

    private File file;

    public void setFile(File file) {
        this.file = file;
    }

    public ArrayList<Photo> readFolderPhoto() throws IOException {
        ArrayList<Photo> photosInFolder = new ArrayList<>();
        for (File fileInFolder : file.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                boolean isFormat = false;
                for (int i = 0; i < SES.length; i++) {
                    if(name.toLowerCase().endsWith(SES[i])){
                        isFormat = true;
                    }
                }
                return isFormat;
            }
        })) {
            if (fileInFolder.isFile()) {
                photosInFolder.add(CollageGenerator.createPhoto(fileInFolder.getAbsolutePath()));
            }
        }
        return photosInFolder;
    }
}
