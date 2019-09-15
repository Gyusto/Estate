package yusto.programer.estate.home;

public class Land {
    private String location;
    private String thumbNail;
    private String Rent_amout;

    public Land() {
    }

    public Land(String location, String thumbNail, String rent_amout) {
        this.location = location;
        this.thumbNail = thumbNail;
        Rent_amout = rent_amout;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getThumbNail() {
        return thumbNail;
    }

    public void setThumbNail(String thumbNail) {
        this.thumbNail = thumbNail;
    }

    public String getRent_amout() {
        return Rent_amout;
    }

    public void setRent_amout(String rent_amout) {
        Rent_amout = rent_amout;
    }
}
