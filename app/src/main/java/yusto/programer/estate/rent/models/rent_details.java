package yusto.programer.estate.rent.models;

public class rent_details {
    private  int icon;
    private String name;
    public rent_details() {
    }

    public rent_details(int icon, String name) {
        this.icon = icon;
        this.name = name;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
