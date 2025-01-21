/**
 * Represents a Stationery item in the inventory with additional attribute for kind.
 */

public class Stationery extends AbstractItem {
    private String kind;

    /**
     * Constructs a Stationery item with the specified name, kind, barcode, and price.
     *
     * @param kind The kind of the stationery item.
     */

    public Stationery(String name, String kind, String barcode, double price) {
        super(name, barcode, price);
        this.kind = kind;
    }

    public String getKind() {
        return kind;
    }
    @Override
    public String toString() {
        return "Kind of the " + getName() + " is " + getKind() + ". Its barcode is " + getBarcode() + " and its price is " + getPrice();
    }
}
