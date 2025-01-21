/**
 * Manages execution of inventory operations such as add, remove, search, and display.
 */

import java.util.List;

public class Process {
    private Inventory<AbstractItem> inventory;
    private String outputFile;

    public Process(String outputFile) {
        this.inventory = new Inventory<>();
        this.outputFile = outputFile;
    }

    public void executeCommands(String[] commands) {
        for (String commandLine : commands) {
            String[] parts = commandLine.split("\t");
            String command = parts[0];

            if ("ADD".equals(command)) {
                Add(parts);
            } else if ("DISPLAY".equals(command)) {
                String inventoryOutput = "INVENTORY:\n" + displayInventory() + "------------------------------\n";
                FileOutput.writeToFile(outputFile, inventoryOutput, true, false);
            } else if ("REMOVE".equals(command)) {
                String removeOutput = Remove(parts[1]);
                FileOutput.writeToFile(outputFile, removeOutput, true, false);
            } else if ("SEARCHBYBARCODE".equals(command)) {
                String searchByBarcodeOutput = SearchByBarcode(parts[1]);
                FileOutput.writeToFile(outputFile, searchByBarcodeOutput, true, false);
            } else if ("SEARCHBYNAME".equals(command)) {
                String searchByNameOutput = SearchByName(parts[1]);
                FileOutput.writeToFile(outputFile, searchByNameOutput, true, false);
            }
        }
    }

    private void Add(String[] parts) {
        String type = parts[1];
        AbstractItem item = null;

        if ("Book".equals(type)) {
            item = new Book(parts[2], parts[3], parts[4], Double.parseDouble(parts[5]));
        } else if ("Toy".equals(type)) {
            item = new Toy(parts[2], parts[3], parts[4], Double.parseDouble(parts[5]));
        } else if ("Stationery".equals(type)) {
            item = new Stationery(parts[2], parts[3], parts[4], Double.parseDouble(parts[5]));
        }

        if (item != null) {
            inventory.addItem(item);
        }
    }

    private String Remove(String barcode) {
        AbstractItem item = inventory.removeItem(barcode);
        return "REMOVE RESULTS:\n" + (item != null ? "Item is removed." : "Item is not found.") + "\n------------------------------\n";
    }

    private String SearchByBarcode(String barcode) {
        AbstractItem item = inventory.searchByBarcode(barcode);
        return "SEARCH RESULTS:\n" + (item != null ? item.toString() : "Item is not found.") + "\n------------------------------\n";
    }

    private String SearchByName(String name) {
        List<AbstractItem> items = inventory.searchByName(name);
        StringBuilder outputBuilder = new StringBuilder("SEARCH RESULTS:\n");
        if (items.size() > 0) {
            items.forEach(item -> outputBuilder.append(item.toString()).append("\n"));
        } else {
            outputBuilder.append("Item is not found.\n");
        }
        outputBuilder.append("------------------------------\n");
        return outputBuilder.toString();
    }

    private String displayInventory() {
        StringBuilder outputBuilder = new StringBuilder();
        inventory.getItems().forEach(item -> outputBuilder.append(item.toString()).append("\n"));
        return outputBuilder.toString();
    }
}
