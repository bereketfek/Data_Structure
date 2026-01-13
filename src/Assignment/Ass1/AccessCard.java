package Assignment.Ass1;

// ----------------- PART E & F: Abstract AccessCard -----------------
abstract class AccessCard {
    protected Person owner;

    public AccessCard(Person owner) { this.owner = owner; }
    public abstract boolean canAccess(String facility) throws AccessDeniedException;
    public Person getOwner() {
        return owner; }
}