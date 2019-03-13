package login.georgie.com.haoapp.Category;

public class Category {
    private String Image;
    private String Name;
    private String Description;
    private String Price;

    public Category() {
    }

    public String getImage() {
        return Image;
    }

    public String getName() {
        return Name;
    }

    public String getDescription() {
        return Description;
    }

    public String getPrice() {
        return Price;
    }

    public void setImage(String image) {

        Image = image;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public void setPrice(String price) {
        Price = price;
    }
}
