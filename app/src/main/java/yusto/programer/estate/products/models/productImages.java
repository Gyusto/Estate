package yusto.programer.estate.products.models;
public class productImages {
    private int moreImages;
    private String ImageDescr;

    public productImages() {
    }

    public productImages(int moreImages, String imageDescr) {
        this.moreImages = moreImages;
        ImageDescr = imageDescr;
    }

    public int getMoreImages() {
        return moreImages;
    }

    public void setMoreImages(int moreImages) {
        this.moreImages = moreImages;
    }

    public String getImageDescr() {
        return ImageDescr;
    }

    public void setImageDescr(String imageDescr) {
        ImageDescr = imageDescr;
    }
}
