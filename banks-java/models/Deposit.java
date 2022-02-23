package models;


import services.IAccount;

public class Deposit implements IAccount {
    private double benefit = 0;
    public int idOfDeposit;
    public int timeOfDeposit;
    public double percentOfDeposit;
    public int balanceOfDeposit;

    public Deposit(int id, int balance, int time, double percent) {
        idOfDeposit = id;
        timeOfDeposit = time;
        percentOfDeposit = percent;
        balanceOfDeposit = balance;
    }


    public void withdrawalOperation(int sum) {
        balanceOfDeposit -= sum;
    }

    public void cancelWithdrawalOperation(int sum) {
        balanceOfDeposit += sum;
    }

    public void refillOperation(int sum) {
        balanceOfDeposit += sum;
    }

    public void cancelRefillOperation(int sum) {
        balanceOfDeposit -= sum;
    }

    public void transferOperation(IAccount other, int sum) {
        balanceOfDeposit -= sum;
        other.refillOperation(sum);
    }

    public void cancelTransferOperation(IAccount other, int sum) {
        balanceOfDeposit += sum;
        other.withdrawalOperation(sum);
    }

    public void benefitPay(int time) {
        benefit = balanceOfDeposit * percentOfDeposit / 300;
        balanceOfDeposit += (int) benefit * time;
        benefit = 0;
    }

    public boolean withdraw(int sum) {
        return balanceOfDeposit >= sum && timeOfDeposit == 0;
    }

    public int getAccountId() {
        return idOfDeposit;
    }

    public int checkBalance() {
        return balanceOfDeposit;
    }
}
