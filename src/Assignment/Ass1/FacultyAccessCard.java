package Assignment.Ass1;

class FacultyAccessCard extends AccessCard implements AccessPolicy {
    public FacultyAccessCard(Person owner) { super(owner); }

    @Override
    public boolean allowAccess(String facilityName) throws AccessDeniedException {
        switch(facilityName) {
            case "Library":
            case "Computer Lab":
            case "Staff Office": return true;
            default: throw new AccessDeniedException(owner.getName() + " cannot access " + facilityName);
        }
    }

    @Override
    public boolean canAccess(String facility) throws AccessDeniedException {
        return allowAccess(facility);
    }
}