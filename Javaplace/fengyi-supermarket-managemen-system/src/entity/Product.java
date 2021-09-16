package entity;


// 商品对象
public class Product {
    private String name;
    private int num;
    private double price;

    @Override
    public String toString() {

        return String.format("|%8s\t\t|%8s\t\t|%8s\t\t|%8s\t\t|", name, num, price, getTotal());
    }

    public double getTotal(){
        return num*price;
    }

    public Product(){}

    public Product(String name, int num, double price) {
        this.name = name;
        this.num = num;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
