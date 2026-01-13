package Assignment.Ass1;

// ----------------- PART 20: Method Overloading -----------------
class AccessManager {

    public static void requestAccess(AccessCard card, String facility) {
        try {
            if (card.canAccess(facility)) {
                System.out.println(card.getOwner().getName() + " - Access granted to " + facility);
            }
        } catch (AccessDeniedException e) {
            System.out.println(card.getOwner().getName() + " - Access denied to " + facility + ": " + e.getMessage());
        }
    }

    public static void requestAccess(AccessCard card, String facility, String time) {
        System.out.println("Request time: " + time);
        try {
            if (card.canAccess(facility)) {
                System.out.println(card.getOwner().getName() + " - Access granted to " + facility + " at " + time);
            }
        } catch (AccessDeniedException e) {
            System.out.println(card.getOwner().getName() + " - Access denied to " + facility + " at " + time + ": " + e.getMessage());
        }
    }
}
