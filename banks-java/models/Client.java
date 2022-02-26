package models;

import tools.BanksException;

public class Client {
    private static int _id = 0;
    public int Id = 0;
    public String nameOfClient;
    public String surnameOfBank;
    public String addressOfBank;
    public String passportOfBank;

    public Client(String name, String surname, String address, String passport) throws BanksException {
        Id = _id++;
        if(name == null) {
            throw new BanksException("Invalid name");
        }
        nameOfClient = name;
        if(surname == null) {
            throw new BanksException("Invalid surname");
        }
        surnameOfBank = surname;
        addressOfBank = address;
        passportOfBank = passport;
    }
    public static void update(String event){
        System.out.print(event);
    }
}