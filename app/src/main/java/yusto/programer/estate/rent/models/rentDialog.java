package yusto.programer.estate.rent.models;

public class rentDialog {
    private String ThumbNail;
    private String Location;

    public rentDialog() {
    }

    public rentDialog(String thumbNail, String location) {
        ThumbNail = thumbNail;
        Location = location;
    }

    public String getThumbNail() {
        return ThumbNail;
    }

    public void setThumbNail(String thumbNail) {
        ThumbNail = thumbNail;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }
}
