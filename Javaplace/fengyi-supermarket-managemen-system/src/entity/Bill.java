package entity;

// 订单对象
public class Bill {
    private String userName;
    private String prodName;
    private int num;
    private double price;

    public double getTotal() {
        return num * price;
    }

    @Override
    public String toString() {
        return String.format("|%8s\t\t|%8s\t\t|%8s\t\t|%8s\t\t|%8s\t\t|", userName, prodName, num, price, getTotal());
    }

    public Bill(String userName, String prodName, int num, double price) {
        this.userName = userName;
        this.prodName = prodName;
        this.num = num;
        this.price = price;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
