package org.iesfm;

import java.util.Objects;

public class Client {

    private String name;
    private String surname;
    private String nifClient;
    private int zipCode;

    public Client(String name, String surname, String nifClient, int zipCode) {
        this.name = name;
        this.surname = surname;
        this.nifClient = nifClient;
        this.zipCode = zipCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getNifClient() {
        return nifClient;
    }

    public void setNifClient(String nifClient) {
        this.nifClient = nifClient;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return zipCode == client.zipCode && Objects.equals(name, client.name) && Objects.equals(surname, client.surname) && Objects.equals(nifClient, client.nifClient);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, nifClient, zipCode);
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", nifClient='" + nifClient + '\'' +
                ", zipCode=" + zipCode +
                '}';
    }
}
