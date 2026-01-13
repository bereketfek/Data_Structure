package Assignment.Ass1;

class VisitorAccessCard extends AccessCard implements AccessPolicy, Chargeable {
    private double fee;
    public VisitorAccessCard(Person owner, double fee) { super(owner); this.fee = fee; }

    @Override
    public boolean allowAccess(String facilityName) throws AccessDeniedException {
        if ("Library".equals(facilityName)) return true;
        else throw new AccessDeniedException(owner.getName() + " cannot access " + facilityName);
    }

    @Override
    public boolean canAccess(String facility) throws AccessDeniedException {
        return allowAccess(facility);
    }

    @Override
    public double getAccessFee() { return fee; }
}