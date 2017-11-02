package models;

import java.util.ArrayList;

public class CollageGenerator {

    private ArrayList<Photo> photoList;

    public CollageGenerator(ArrayList<Photo> photoList) {
        this.photoList = photoList;
    }

    public static Photo createPhoto(String path) {
        return new Photo(path);
    }

    public ArrayList<Photo> getPhotoList() {
        return photoList;
    }

}
