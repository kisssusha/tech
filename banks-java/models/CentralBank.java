package models;

import services.IAccount;
import tools.BanksException;

import java.util.ArrayList;
import java.util.List;

public class CentralBank
{
    private static int countOfId = 0;
    private List<Bank> banks;

    public CentralBank() {

        banks = new ArrayList<>();
    }

    public void registerBank(Bank bank) throws BanksException {
        if (bank == null) throw new BanksException("Invalid Bank");
        banks.add(bank);
    }

    public IAccount creationAccount(Bank bank, int balance, Client client, int time, String option) throws BanksException {
        if (option == null) throw new BanksException("Invalid option");
        if (client == null) throw new BanksException("Invalid client");
        if (bank == null) throw new BanksException("Invalid Bank");
        if (banks.stream().anyMatch(b -> b == bank)) return creationAccountForClient(bank, client, balance, time, option);
        else throw new BanksException("Invalid bank");
    }

    public void checkTime(int time, IAccount account) throws BanksException {
        if (account == null) throw new BanksException("Invalid account");
        account.benefitPay(time);
    }

    public IAccount creationAccountForClient(Bank bank, Client client, int balance, int time, String option) throws BanksException {
        switch (option)
        {
            case "Credit":

                Credit credit = new Credit(countOfId++, bank.commissionOfCreditOfBank, bank.limitOfCreditOfBank, balance);
                bank.addCreditInIAccount(credit);
                return credit;

            case "Debit":

                Debit debit = new Debit(balance, bank.percentOfDebitOfBank, countOfId++);
                bank.addDebitInIAccount(debit);
                return debit;

            case "Deposit":

                double depositPercent = 0;
                int f = 0;
                for ( Integer key : bank.PercentsOfDeposit.percents.keySet() )  {
                f++;
                if (balance < key) {
                    depositPercent = bank.PercentsOfDeposit.percents.get(key);
                }
                if( bank.PercentsOfDeposit.percents.keySet().size() - f == 1 && depositPercent == 0)
                    depositPercent = bank.PercentsOfDeposit.percents.get(key);
            }
                Deposit deposit = new Deposit(countOfId++, balance, time, depositPercent);
            bank.addDepositInIAccount(deposit);
            return deposit;
            default:
                throw new BanksException("Option not found");
        }
    }

    public void refillMoneyOn(Bank bank, int balance, int id) throws BanksException {
        if (bank == null) throw new BanksException("Invalid Bank");
        bank.getAccountId(id).refillOperation(balance);
    }

    public void withdrawalMoney(Bank bank, int balance, int id, Client client) throws BanksException {
        if (!checkClientPassportAndAddress(client) && balance > bank.limitationOfBank && bank.isOperationInAccount(balance)) {
            throw new BanksException("Invalid Withdrawal");
        }
        bank.getAccountId(id).withdrawalOperation(balance);
    }

    public void transferMoneyOnBalance(Bank bank1, int balance, int id1, Bank bank2, int id2, Client client) throws BanksException {
        if (!checkClientPassportAndAddress(client) && balance > bank1.limitationOfBank && bank1.isOperationInAccount(balance)) {
            throw new BanksException("Invalid Transfer");
        }
        bank1.getAccountId(id1).transferOperation(bank2.getAccountId(id2), balance);
    }

    public void cancelRefill(Bank bank, int balance, int id) throws BanksException {
        IAccount operation = bank.getAccountId(id);
        if (operation == null) throw new BanksException("Refill don't exists");
        operation.cancelRefillOperation(balance);
    }

    public void cancelTransfer(Bank bank1, int balance, int id1, Bank bank2, int id2) throws BanksException {
        IAccount operation = bank1.getAccountId(id1);
        if (operation == null) throw new BanksException("Transfer don't exists");
        operation.cancelTransferOperation(bank2.getAccountId(id2), balance);
    }

    public void cancelWithdrawal(Bank bank, int balance, int id) throws BanksException {
        IAccount operation = bank.getAccountId(id);
        if (operation == null) throw new BanksException("Withdrawal don't exists");
        operation.cancelWithdrawalOperation(balance);
    }

    private boolean checkClientPassportAndAddress(Client client) {
        return !client.passportOfBank.isBlank() || !client.passportOfBank.isBlank();
    }
    public int countBanks(){
        return banks.size();
    }
}
