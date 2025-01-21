/**
 * Manages a collection of items in an inventory. Supports operations to add, remove, and search items by various criteria.
 * This class is generic and can handle any type of items that extend {@link AbstractItem}.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Inventory<T extends AbstractItem> {
    private List<T> items;

    public Inventory() {
        this.items = new ArrayList<>();
    }

    public void addItem(T item) {
        items.add(item);
    }

    /**
     * Removes an item from the inventory by its barcode.
     *
     * @param barcode The barcode of the item to be removed.
     * @return The removed item, or null if no item with such barcode exists.
     */

    public T removeItem(String barcode) {
        T item = items.stream()
                .filter(i -> i.getBarcode().equals(barcode))
                .findFirst()
                .orElse(null);
        if (item != null) {
            items.remove(item);
        }
        return item;
    }

    /**
     * Searches for an item by its barcode.
     *
     * @param barcode The barcode of the item to search for.
     * @return The item with the specified barcode, or null if no such item is found.
     */

    public T searchByBarcode(String barcode) {
        return items.stream()
                .filter(item -> item.getBarcode().equals(barcode))
                .findFirst()
                .orElse(null);
    }

    /**
     * Searches for items by their name.
     *
     * @param name The name to search for.
     * @return A list of items matching the name, which could be empty if no matches are found.
     */

    public List<T> searchByName(String name) {
        return items.stream()
                .filter(item -> item.getName().equalsIgnoreCase(name))
                .collect(Collectors.toList());
    }


    /**
     * Retrieves a list of all items in the inventory, sorted first by type: Books, then Toys, and Stationery last.
     *
     * @return A sorted list of all items in the inventory.
     */

    public List<T> getItems() {
        List<T> sortedItems = new ArrayList<>();
        sortedItems.addAll(items.stream().filter(item -> item instanceof Book).collect(Collectors.toList()));
        sortedItems.addAll(items.stream().filter(item -> item instanceof Toy).collect(Collectors.toList()));
        sortedItems.addAll(items.stream().filter(item -> item instanceof Stationery).collect(Collectors.toList()));
        return sortedItems;
    }
}
