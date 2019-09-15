package yusto.programer.estate.products.models;

public class products_house {
    private String location;
    private String amount;
    private String Image;

    public products_house() {
    }

    public products_house(String location, String amount, String image) {
        this.location = location;
        this.amount = amount;
        Image = image;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }
}
