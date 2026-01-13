package Assignment.Ass1;

// ----------------- AccessCard Subclasses -----------------
class StudentAccessCard extends AccessCard implements AccessPolicy {
    public StudentAccessCard(Person owner) { super(owner); }

    @Override
    public boolean allowAccess(String facilityName) throws AccessDeniedException {
        switch(facilityName) {
            case "Library":
            case "Computer Lab":
            case "Hostel": return true;
            default: throw new AccessDeniedException(owner.getName() + " cannot access " + facilityName);
        }
    }

    @Override
    public boolean canAccess(String facility) throws AccessDeniedException {
        return allowAccess(facility); // delegate to interface
    }
}