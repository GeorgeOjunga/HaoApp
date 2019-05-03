package login.georgie.com.haoapp.Model;

public class Order{
    private String HouseID;
    private String HouseName;
    private String NumberOfRooms;
    private String Price;
    private String Discount;



    public Order() {
    }

    public Order(String houseID, String houseName, String price, String numberOfRooms, String discount) {
        HouseID = houseID;
        HouseName = houseName;
        Price = price;
        NumberOfRooms = numberOfRooms;
        Discount = discount;

    }

    public String getHouseID() {
        return HouseID;
    }

    public void setHouseID(String houseID) {
        HouseID = houseID;
    }

    public String getHouseName() {
        return HouseName;
    }

    public void setHouseName(String houseName) {
        HouseName = houseName;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public String getNumberOfRooms() {
        return NumberOfRooms;
    }

    public void setNumberOfRooms(String numberOfRooms) {
        NumberOfRooms = numberOfRooms;
    }

    public String getDiscount() {
        return Discount;
    }

    public void setDiscount(String discount) {
        Discount = discount;
    }
}


