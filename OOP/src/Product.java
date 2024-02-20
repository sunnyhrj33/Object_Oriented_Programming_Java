public class Product {
    private int id;
    private String name;
    private double price;
    private int quantity;
    private Date mfgDate;

    public static int counter = 1;

    Product(String name, int price, int quantity, Date mfgDate) {
        this.id = counter++;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.mfgDate = mfgDate;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public String toString() {
        String productDetails = String.format("%2d\t%-10s\t%.2f\t%d\t%17s", id, name, price, quantity, mfgDate);
        return productDetails;
    }
}
