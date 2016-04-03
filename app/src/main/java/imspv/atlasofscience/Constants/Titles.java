package imspv.atlasofscience.Constants;

/**
 * Created by 1 on 03.04.2016.
 */
public class Titles {
    private String title;
    int image;


    public Titles(String title, int image) {
        this.title = title;
        this.image = image;
    }

    public Titles(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
