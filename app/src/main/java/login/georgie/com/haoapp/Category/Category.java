package login.georgie.com.haoapp.Category;

public class Category {
    private String Image;
    private String Name;
    private String Description;
    private String Price;
    private String Discount;

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

    public String getDiscount(){ return Discount; }

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

    public void setDiscount(String discount) {
        Discount = discount;
    }
}
