package Assignment.Ass3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class BookMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Book[] books = {
                new Book(105, "Data Structures"),
                new Book(210, "Operating Systems"),
                new Book(150, "Algorithms"),
                new Book(99, "Discrete Math"),
                new Book(305, "Database Systems"),
                new Book(12, "Computer Networks"),
                new Book(450, "Artificial Intelligence"),
                new Book(77, "Machine Learning"),
                new Book(188, "Java Programming"),
                new Book(501, "Web Development"),
                new Book(333, "Cyber Security"),
                new Book(275, "Cloud Computing"),
                new Book(66, "Software Engineering"),
                new Book(420, "Mobile App Development"),
                new Book(199, "Parallel Computing")
        };

        // ========================
        // LINEAR SEARCH (UNSORTED)
        // ========================
        System.out.print("Enter book id to search (Linear Search): ");
        int searchId = sc.nextInt();

        int linearIndex = Book.linearSearch(books, searchId);
        if (linearIndex != -1) {
            System.out.println("Book found (Linear Search): " + books[linearIndex]);
        } else {
            System.out.println("Book not found (Linear Search)");
        }

        // ========================
        // SORT BY ID FOR BINARY SEARCH
        // ========================
        Arrays.sort(books, Comparator.comparingInt((Book b) -> b.id)
                .thenComparing(b -> b.title));

        // Display sorted books
        System.out.println("\nBooks after sorting by ID:");
        for (Book b : books) {
            System.out.println(b);
        }

        // ========================
        // BINARY SEARCH (SORTED)
        // ========================
        System.out.print("\nEnter book id to search (Binary Search): ");
        int binarySearchId = sc.nextInt();

        int binaryIndex = Book.binarySearch(books, binarySearchId);
        if (binaryIndex != -1) {
            System.out.println("Book found (Binary Search): " + books[binaryIndex]);
        } else {
            System.out.println("Book not found (Binary Search)");
        }

        sc.close();
    }
}
