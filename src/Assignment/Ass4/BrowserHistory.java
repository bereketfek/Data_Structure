package Assignment.Ass4;

import java.util.HashMap;
import java.util.Map;

/**
 * BrowserHistory simulates a web browser’s history using a doubly linked list.
 *
 * head → First page visited (oldest)
 * tail → Most recently visited page
 * current → Page currently being viewed
 */
public class BrowserHistory {

    /**
     * Represents a single web page node in the history.
     */
    class WebPage {
        String url;
        long timestamp;
        WebPage prev;
        WebPage next;

        /**
         * Constructor: creates a new WebPage node with the current timestamp
         */
        WebPage(String url) {
            this.url = url;
            this.timestamp = System.currentTimeMillis();
            prev = null;
            next = null;
        }
    }

    private WebPage head;
    private WebPage tail;
    private WebPage current;

    /**
     * Visits a new page and updates history.
     * - If current is not at tail, forward history is removed
     * - Updates tail and current to the new page
     */
    public void visitPage(String url) {
        if (url == null || url.isEmpty())
            throw new IllegalArgumentException("URL cannot be null or empty");

        WebPage newPage = new WebPage(url);

        // Case 1: No history yet
        if (head == null) {
            head = tail = current = newPage;
            return;
        }

        // Case 2: Current is not at the end → delete forward history
        if (current != tail) {
            deleteForwardHistory();
        }

        // Append the new page
        tail.next = newPage;
        newPage.prev = tail;
        tail = newPage;
        current = newPage;
    }

    /**
     * Helper: delete all nodes after current (used when visiting a new page
     * from the middle of history)
     */
    private void deleteForwardHistory() {
        WebPage temp = current.next;
        while (temp != null) {
            WebPage next = temp.next;
            temp.prev = null; // break backward link
            temp.next = null; // break forward link
            temp = next;
        }
        current.next = null;
        tail = current; // update tail
    }

    /**
     * Go back a number of steps in history.
     * Returns the URL of the new current page.
     * Stops at the head if steps exceed available history.
     */
    public String goBack(int steps) {
        if (steps < 0)
            throw new IllegalArgumentException("Steps cannot be negative");

        while (steps-- > 0 && current != null && current.prev != null) {
            current = current.prev;
        }
        return current != null ? current.url : null;
    }

    /**
     * Go forward a number of steps in history.
     * Returns the URL of the new current page.
     * Stops at the tail if steps exceed available forward history.
     */
    public String goForward(int steps) {
        if (steps < 0)
            throw new IllegalArgumentException("Steps cannot be negative");

        while (steps-- > 0 && current != null && current.next != null) {
            current = current.next;
        }
        return current != null ? current.url : null;
    }

    /**
     * Clears the entire history.
     * Properly removes all references to prevent memory leaks.
     */
    public void clearHistory() {
        WebPage temp = head;
        while (temp != null) {
            WebPage next = temp.next; // save next before deletion
            temp.prev = null;
            temp.next = null;
            temp = next;
        }
        head = tail = current = null;
    }

    /**
     * Finds the most frequently visited page in history.
     * If there is a tie, the most recently visited page is returned.
     */
    public String findFrequentPage() {
        if (head == null) return null;

        Map<String, Integer> freq = new HashMap<>();      // URL → visit count
        Map<String, Long> latestTime = new HashMap<>();  // URL → last visit timestamp

        WebPage temp = head;
        while (temp != null) {
            freq.put(temp.url, freq.getOrDefault(temp.url, 0) + 1);
            latestTime.put(temp.url, temp.timestamp); // update latest timestamp
            temp = temp.next;
        }

        String result = null;
        int maxCount = 0;
        long latest = 0;

        for (String url : freq.keySet()) {
            int count = freq.get(url);
            long time = latestTime.get(url);

            // Pick the URL with a higher count or more recent timestamp if tied
            if (count > maxCount || (count == maxCount && time > latest)) {
                maxCount = count;
                latest = time;
                result = url;
            }
        }
        return result;
    }

    /**
     * Prints the entire history.
     * Marks the current page in brackets [current].
     */
    public void displayHistory() {
        WebPage temp = head;
        while (temp != null) {
            if (temp == current)
                System.out.print("[" + temp.url + "] ");
            else
                System.out.print(temp.url + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // ---------------- Additional Utility Methods ----------------

    /** Returns the current page URL without moving */
    public String getCurrentPage() {
        return current != null ? current.url : null;
    }

    /** Returns true if we can go back in history */
    public boolean canGoBack() {
        return current != null && current != head;
    }

    /** Returns true if we can go forward in history */
    public boolean canGoForward() {
        return current != null && current != tail;
    }

    /** Returns the number of pages in history */
    public int size() {
        int count = 0;
        WebPage temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    /** Returns true if history is empty */
    public boolean isEmpty() {
        return head == null;
    }
}
