package login.georgie.com.haoapp.Model;

import java.util.List;

public class Request {
    private String phone;
    //private String name;
    //private String address;
    private  String total;
    private List<Order> houses;

    public Request(String s, String toString, List<Order> cart) {
    }

    public Request(String phone, String name, String address, String total, List<Order> houses) {
        this.phone = phone;
        this.total = total;
        this.houses = houses;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }



    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public List<Order> getHouses() {
        return houses;
    }

    public void setHouses(List<Order> houses) {
        this.houses = houses;
    }
}
