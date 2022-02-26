package models;

import services.EventManager;
import services.IAccount;
import tools.BanksException;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    public EventManager eventManager;
    private List<Client> clients;
    private List<IAccount> accountsOfClient;
    public PercentOfDeposit PercentsOfDeposit;
    public String nameOfBank;
    public double commissionOfCreditOfBank;
    public double limitOfCreditOfBank;
    public double percentOfDebitOfBank;
    public double limitationOfBank;

    public Bank(String name, double commissionOfCredit, double limitOfCredit, double percentOfDebit, double limitation,
                PercentOfDeposit percentOfDeposit) throws BanksException {
        if (percentOfDeposit == null) throw new BanksException("Invalid percents of deposit");
        PercentsOfDeposit = percentOfDeposit;
        if (name == null) throw new BanksException("Invalid name");
        nameOfBank = name;
        commissionOfCreditOfBank = commissionOfCredit;
        limitOfCreditOfBank = limitOfCredit;
        percentOfDebitOfBank = percentOfDebit;
        clients = new ArrayList<>();
        limitationOfBank = limitation;
        accountsOfClient = new ArrayList<>();
        eventManager = new EventManager("Change nameOfBank",
                "Change commissionOfCreditOfBank", "Change commissionOfCreditOfBank",
                "Change limitOfCreditOfBank", "Change percentOfDebitOfBank", "Change limitationOfBank");
    }

    public void addClientInBank(Client client) throws BanksException {
        if (client == null) throw new BanksException("Invalid client");
        if (clients.stream().anyMatch(n -> n.nameOfClient == client.nameOfClient) &&
                clients.stream().anyMatch(n -> n.surnameOfBank == client.surnameOfBank))
            throw new BanksException("Client already in use");
        clients.add(client);
    }

    public void setNameOfBank(String name) {
         this.nameOfBank = name;
         eventManager.notify("Change nameOfBank");
    }
    public String getNameOfBank() {
        return this.nameOfBank;
    }

    public void setCommissionOfCredit(double commissionOfCredit)
    {
        this.commissionOfCreditOfBank = commissionOfCredit;
        eventManager.notify("Change commissionOfCreditOfBank");
    }
    public double getCommissionOfCredit()
    {
        return this.commissionOfCreditOfBank;
    }

    public void setLimitOfCredit(double limitOfCredit)
    {
        this.limitOfCreditOfBank = limitOfCredit;
        eventManager.notify("Change limitOfCreditOfBank");
    }
    public double getLimitOfCredit()
    {
        return this.limitOfCreditOfBank;
    }

    public void setPercentOfDebit(double percentOfDebit)
    {
        this.percentOfDebitOfBank = percentOfDebit;
        eventManager.notify("Change percentOfDebitOfBank");
    }
    public double getPercentOfDebit()
    {
        return this.percentOfDebitOfBank;
    }

    public void setLimitation(double limitation)
    {
        this.limitationOfBank = limitation;
        eventManager.notify("Change limitationOfBank");
    }
    public double getLimitation()
    {
        return this.limitationOfBank;
    }

    public void addDepositInIAccount(Deposit deposit) throws BanksException {
        if (deposit == null) throw new BanksException("Invalid deposit");
        accountsOfClient.add(deposit);
    }

    public void addDebitInIAccount(Debit debit) throws BanksException {
        if (debit == null) throw new BanksException("Invalid debit");
        accountsOfClient.add(debit);
    }

    public void addCreditInIAccount(Credit credit) throws BanksException {
        if (credit == null) throw new BanksException("Invalid credit");
        accountsOfClient.add(credit);
    }

    public boolean isOperationInAccount(int sum) {
        return accountsOfClient.stream().allMatch(x -> x.withdraw(sum));
    }

    public IAccount getAccountId(int id) {
        IAccount account = null;
        for (int i = 0; i < accountsOfClient.size(); i++) {
            if (accountsOfClient.remove(i).getAccountId() == id) account = accountsOfClient.remove(i);
        }
        return account;
    }

    public int countClients() {
        return clients.size();
    }

    public int countAccounts() {
        return accountsOfClient.size();
    }
}
