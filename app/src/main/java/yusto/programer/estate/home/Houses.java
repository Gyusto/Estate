package yusto.programer.estate.home;

public class Houses {
    private String region;
    private String noOfHouses;
    private String thumbnail;

    public Houses() {
    }

    public Houses(String region, String noOfHouses, String thumbnail) {
        this.region = region;
        this.noOfHouses = noOfHouses;
        this.thumbnail = thumbnail;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getNoOfHouses() {
        return noOfHouses;
    }

    public void setNoOfHouses(String noOfHouses) {
        this.noOfHouses = noOfHouses;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }
}
