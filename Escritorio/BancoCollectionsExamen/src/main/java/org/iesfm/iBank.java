package org.iesfm;

import org.iesfm.exceptions.AccountNotFoundExceptions;
import org.iesfm.exceptions.CustomerNotFoundException;
import org.iesfm.exceptions.InsufficientFoundsException;

import java.util.List;

public interface iBank {

    //Dado un iban y una cantidad, ingresar la cantidad en la cuenta.
    // Si no existe la cuenta lanzará AccountNotFoundException

    public void transferAmount (String iban, int amountTransfer) throws AccountNotFoundExceptions;

    //Dado un nif, devolver todas las cuentas de ese cliente.
    // Si el cliente no existe lanzar la excepción CustomerNotFoundException

    public List<Account> getAccountofClient (String nif) throws CustomerNotFoundException;

    //Dado un iban y una cantidad, sacar la cantidad en la cuenta.
    // Si no existe la cuenta lanzará AccountNotFoundException,
    // si no hay saldo suficiente lanzará InsufficientFundsException

    public void outMoneyofAccount (String iban, int amount) throws AccountNotFoundExceptions, InsufficientFoundsException;

}
