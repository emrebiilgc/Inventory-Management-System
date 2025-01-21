/**
 * Represents a generic item in the inventory with common attributes like name, barcode, and price.
 * This abstract class serves as a base for specific item types such as Book, Toy, and Stationery.
 */

public abstract class AbstractItem {
    protected String name;
    protected String barcode;
    protected double price;


    /**
     * Constructs an item with the specified name, barcode, and price.
     *
     * @param name The name of the item.
     * @param barcode The barcode of the item.
     * @param price The price of the item.
     */

    public AbstractItem(String name, String barcode, double price) {
        this.name = name;
        this.barcode = barcode;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getBarcode() {
        return barcode;
    }

    public double getPrice() {
        return price;
    }
}
