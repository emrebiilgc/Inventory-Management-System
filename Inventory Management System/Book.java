/**
 * Represents a Book item in the inventory with additional attribute for author.
 */

public class Book extends AbstractItem {
    private String author;

    /**
     * Constructs a Book with the specified name, author, barcode, and price.
     *
     * @param author The author of the book.
     */

    public Book(String name, String author, String barcode, double price) {
        super(name, barcode, price);
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }
    @Override
    public String toString() {
        return "Author of the " + getName() + " is " + getAuthor() + ". Its barcode is " + getBarcode() + " and its price is " + getPrice();
    }

}
