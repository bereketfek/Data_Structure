package Assignment.Ass2;

public class LibraryRecord {

    private String bookTitle;
    private String borrowerName; // null if never borrowed
    private int borrowDays;
    private boolean borrowed;

    // Constructor
    public LibraryRecord(String bookTitle, String borrowerName, int borrowDays, boolean borrowed) {
        this.bookTitle = bookTitle;
        this.borrowerName = borrowerName;
        this.borrowDays = borrowDays;
        this.borrowed = borrowed;
    }

    // Getters
    public String getBookTitle() {
        return bookTitle;
    }

    public String getBorrowerName() {
        return borrowerName;
    }

    public int getBorrowDays() {
        return borrowDays;
    }

    public boolean isBorrowed() {
        return borrowed;
    }

    // Setters
    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public void setBorrowerName(String borrowerName) {
        this.borrowerName = borrowerName;
    }

    public void setBorrowDays(int borrowDays) {
        this.borrowDays = borrowDays;
    }

    public void setBorrowed(boolean borrowed) {
        this.borrowed = borrowed;
    }

    @Override
    public String toString() {
        String status = borrowed ? "Borrowed" : "Available";
        String borrower = (borrowerName == null) ? "None" : borrowerName;

        return "Book Title: " + bookTitle +
                "\nBorrower: " + borrower +
                "\nBorrow Days: " + borrowDays +
                "\nStatus: " + status + "\n";
    }
}
