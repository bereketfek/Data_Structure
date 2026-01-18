package Assignment.Ass4;

public class BrowserHistorySystem {
    public static void main(String[] args) {
        BrowserHistory history = new BrowserHistory();

        System.out.println("=== Browser History Management System ===\n");

        // Scenario 1: Basic page visits
        System.out.println("--- Scenario 1: Visit Pages ---");
        history.visitPage("https://google.com");
        sleep(10);
        history.visitPage("https://youtube.com");
        sleep(10);
        history.visitPage("https://stackoverflow.com");
        sleep(10);
        history.visitPage("https://github.com");
        history.displayHistory();

        // Scenario 2: Go back and visit new page (delete forward history)
        System.out.println("\n--- Scenario 2: Go Back and Visit New Page ---");
        history.goBack(2);
        history.displayHistory();

        System.out.println("Now visiting Amazon (will delete forward history):");
        history.visitPage("https://amazon.com");
        history.displayHistory();

        // Scenario 3: Navigation
        System.out.println("\n--- Scenario 3: Navigation ---");
        history.visitPage("https://reddit.com");
        history.visitPage("https://twitter.com");
        history.displayHistory();

        history.goBack(3);
        history.displayHistory();

        history.goForward(2);
        history.displayHistory();

        history.goBack(10); // Exceeds available history
        history.displayHistory();

        // Scenario 4: Frequent page tracking
        System.out.println("\n--- Scenario 4: Find Frequent Page ---");
        history.visitPage("https://google.com");
        sleep(10);
        history.visitPage("https://youtube.com");
        sleep(10);
        history.visitPage("https://google.com");
        history.displayHistory();
        history.findFrequentPage();

        // Scenario 5: Clear history
        System.out.println("\n--- Scenario 5: Clear History ---");
        history.clearHistory();
        history.displayHistory();

        System.out.println("Visiting pages after clear:");
        history.visitPage("https://netflix.com");
        history.visitPage("https://spotify.com");
        history.displayHistory();

        System.out.println("\n=== Program Complete ===");
    }

    // Helper method to add a small delay between visits
    private static void sleep(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}