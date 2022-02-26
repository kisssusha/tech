package models;

import services.IAccount;

public class Debit implements IAccount {
    private double benefit = 0;
    public double Percent;
    public int Balance;
    public int Id;

    public Debit(int balance, double percent, int id) {
        Percent = percent;
        Balance = balance;
        Id = id;
    }


    public void withdrawalOperation(int sum) {

        Balance -= sum;
    }

    public void cancelWithdrawalOperation(int sum) {

        Balance += sum;
    }

    public void refillOperation(int sum) {

        Balance += sum;
    }

    public void cancelRefillOperation(int sum) {

        Balance -= sum;
    }

    public void transferOperation(IAccount account2, int sum) {
        Balance -= sum;
        account2.refillOperation(sum);
    }

    public void cancelTransferOperation(IAccount other, int sum) {
        Balance += sum;
        other.withdrawalOperation(sum);
    }

    public void benefitPay(int time) {
        benefit = Balance * Percent / 300;
        Balance += (int) benefit * time;
        benefit = 0;
    }

    public boolean withdraw(int sum) {

        return Balance >= sum;
    }

    public int getAccountId() {

        return Id;
    }

    public int checkBalance() {

        return Balance;
    }
}
