package models;

public class Photo {

    private String path;

    public Photo(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    @Override
    public String toString() {
        return "Photo{" + "path=" + path + '}';
    }
}