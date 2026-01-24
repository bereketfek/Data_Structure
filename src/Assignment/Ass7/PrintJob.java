package Assignment.Ass7;

import java.util.*;

class PrintJob {
    int jobId;
    String ownerName;
    int pages;

    PrintJob(int jobId, String ownerName, int pages) {
        this.jobId = jobId;
        this.ownerName = ownerName;
        this.pages = pages;
    }

    public String toString() {
        return "Job-" + jobId + "(" + ownerName + "): " + pages + " pages";
    }
}

class PrinterQueueSimulation {
    public static void main(String[] args) {
        Queue<PrintJob> q = new LinkedList<>();

        q.offer(new PrintJob(1, "Tom", 5));
        q.offer(new PrintJob(2, "Alice", 2));
        q.offer(new PrintJob(3, "Mathew", 10));

        System.out.println("Print Queue: " + Display(q));
        System.out.println("Next job: " + q.peek());
        System.out.println("Processing job: " + q.poll());
        System.out.println("Print Queue: " + Display(q));
    }

    static String Display (Queue<PrintJob> q) {
        StringBuilder sb = new StringBuilder("[");
        Iterator<PrintJob> it = q.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            if (it.hasNext()) sb.append(" ==> ");
        }
        return sb.append("]").toString();
    }
}
