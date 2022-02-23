package services;

import models.Client;
import tools.BanksException;

public class ClientBuilder
{
    private String name;
    private String passport;
    private String surname;
    private String address;

    public ClientBuilder changeName(String name) throws BanksException {
        if(name == null) throw new BanksException("Invalid name");
        this.name = name;
        return this;
    }

    public ClientBuilder changeSurname(String surname) throws BanksException {
        if(surname == null) throw new BanksException("Invalid surname");
        this.surname = surname;
        return this;
    }

    public ClientBuilder changePassport(String passport) throws BanksException {
        if(passport == null) throw new BanksException("Invalid passport");
        this.passport = passport;
        return this;
    }

    public ClientBuilder changeAddress(String address) throws BanksException {
        if(address == null) throw new BanksException("Invalid address");
        this.address = address;
        return this;
    }

    public Client create() throws BanksException {
        return new Client(name, surname, address, passport);
    }
}
