package Assignment.Ass4;
import java.util.*;

// Node class representing a webpage
class WebPage {
    String url;
    long timestamp;
    WebPage prev;
    WebPage next;

    public WebPage(String url, long timestamp) {
        this.url = url;
        this.timestamp = timestamp;
        this.prev = null;
        this.next = null;
    }

    @Override
    public String toString() {
        return "WebPage{url='" + url + "', timestamp=" + timestamp + "}";
    }
}
