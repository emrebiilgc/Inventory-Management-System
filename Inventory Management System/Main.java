/**
 * Entry point for the Inventory Management System.
 * This class reads operations from a file and executes them, logging the results to another file.
 */

public class Main {

    /**
     * Main method to run the inventory management system.
     *
     * @param args the command line arguments:
     *             args[0] is the input file with commands,
     *             args[1] is the output file for results.
     */

    public static void main(String[] args) {

        String input = args[0];
        String output = args[1];

        String[] commands = FileInput.readFile(input, true, true);

        Process process = new Process(output);
        process.executeCommands(commands);
    }
}
