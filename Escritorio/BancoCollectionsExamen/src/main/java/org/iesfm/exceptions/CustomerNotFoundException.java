package org.iesfm.exceptions;

public class CustomerNotFoundException extends Exception {
    private final String nif;

    public CustomerNotFoundException(String nif) {
        this.nif = nif;
    }

    public String getNif () {
        return nif;
    }
}
