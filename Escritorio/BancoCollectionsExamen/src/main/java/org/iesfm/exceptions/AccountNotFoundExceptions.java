package org.iesfm.exceptions;

public class AccountNotFoundExceptions extends  Exception{

    private final String iban;

    public AccountNotFoundExceptions(String iban) {
        this.iban = iban;
    }

    public String getIbanofAccount () {
        return iban;
    }
}
