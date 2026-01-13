package Assignment.Ass2;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList<LibraryRecord> records = new ArrayList<>();

        // Books never borrowed
        records.add(new LibraryRecord("Java Programming"));
        records.add(new LibraryRecord("Data Structures"));

        // Books currently borrowed
        records.add(new LibraryRecord("Operating Systems", "Alice", 7));
        records.add(new LibraryRecord("Database Systems", "Bob", 5));

        // Display all records
        System.out.println("Initial Records:");
        for (LibraryRecord record : records) {
            System.out.println(record);
            System.out.println("------------------");
        }

        // Remove one record
        records.remove(1);

        // Modify an existing record using set()
        records.set(0, new LibraryRecord("Java Programming", "Charlie", 10));

        // Display total number of records
        System.out.println("Total Records: " + records.size());

        //  Retrieve and display a specific record
        System.out.println("\nRetrieved Record:");
        System.out.println(records.get(0));
    }
}
