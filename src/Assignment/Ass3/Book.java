package Assignment.Ass3;

class Book {
    int id;
    String title;

    Book(int bookId, String title) {
        this.id = bookId;
        this.title = title;
    }

    public int getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Book && ((Book) obj).id == id;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + id +
                ", title='" + title + '\'' +
                '}';
    }

    // Linear Search (unsorted array)
    public static int linearSearch(Book[] books, int target) {
        for (int i = 0; i < books.length; i++) {
            if (books[i].id == target) {
                return i;
            }
        }
        return -1;
    }

    // Binary Search (sorted array)
    public static int binarySearch(Book[] books, int target) {
        int low = 0;
        int high = books.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (books[mid].id == target) {
                return mid;
            } else if (books[mid].id < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
