/**
 * Represents a Toy item in the inventory with additional attribute for color.
 */

public class Toy extends AbstractItem {
    private String color;

    /**
     * Constructs a Toy with the specified name, color, barcode, and price.
     *
     * @param color The color of the toy.
     */

    public Toy(String name, String color, String barcode, double price) {
        super(name, barcode, price);
        this.color = color;
    }

    public String getColor() {
        return color;
    }
    @Override
    public String toString() {
        return "Color of the " + getName() + " is " + getColor() + ". Its barcode is " + getBarcode() + " and its price is " + getPrice();
    }
}
