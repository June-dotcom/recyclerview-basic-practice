package edu.ucucite.recyclerdemo2;

public class Photo {
    String title;
    int imgIdResource;


    public Photo(String title, int imgIdResource) {
        this.title = title;
        this.imgIdResource = imgIdResource;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImgIdResource() {
        return imgIdResource;
    }

    public void setImgIdResource(int imgIdResource) {
        this.imgIdResource = imgIdResource;
    }
}
