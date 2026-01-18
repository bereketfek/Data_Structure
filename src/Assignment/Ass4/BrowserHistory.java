package Assignment.Ass4;

import java.util.HashMap;
import java.util.Map;

// Browser History Management System
public class BrowserHistory {
    private WebPage head;
    private WebPage tail;
    private WebPage current;
    private int size;

    public BrowserHistory() {
        this.head = null;
        this.tail = null;
        this.current = null;
        this.size = 0;
    }

    /**
     * Visit a new page - creates a new node with current timestamp
     * Deletes forward history if current is not at the tail
     */
    public void visitPage(String url) {
        long timestamp = System.currentTimeMillis();
        WebPage newPage = new WebPage(url, timestamp);

        // If history is empty
        if (head == null) {
            head = tail = current = newPage;
            size = 1;
            System.out.println("Visited: " + url + " (First page in history)");
            return;
        }

        // If current is not at the end, delete all forward history
        if (current != tail) {
            deleteForwardHistory();
        }

        // Insert new page at the end
        tail.next = newPage;
        newPage.prev = tail;
        tail = newPage;
        current = newPage;
        size++;

        System.out.println("Visited: " + url);
    }

    /**
     * Delete all nodes after current
     */
    private void deleteForwardHistory() {
        if (current == null || current.next == null) {
            return;
        }

        WebPage temp = current.next;
        int deleted = 0;

        // Traverse and count nodes to delete
        while (temp != null) {
            WebPage next = temp.next;
            temp.prev = null;
            temp.next = null;
            temp = next;
            deleted++;
            size--;
        }

        // Update current to be the new tail
        current.next = null;
        tail = current;

        System.out.println("Deleted " + deleted + " page(s) from forward history");
    }

    /**
     * Go back in history by specified steps
     */
    public String goBack(int steps) {
        if (current == null) {
            System.out.println("No history available");
            return null;
        }

        if (steps <= 0) {
            System.out.println("Invalid steps");
            return current.url;
        }

        int actualSteps = 0;
        while (current.prev != null && actualSteps < steps) {
            current = current.prev;
            actualSteps++;
        }

        System.out.println("Went back " + actualSteps + " step(s)");
        System.out.println("Current page: " + current.url);
        return current.url;
    }

    /**
     * Go forward in history by specified steps
     */
    public String goForward(int steps) {
        if (current == null) {
            System.out.println("No history available");
            return null;
        }

        if (steps <= 0) {
            System.out.println("Invalid steps");
            return current.url;
        }

        int actualSteps = 0;
        while (current.next != null && actualSteps < steps) {
            current = current.next;
            actualSteps++;
        }

        System.out.println("Went forward " + actualSteps + " step(s)");
        System.out.println("Current page: " + current.url);
        return current.url;
    }

    /**
     * Clear entire history
     */
    public void clearHistory() {
        if (head == null) {
            System.out.println("History is already empty");
            return;
        }

        int cleared = size;
        WebPage temp = head;

        // Traverse and nullify all references
        while (temp != null) {
            WebPage next = temp.next;
            temp.prev = null;
            temp.next = null;
            temp = next;
        }

        head = tail = current = null;
        size = 0;

        System.out.println("Cleared " + cleared + " page(s) from history");
    }

    /**
     * Find the most frequently visited page
     * In case of tie, return the most recently visited
     */
    public String findFrequentPage() {
        if (head == null) {
            System.out.println("No history available");
            return null;
        }

        // Map to store URL -> {count, most_recent_timestamp}
        Map<String, PageFrequency> frequencyMap = new HashMap<>();

        WebPage temp = head;
        while (temp != null) {
            if (!frequencyMap.containsKey(temp.url)) {
                frequencyMap.put(temp.url, new PageFrequency(1, temp.timestamp));
            } else {
                PageFrequency pf = frequencyMap.get(temp.url);
                pf.count++;
                pf.mostRecentTimestamp = Math.max(pf.mostRecentTimestamp, temp.timestamp);
            }
            temp = temp.next;
        }

        // Find the most frequent URL
        String mostFrequentUrl = null;
        int maxCount = 0;
        long mostRecentTime = 0;

        for (Map.Entry<String, PageFrequency> entry : frequencyMap.entrySet()) {
            String url = entry.getKey();
            PageFrequency pf = entry.getValue();

            // Update if higher count, or same count but more recent
            if (pf.count > maxCount ||
                    (pf.count == maxCount && pf.mostRecentTimestamp > mostRecentTime)) {
                mostFrequentUrl = url;
                maxCount = pf.count;
                mostRecentTime = pf.mostRecentTimestamp;
            }
        }

        System.out.println("Most frequent page: " + mostFrequentUrl +
                " (visited " + maxCount + " time(s))");
        return mostFrequentUrl;
    }

    /**
     * Display entire history from head to tail
     */
    public void displayHistory() {
        if (head == null) {
            System.out.println("History is empty");
            return;
        }

        System.out.println("\n--- Browser History (Oldest to Newest) ---");
        WebPage temp = head;
        int index = 0;

        while (temp != null) {
            String marker = (temp == current) ? " <-- CURRENT" : "";
            String headMarker = (temp == head) ? " [HEAD]" : "";
            String tailMarker = (temp == tail) ? " [TAIL]" : "";

            System.out.println(index + ": " + temp.url + headMarker + tailMarker + marker);
            temp = temp.next;
            index++;
        }
        System.out.println("Total pages: " + size);
        System.out.println("-------------------------------------------\n");
    }

    /**
     * Get current page URL
     */
    public String getCurrentPage() {
        return current != null ? current.url : null;
    }

    /**
     * Get history size
     */
    public int getSize() {
        return size;
    }

    // Helper class for frequency tracking
    private static class PageFrequency {
        int count;
        long mostRecentTimestamp;

        PageFrequency(int count, long timestamp) {
            this.count = count;
            this.mostRecentTimestamp = timestamp;
        }
    }
}

