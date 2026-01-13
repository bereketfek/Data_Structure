package Assignment.Ass1;

interface AccessPolicy {
    boolean allowAccess(String facilityName) throws AccessDeniedException;
}