package kk.spybackend.locations.exceptions;

public class LocationNotFoundException extends RuntimeException {

    public LocationNotFoundException(String name) {
        super("Location with name " + name + " not found");
    }
}
