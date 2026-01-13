package Assignment.Ass1;

// LibraryMain Program -----------------
public class MainProgram {

        public static void main(String[] args) {
                // Create Persons
                Person student = new Student("Alice", "S101");
                Person faculty = new Faculty("Dr. Smith", "F202");
                Person visitor = new Visitor("John", "V303");

                // Create AccessCards
                AccessCard[] cards = {
                        new StudentAccessCard(student),
                        new FacultyAccessCard(faculty),
                        new VisitorAccessCard(visitor, 50.0)
                };

                // Facilities to test
                String[] facilities = {"Library", "Computer Lab", "Hostel", "Staff Office"};

                // Demonstrate method overriding
                System.out.println("\n--- Method Overriding Demo ---");
                for (AccessCard card : cards) {
                        for (String facility : facilities) {
                                try {
                                        boolean access = card.canAccess(facility);
                                        System.out.println(card.getOwner().getName() + " access to " + facility + ": " + access);
                                } catch (AccessDeniedException e) {
                                        System.out.println(card.getOwner().getName() + " access to " + facility + ": Denied (" + e.getMessage() + ")");
                                }
                        }
                }

                // Demonstrate method overloading
                System.out.println("\n--- Method Overloading Demo ---");
                for (AccessCard card : cards) {
                        AccessManager.requestAccess(card, "Library");
                        AccessManager.requestAccess(card, "Staff Office", "10:30 AM");
                }

                // Demonstrate equals() and hashCode()
                System.out.println("\n--- Equals & HashCode Demo ---");
                Person student2 = new Student("Alice2", "S101");
                System.out.println("student.equals(student2): " + student.equals(student2));
                System.out.println("student.hashCode() == student2.hashCode(): " + (student.hashCode() == student2.hashCode()));
        }
}